package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.ServiceRequestService;
import operations.models.Customer_Vehicle_Details;
import operations.models.Service_requests;

enum EServiceRequestMenu{
	EXIT,
//	ALL_SERVICES_REQUESTS,SPECIFIC_SERVICES_REQUEST,
//	DELETE_SERVICES_REQUEST,
	ADD_SERVICES_REQUEST,EXISTING_SERVICES_REQUEST,ADD_SERVICE,DEFAULT
}




public class ServiceRequestMenu {
	public static EServiceRequestMenu menu() {
		System.out.println("0.Exit");
//		System.out.println("1.Fetch All Service Requests");
//		System.out.println("2.Fetch Specific Service Request");
//		System.out.println("3.Delete Service Request");
		System.out.println("1.Add New Service Request");
		System.out.println("2.Existing Service Request");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EServiceRequestMenu.values()[6] :EServiceRequestMenu.values()[choice]);
	}
	
public static void ChooseServiceReqMenu() {
	System.out.println("Choose ==SERVICE REQUEST== Operations");
	EServiceRequestMenu choice;
	Scanner scan = new Scanner(System.in);
//-------------------------------------------------------------------------
	Service_requests sr =new Service_requests();
	Customer_Vehicle_Details cvd= new Customer_Vehicle_Details();
	cvd=ServiceRequestService.getServiceRequest();
	if(cvd!=null) {
		System.out.println(cvd);
	}else {
		System.out.println("Solve This!!!");
	}
//-------------------------------------------------------------------------
	
	while((choice = menu())!=EServiceRequestMenu.EXIT) {
		switch (choice) {
//		case ALL_SERVICES_REQUESTS:
//				ServiceRequestService.getAllServiceRequests();
//			break;
//
//		case SPECIFIC_SERVICES_REQUEST:
////			ServiceRequestService.getThisServiceRequest();
//			break;
//
//		case DELETE_SERVICES_REQUEST:
//				
//				System.out.println("Delete This Service Requests");
//			break;
//


		case ADD_SERVICES_REQUEST:
			sr=ServiceRequestService.pushServiceRequest(cvd);
			if(sr!=null) {
				System.out.println("Service Requested Created Succesfully...");
			}
			break;

		case EXISTING_SERVICES_REQUEST:
			
			sr=ServiceRequestService.getServiceRequestByVehicleNumber(cvd);
//			System.out.println("Hii There"+sr);
			ServiceMenu.ChooseServiceMenu(sr);
			break;
		
		case ADD_SERVICE:
			System.out.println("Add Service Here...");
			break;
			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
