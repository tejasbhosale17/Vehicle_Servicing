package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.CustomerService;
import opeartions.service.CustomerVehicleService;
import opeartions.service.OfferedServicesService;
import opeartions.service.VehicleService;

enum EServiceMenu{
	EXIT,ALL_SERVICES,SPECIFIC_SERVICES,
	DELETE_SERVICES,UPDATE_SERVICES,ADD_SERVICES,DEFAULT
}


public class ServiceMenu {
	
	public static EServiceMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Services");
		System.out.println("2.Fetch Specific Service");
		System.out.println("3.Delete Service");
		System.out.println("4.Update Service");
		System.out.println("5.Add Service");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EServiceMenu.values()[6] :EServiceMenu.values()[choice]);
	}
	
public static void ChooseServiceMenu() {
	System.out.println("Choose SERVICE Operations");
	EServiceMenu choice;
	Scanner scan = new Scanner(System.in);
	
	//int cid=CustomerService.customerFromMobile();
	VehicleService.addVehicleUsingMobile();
	
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

		case DELETE_SERVICES:
			System.out.println("Deleting this Service");
			OfferedServicesService.RemoveThisService();
			break;

		case UPDATE_SERVICES:
			System.out.println("Updating This Service");
			OfferedServicesService.updateThisService();
			break;

		case ADD_SERVICES:
			System.out.println("Add This Service");
			OfferedServicesService.addTheService();
			break;

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
