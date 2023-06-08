package opeartions.Menu;

import java.util.Scanner;

enum EServiceRequestMenu{
	EXIT,ALL_SERVICES_REQUESTS,SPECIFIC_SERVICES_REQUEST,
	DELETE_SERVICES_REQUEST,UPDATE_SERVICES_REQUEST,ADD_SERVICES_REQUEST,DEFAULT
}




public class ServiceRequestMenu {
	public static EServiceRequestMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Service Requests");
		System.out.println("2.Fetch Specific Service Request");
		System.out.println("3.Delete Service Request");
		System.out.println("4.Update Service Request");
		System.out.println("5.Add Service Request");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EServiceRequestMenu.values()[6] :EServiceRequestMenu.values()[choice]);
	}
	
public static void ChooseServiceReqMenu() {
	System.out.println("Choose Customer Operations");
	EServiceRequestMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=EServiceRequestMenu.EXIT) {
		switch (choice) {
		case ALL_SERVICES_REQUESTS:
				System.out.println("Show all Service Requests");
			break;

		case SPECIFIC_SERVICES_REQUEST:
				System.out.println("Show this service Requests");
			break;

		case DELETE_SERVICES_REQUEST:
				
				System.out.println("Delete This Service Requests");
			break;

		case UPDATE_SERVICES_REQUEST:
	
				System.out.println("Update this service Requests");
			break;

		case ADD_SERVICES_REQUEST:

				System.out.println("Add Service Requests");
			break;

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
