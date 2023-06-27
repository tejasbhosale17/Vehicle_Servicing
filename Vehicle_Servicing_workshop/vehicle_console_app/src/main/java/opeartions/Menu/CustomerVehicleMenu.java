package opeartions.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import opeartions.service.CustomerVehicleService;

enum ECVMenu{
	EXIT,ALL_CUSTOMER_VEHICLES,SPECIFIC_CUSTOMER_VEHICLE,
	DELETE_CUSTOMER_VEHICLE,UPDATE_CUSTOMER_VEHICLE,
	ADD_CUSTOMER_VEHICLE,DEFAULT
}

public class CustomerVehicleMenu {
	static CustomerVehicleService cvService =new CustomerVehicleService();
	
	public static ECVMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Customer Vehicles");
		System.out.println("2.Fetch Specific Customer Vehicle");
		System.out.println("3.Delete Customer Vehicle");
		System.out.println("4.Update Customer Vehicle");
		System.out.println("5.Add Customer Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? ECVMenu.values()[6] :ECVMenu.values()[choice]);
	}
		
	public static void ChooseCustomerVehicleMain() throws SQLException {
		System.out.println("Choose Customer Vehicle Operations");
		ECVMenu choice;
		Scanner scan = new Scanner(System.in);
		while((choice = menu())!=ECVMenu.EXIT) {
			switch (choice) {
			case ALL_CUSTOMER_VEHICLES:
				cvService.getAllCustVehicles();
				System.out.println("");
				break;

			case SPECIFIC_CUSTOMER_VEHICLE:
				cvService.findThisVehicle();
				System.out.println("");
				break;

			case DELETE_CUSTOMER_VEHICLE:
				cvService.removeCustVehicle();
				System.out.println("");
				break;

			case UPDATE_CUSTOMER_VEHICLE:
				cvService.updateCustVehicle();
				System.out.println("");
				break;

			case ADD_CUSTOMER_VEHICLE:
				cvService.addCustVehicle();
				System.out.println("");
				break;

				
			case DEFAULT:
				System.out.println("Wrong choice entered..:(");
				break;
			}
		}
	
	}
}
