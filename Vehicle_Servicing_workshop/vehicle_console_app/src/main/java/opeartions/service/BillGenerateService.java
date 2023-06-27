package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.CustomerDao;
import operations.dao.PartDao;
import operations.dao.ServiceDao;
import operations.models.Bill_templet;
import operations.models.Customer;
import operations.models.Part;
import operations.models.Service;

public class BillGenerateService {

	
	
	public void showBill() throws SQLException {
		Bill_templet bt= new Bill_templet();
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter mobile no:");
		Long mobile=scan.nextLong();
		Customer customer= new Customer();
		customer=CustomerDao.getThatCustomer(mobile);
		int customer_id= customer.getId();
		CustomerVehicleService.DetailsofAllCustomerVehicles(customer_id);
		System.out.println("Enter vehicle_number if exists:");
		String vehicle_number=scan.next();
		bt.setCvd(CustomerVehicleService.hereIsYourVehicle(customer_id,vehicle_number));
		bt.setSr(ServiceRequestService.getServiceRequestByVehicleNumber(bt.getCvd()));
		
		
//------------------------ Printing Everything ------------------------------------------
		System.out.println("-------------------------------------------------------");
		System.out.println(" ");
		System.out.println("        "+bt.getService_Station_name()+"        ");
		
		System.out.println("");
		System.out.println("Customer Name: "+customer.getName()+"     "+"Mobile: "+customer.getMobile());
		System.out.println("Vehicle Number: "+bt.getCvd().getVehicle_number());
		System.out.println("Companey: "+bt.getCvd().getCompany()+"   "+"Model: "+bt.getCvd().getModel());
		System.out.println(" ");
		System.out.println("------------------Parts Details-----------------------");
		List<Service> serviceList = new ArrayList<>();
		ServiceDao.findThisService(serviceList, bt.getSr().getService_request_id());
		for(Service s:serviceList) {
			List<Part> plist = new ArrayList<>();
			PartDao.showListOFPartsForService(plist,s.getService_id());
			for(Part p:plist) {
				System.out.println("Part Name: "+p.getPname()+"       "+"Price: "+p.getPrice());
			}
		}
		
//		System.out.println("--------------------------------------------------------");
//		System.out.println(sr);
		double allLabour_charges=ServiceDao.getLabourCharges(bt.getSr());
		
		double allOil_cost= ServiceDao.getAllOilCost(bt.getSr());
		
		double ServicesBill_amount=ServiceDao.getTotalBillAmount(bt.getSr());
		System.out.println("---------------------BILL AMOUNT-------------------------");
		System.out.println(" ");
		System.out.println("Total Labour Charges: "+allLabour_charges);
		System.out.println("Total Oil Cost: "+allOil_cost);
		System.out.println("Total Bill Amount: "+ServicesBill_amount);
		System.out.println(" ");
	System.out.println("-----------------------------------------------------------------------");
	}
	
	
}
