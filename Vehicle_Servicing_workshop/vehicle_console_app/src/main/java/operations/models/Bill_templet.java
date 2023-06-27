package operations.models;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import opeartions.service.CustomerVehicleService;
import opeartions.service.ServiceRequestService;
import operations.dao.CustomerDao;
import operations.dao.PartDao;
import operations.dao.ServiceDao;

public class Bill_templet {

	protected String Service_Station_name="Vehicle Service Station";
	protected Date Service_date;
	protected Customer c;
	protected Customer_Vehicle_Details cvd;
	protected Part p;
	protected Service_requests sr;
	
	public Bill_templet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill_templet(String service_Station_name, Date service_date, Customer c, Customer_Vehicle_Details cvd,
			Part p, Service_requests sr) {
		super();
		Service_Station_name = service_Station_name;
		Service_date = service_date;
		this.c = c;
		this.cvd = cvd;
		this.p = p;
		this.sr = sr;
	}

	public String getService_Station_name() {
		return Service_Station_name;
	}

	public void setService_Station_name(String service_Station_name) {
		Service_Station_name = service_Station_name;
	}

	public Date getService_date() {
		return Service_date;
	}

	public void setService_date(Date service_date) {
		Service_date = service_date;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public Customer_Vehicle_Details getCvd() {
		return cvd;
	}

	public void setCvd(Customer_Vehicle_Details cvd) {
		this.cvd = cvd;
	}

	public Part getP() {
		return p;
	}

	public void setP(Part p) {
		this.p = p;
	}

	public Service_requests getSr() {
		return sr;
	}

	public void setSr(Service_requests sr) {
		this.sr = sr;
	}

	@Override
	public String toString() {
		return "Bill_templet [Service_Station_name=" + Service_Station_name + ", Service_date=" + Service_date + ", c="
				+ c + ", cvd=" + cvd + ", p=" + p + ", sr=" + sr + "]";
	}

	
//	public void showBill() throws SQLException {
//		Scanner scan= new Scanner(System.in);
//		System.out.println("Enter mobile no:");
//		Long mobile=scan.nextLong();
//		Customer customer= new Customer();
//		customer=CustomerDao.getThatCustomer(mobile);
//		int customer_id= customer.getId();
//		CustomerVehicleService.DetailsofAllCustomerVehicles(customer_id);
//		System.out.println("Enter vehicle_number if exists:");
//		String vehicle_number=scan.next();
//		cvd=CustomerVehicleService.hereIsYourVehicle(customer_id,vehicle_number);
//		sr=ServiceRequestService.getServiceRequestByVehicleNumber(cvd);
//		
//		
////------------------------ Printing Everything ------------------------------------------
//		System.out.println("-------------------------------------------------------");
//		System.out.println(" ");
//		System.out.println("        "+Service_Station_name+"        ");
//		
//		System.out.println("");
//		System.out.println("Customer Name: "+customer.getName()+"     "+"Mobile: "+customer.getMobile());
//		System.out.println("Vehicle Number: "+cvd.getVehicle_number());
//		System.out.println("Companey: "+cvd.getCompany()+"   "+"Model: "+cvd.getModel());
//		System.out.println(" ");
//		System.out.println("------------------Parts Details-----------------------");
//		List<Service> serviceList = new ArrayList<>();
//		ServiceDao.findThisService(serviceList, sr.getService_request_id());
//		for(Service s:serviceList) {
//			List<Part> plist = new ArrayList<>();
//			PartDao.showListOFPartsForService(plist,s.getService_id());
//			for(Part p:plist) {
//				System.out.println("Part Name: "+p.getPname()+"       "+"Price: "+p.getPrice());
//			}
//		}
//		
////		System.out.println("--------------------------------------------------------");
////		System.out.println(sr);
//		double allLabour_charges=ServiceDao.getLabourCharges(sr);
//		
//		double allOil_cost= ServiceDao.getAllOilCost(sr);
//		
//		double ServicesBill_amount=ServiceDao.getTotalBillAmount(sr);
//		System.out.println("---------------------BILL AMOUNT-------------------------");
//		System.out.println(" ");
//		System.out.println("Total Labour Charges: "+allLabour_charges);
//		System.out.println("Total Oil Cost: "+allOil_cost);
//		System.out.println("Total Bill Amount: "+ServicesBill_amount);
//		System.out.println(" ");
//	System.out.println("-----------------------------------------------------------------------");
//	}
	//For update Service request BIll use 
	//String SQL="update service_requests set bill_amount=(select sum(total_cost)as 'total_bill_amount' from services where service_request_id=1);";
}
