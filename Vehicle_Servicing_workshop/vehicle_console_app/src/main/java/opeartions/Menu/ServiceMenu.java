package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.OfferedServicesService;

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
	while((choice = menu())!=EServiceMenu.EXIT) {
		switch (choice) {
		case ALL_SERVICES:
				OfferedServicesService.getAllServices();
			break;

		case SPECIFIC_SERVICES:
			OfferedServicesService.thisServiceThere();
			break;

		case DELETE_SERVICES:
				
			OfferedServicesService.RemoveThisService();
			break;

		case UPDATE_SERVICES:
	
			OfferedServicesService.updateThisService();
			break;

		case ADD_SERVICES:

				System.out.println("Add Service");
			break;

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
