package opeartions.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import opeartions.service.CustomerService;
import opeartions.service.CustomerVehicleService;
import opeartions.service.OfferedServicesService;
import opeartions.service.VehicleService;
import operations.models.Service_requests;

enum EServiceMenu{
	EXIT,
//	ADD_SERVICES,
	MAINTAINANCE,OIL,REPAIR,
//	ALL_SERVICES,SPECIFIC_SERVICES,
//	DELETE_SERVICES,UPDATE_SERVICES,
	DEFAULT
}


public class ServiceMenu {
	
	public static EServiceMenu menu() {
		System.out.println("0.Exit");
//		System.out.println("1.Fetch All Services");
//		System.out.println("2.Fetch Specific Service");
//		System.out.println("3.Delete Service");
//		System.out.println("4.Update Service");
//		System.out.println("1.Add Service");
		System.out.println("1.Mainatainance");
		System.out.println("2.Oil");
		System.out.println("3.Repair");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EServiceMenu.values()[6] :EServiceMenu.values()[choice]);
	}
	
public static void ChooseServiceMenu(Service_requests sr) throws SQLException {
	System.out.println("Choose SERVICE Operations");
	EServiceMenu choice;
	Scanner scan = new Scanner(System.in);
	String vehicle_number=sr.getVehicle_number();
	System.out.println("==========Process Requests===========");
//	Service_requests sr =new Service_requests();
	//int cid=CustomerService.customerFromMobile();
//	VehicleService.addVehicleUsingMobile();
	
	while((choice = menu())!=EServiceMenu.EXIT) {
		switch (choice) {
//		case ALL_SERVICES:
//			System.out.println("Show all Services");
//				OfferedServicesService.getAllServices();
//			break;
//
//		case SPECIFIC_SERVICES:
//			System.out.println("This is your Service");
//			OfferedServicesService.thisServiceThere();
//			break;
		

//		case DELETE_SERVICES:
//			System.out.println("Deleting this Service");
//			OfferedServicesService.RemoveThisService();
//			break;
//
//		case UPDATE_SERVICES:
//			System.out.println("Updating This Service");
//			OfferedServicesService.updateThisService();
//			break;

		case MAINTAINANCE:
			System.out.println("Add This Service");
			System.out.println("Mainatainance...");
//			System.out.println("printing from add service"+sr);
			OfferedServicesService.addThisServiceByMaintainance(sr);
			break;

			case OIL:
			System.out.println("Oil");
			OfferedServicesService.addThisServiceByOil(sr);
			break;
			
			case REPAIR:
			OfferedServicesService.addThisServiceByRepair(sr);
			break;
			

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
