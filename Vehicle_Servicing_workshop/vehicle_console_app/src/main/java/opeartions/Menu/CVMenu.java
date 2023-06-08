package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.CustomerVehicleService;


public class CVMenu {
	static CustomerVehicleService cvService =new CustomerVehicleService();
	
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Customer Vehicles");
		System.out.println("2.Fetch Specific Customer Vehicle");
		System.out.println("3.Delete Customer Vehicle");
		System.out.println("4.Update Customer Vehicle");
		System.out.println("5.Add Customer Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
		
	public static void CustVehicleMain() {
		System.out.println("Choose Customer Vehicle Operations");
		int choice;
		Scanner scan = new Scanner(System.in);
		while((choice = menu())!=0) {
			switch (choice) {
			case 1:
				cvService.getAllCustVehicles();
				System.out.println("");
				break;

			case 2:
				cvService.getSpecificCustVehicle();
				System.out.println("");
				break;

			case 3:
				cvService.removeCustVehicle();
				System.out.println("");
				break;

			case 4:
				cvService.updateCustVehicle();
				System.out.println("");
				break;

			case 5:
				cvService.addCustVehicle();
				System.out.println("");
				break;

				
			default:
				System.out.println("Wrong choice entered..:(");
				break;
			}
		}
	
	}
}
