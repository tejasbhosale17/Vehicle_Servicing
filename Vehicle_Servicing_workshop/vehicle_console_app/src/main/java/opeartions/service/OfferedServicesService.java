package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServiceDao;

import operations.models.Service;

public class OfferedServicesService {

	static Scanner scan = new Scanner(System.in);
	
//	public static void getAllServices(){
//		List<Service> serviceList = new ArrayList<>();
//		try {
//			ServiceDao serviceDao = new ServiceDao();
//			serviceDao.getAllservices(serviceList);
//			for(Service s: serviceList) 
//			{
//				System.out.println("1"+s);
//			}
//		} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
//	}
////------------------------------------------------------------------------------------------
//	public static void thisServiceThere() {
//		try {
//			System.out.println("Enter Service_id:");
//			int sid=scan.nextInt();
//			ServiceDao serviceDao = new ServiceDao();
//			Service s=serviceDao.findThisService(sid);
//			if(s!=null) {
//				System.out.println("Service Already Exists!!");
//				System.out.println(s);
//			}else {
//				System.out.println("Service Does not Exists!!");
//			}
//		} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}	
//	}
//------------------------------------------------------------------------------------------
	public static void RemoveThisService() {
		int sid=scan.nextInt();
		int isRemoved=0;
		try {
			ServiceDao serviceDao  =new ServiceDao();
			isRemoved=serviceDao.deleteThisService(sid);
			if(isRemoved > 0) {
				System.out.println("Service Removed!!");
			}else {
				System.out.println("Service Does not exists!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//-------------------------------------------------------------------------------------
	
	public static void updateThisService() {
		System.out.println("enter service_id of the service want to update:");
		int sid=scan.nextInt();
		System.out.println("enter labour_charges and total_charges want to change:");
		double lc=scan.nextInt();
		double tc=scan.nextInt();
		int isUpdated=0;
		try {
			ServiceDao serviceDao  =new ServiceDao();
			isUpdated=serviceDao.updateThisService(sid,lc,tc);
			if(isUpdated > 0) {
				System.out.println("Service Exists and Updated!!");
			}else {
				System.out.println("Service Does Not Exists!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//-------------------------------------------------------------------------------------
	public static void addTheService() {
		System.out.println("Enter service_id,type,oil_charges,labour charges,total_amount,remark,service_request_id");
		int isAdded=0;
		int service_id=scan.nextInt();
		System.out.println("choose type: oil/maintainance");
		String type=scan.next();
		double oil_cost=scan.nextDouble();
		double labour_charges=scan.nextDouble();
		double total_cost=scan.nextDouble();
		System.out.println("Enter remark");
		scan.nextLine();
		String remark=scan.nextLine();
		System.out.println("Enter vehicle number");
		String vehicle_number=scan.next();
		ServiceRequestService.getServiceRequestByVehicleNumber(vehicle_number);
		System.out.println("Enter Service request id");
		int service_request_id=scan.nextInt();
		double bill_amount=oil_cost+labour_charges;
		
//		ServiceRequestService.addServiceRequest(service_request_id, vehicle_number, bill_amount);
		try {
			ServiceDao serviceDao  =new ServiceDao();
			isAdded=serviceDao.addThisService(service_id, type, oil_cost, labour_charges, total_cost, remark, service_request_id);
			if(isAdded>0) {
				System.out.println("Service Inserted Succesfully...");
			}else {
				System.out.println("Insertion of Service Unsuccesfull...");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
//------------------------------------------------------------------------------
	
	public static void addingThisService() {
		System.out.println("Enter service_id,type,oil_charges,labour charges,total_amount,remark,service_request_id");
		int isAdded=0;
		try {
			ServiceDao serviceDao  =new ServiceDao();
			System.out.println("Enter remark first");
			String remark=scan.nextLine();
			serviceDao.addThisService(scan.nextInt(), scan.next(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), remark, scan.nextInt());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

