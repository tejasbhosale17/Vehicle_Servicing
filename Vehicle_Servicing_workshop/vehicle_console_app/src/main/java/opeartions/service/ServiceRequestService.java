package opeartions.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServiceRequestDao;
import operations.models.Service_requests;

public class ServiceRequestService {

	static Scanner scan = new Scanner(System.in);
	
	public static void getAllServiceRequests() {
		List<Service_requests> srlist =new ArrayList<>();
		ServiceRequestDao serviceRequestDao;
		try {
			serviceRequestDao = new ServiceRequestDao();
			serviceRequestDao.listAllServiceRequests(srlist);
			for(Service_requests sr:srlist) {
				System.out.println(sr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//---------------------------------------------------------------------------------------------------
	public static void getThisServiceRequest(int srid) {
		
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			Service_requests sr=serviceRequestDao.findThisServiceRequest(srid);
			if(sr!=null) {
				System.out.println("Service Request Exists!!");
				System.out.println(sr);
			}else {
				System.out.println("Service Request Does Not Exists!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//------------------------------------------------------------------------------------------
	public static void getServiceRequestByVehicleNumber(String vehicle_number) {
//		System.out.println("Enter vehicle number");
//		String vehicle_number=scan.next();
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			List<Service_requests> srlist = new ArrayList<>();
			serviceRequestDao.findServiceRequestByVehicleNumber(srlist,vehicle_number);
			for(Service_requests sr:srlist) {
				System.out.println(sr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//------------------------------------------------------------------------------------------
	
	public static void updateServiceRequest(String vehicle_number) {
//		System.out.println("Enter vehicle number");
//		String vehicle_number=scan.next();
		getServiceRequestByVehicleNumber(vehicle_number);
		int isUpdated=0;
		System.out.println("If your service exists enter service_request_id:");
		int service_request_id=scan.nextInt();
		System.out.println("Enter bill_amount to update:");
		double bill_amount=scan.nextDouble();
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			isUpdated=serviceRequestDao.updateThisServiceRequest(service_request_id,bill_amount);
			if(isUpdated>0) {
				System.out.println("Bill_amount updated...");
			}else {
				System.out.println("unsuccesfully Bill_amount updated...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//----------------------------------------------------------------------------------
	
	public static void deleteThisServiceRequest(String vehicle_number) {
		getServiceRequestByVehicleNumber(vehicle_number);
		int isDeleted=0;
		System.out.println("If your service exists enter service_request_id:");
		int service_request_id=scan.nextInt();
		
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			isDeleted=serviceRequestDao.deleteThisServiceRequest(service_request_id);
			if(isDeleted>0) {
				System.out.println("Service Request Deleted...");
			}else {
				System.out.println("Can not delete service request...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

//-------------------------------------------------------------------------------------
	
	public static void addServiceRequest(String vehicle_number) {
		getServiceRequestByVehicleNumber(vehicle_number);
		int isAdded=0;
		double bill_amount=0;
		System.out.println("If your service exists enter service_request_id or enter 0:");
		int service_request_id=scan.nextInt();
		if(service_request_id>0) {
			getThisServiceRequest(service_request_id);
		}else {
			System.out.println("Enter service_request_id,vehicle_number,bill_amount");
			
			try {
				ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
				
				isAdded=serviceRequestDao.addThisServiceRequest(service_request_id,vehicle_number,bill_amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
