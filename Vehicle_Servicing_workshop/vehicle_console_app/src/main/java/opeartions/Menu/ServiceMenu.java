package opeartions.Menu;

import java.util.Scanner;



public class ServiceMenu {
	
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Services");
		System.out.println("2.Fetch Specific Service");
		System.out.println("3.Delete Service");
		System.out.println("4.Update Service");
		System.out.println("5.Add Service");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void ChooseServiceMenu() {
	System.out.println("Choose Customer Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				System.out.println("Show all Services");
			break;

		case 2:
				System.out.println("Show this service");
			break;

		case 3:
				
				System.out.println("Delete This Service");
			break;

		case 4:
	
				System.out.println("Update this service");
			break;

		case 5:

				System.out.println("Add Service");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
