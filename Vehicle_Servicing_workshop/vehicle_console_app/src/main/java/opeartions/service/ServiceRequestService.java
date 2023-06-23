package opeartions.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServiceRequestDao;
import operations.models.Customer_Vehicle_Details;
import operations.models.Service;
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
	public static Service_requests getServiceRequestByVehicleNumber(Customer_Vehicle_Details cvd) {
		String vehicle_number=cvd.getVehicle_number();
		Service_requests sqr = new Service_requests();
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			List<Service_requests> srlist = new ArrayList<>();
			serviceRequestDao.findServiceRequestByVehicleNumber(srlist,vehicle_number);
			for(Service_requests sr:srlist) {
				System.out.println(sr);
			}
			System.out.println("Enter Service_reques_id to choose a service:");
			
			sqr=serviceRequestDao.findThisServiceRequest(scan.nextInt());
			System.out.println("Your Service Request is: ");
			System.out.println(sqr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sqr;
	}
//------------------------------------------------------------------------------------------
	
	public static void updateServiceRequest(Customer_Vehicle_Details cvd) {
//		System.out.println("Enter vehicle number");
//		String vehicle_number=scan.next();
		String vehicle_number=cvd.getVehicle_number();
	//	getServiceRequestByVehicleNumber(vehicle_number);
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
//	getServiceRequestByVehicleNumber(vehicle_number);
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
	
public static void addServiceRequest(int service_request_id,String vehicle_number) {
//	getServiceRequestByVehicleNumber(vehicle_number);
	int isAdded=0;
//	System.out.println("If your service exists enter service_request_id or enter 0:");
//	int service_request_id=scan.nextInt();
//	if(service_request_id>0) {
//		getThisServiceRequest(service_request_id);
//	}else {		
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			
			isAdded=serviceRequestDao.addThisServiceRequest(service_request_id,vehicle_number);
			if(isAdded>0) {
				System.out.println("Service Added Succesfully...");
			}else {
				System.out.println("Unsuccesfully Service Add....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//}
}


public static Service_requests pushServiceRequest(Customer_Vehicle_Details cvd) {
	String vehicle_number=cvd.getVehicle_number();
	int isInserted=0;
	try {
		ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
		Service_requests sr =new Service_requests();
		sr=serviceRequestDao.pushingThisServiceRequest(vehicle_number);
		if(sr!=null) {
			System.out.println(sr);
			return sr;
		}else {
			System.out.println("Some Error in PushServiceRequest");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return null;
}

//=========================================================================================================================================

public static Customer_Vehicle_Details getServiceRequest() {
	int customer_id=CustomerService.customerFromMobile();
	CustomerVehicleService.DetailsofAllCustomerVehicles(customer_id);
//	System.out.println("Enter vehicle_id if exists:");
//	int vid=scan.nextInt();
	System.out.println("Enter vehicle_number if exists:");
	String vehicle_number=scan.next();
	int vid=CustomerVehicleService.findVidOfThisVehicle(vehicle_number);
	Customer_Vehicle_Details cvd = new Customer_Vehicle_Details();
	if(vid!=0) {
		cvd=CustomerVehicleService.hereIsYourVehicle(customer_id,vehicle_number);
	}else {
		CustomerVehicleService.AddThisCustomerVehicle(vehicle_number,customer_id);
//		VehicleService.getAllVehicles();
		cvd=CustomerVehicleService.hereIsYourVehicle(customer_id,vehicle_number);
	}
	return cvd;
}
	
//---------------LIST OF EXISTING SERVICES FOR CURRENTDATE-----------------------

//---------------------LIST of ALL Service Requests for Perticular Date----------

//public static Service_requests ListOfServiceRequestsForDate() {
//	int service_request_id=0;
//	List<Service> serviceList = new ArrayList<>();
//	try {
//		ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
//		List<Service_requests> srList = new ArrayList<>();
//		System.out.println("Here is the list of Services for today:");
//		serviceRequestDao.ListServiceRequestsForDate(srList);
//		for(Service_requests s: srList) {
//			System.out.println(s);
//		}
//		System.out.println("Enter service_request_id:");
//		service_request_id=scan.nextInt();
//		for(Service_requests s: srList) {
//			if(service_request_id ==s.getService_request_id()) 
//			{
//				return s;
//			}
//		}
//		serviceList=OfferedServicesService.thisServiceThere(serviceList,service_request_id);
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	return null;
//	
//}
//-------------To find services of perticular service Request----------------------------------------------------------	
public static void ListOfServiceRequestsForDate(Service_requests sr) {
	int service_request_id;
	String vehicle_number=sr.getVehicle_number();
	List<Service> serviceList = new ArrayList<>();
//	try {
//		ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
//		List<Service_requests> srList = new ArrayList<>();
//		System.out.println("Here is the list of Services for today:");
//		serviceRequestDao.ListServiceRequestsForDate(srList);
//		for(Service_requests s: srList) {
//			System.out.println(s);
//		}
//		System.out.println("Enter service_request_id to  choose:");
//			service_request_id=scan.nextInt();
//			for(Service_requests s: srList) 
//			{
//				if(service_request_id ==sr.getService_request_id()) 
//				{
					System.out.println(sr);
					serviceList=OfferedServicesService.thisServiceThere(serviceList,sr.getService_request_id());
					sr.setServiceList(serviceList);
					//below code is for printing only
//					List<Service> servList= new ArrayList<>();
//					servList=sr.getServiceList();
////					System.out.println("printing from SRservice ListofSRD:");
//					for(Service serv:servList)
//					{
//						System.out.println(serv);
//					}
//					return s;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	return null;
}

}
