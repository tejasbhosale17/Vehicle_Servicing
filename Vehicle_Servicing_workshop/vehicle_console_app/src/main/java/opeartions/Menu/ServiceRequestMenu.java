package opeartions.Menu;

import java.util.Scanner;

public class ServiceRequestMenu {
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Service Requests");
		System.out.println("2.Fetch Specific Service Request");
		System.out.println("3.Delete Service Request");
		System.out.println("4.Update Service Request");
		System.out.println("5.Add Service Request");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void ChooseServiceReqMenu() {
	System.out.println("Choose Customer Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				System.out.println("Show all Service Requests");
			break;

		case 2:
				System.out.println("Show this service Requests");
			break;

		case 3:
				
				System.out.println("Delete This Service Requests");
			break;

		case 4:
	
				System.out.println("Update this service Requests");
			break;

		case 5:

				System.out.println("Add Service Requests");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
