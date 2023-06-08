package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.VehicleService;

enum EVehicleMenu{
	EXIT,ALL_VEHICLES,SPECIFIC_VEHICLE,
	DELETE_VEHICLE,UPDATE_VEHICLE,ADD_VEHICLE,DEFAULT
}



public class VehicleMenu {

	public static EVehicleMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All vehicles");
		System.out.println("2.Fetch Specific vehicle");
		System.out.println("3.Delete vehicle");
		System.out.println("4.Update vehicle");
		System.out.println("5.Add vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EVehicleMenu.values()[6] :EVehicleMenu.values()[choice]);
	}
		
	public static void ChooseVehicleMain() {
		System.out.println("Choose Vehicle Operations");
		EVehicleMenu choice;
		Scanner scan = new Scanner(System.in);
		while((choice= menu())!=EVehicleMenu.EXIT) {
			switch (choice) {
			case ALL_VEHICLES:
					VehicleService.getAllVehicles();
					System.out.println("");
				break;

			case SPECIFIC_VEHICLE:
				VehicleService.getSpecificVehicle();
				System.out.println("");
				break;

			case DELETE_VEHICLE:
				VehicleService.removeVehicle();
				System.out.println("");
				break;

			case UPDATE_VEHICLE:
				VehicleService.updateVehicle();
				System.out.println("");
				break;

			case ADD_VEHICLE:
				VehicleService.addVehicle();
				System.out.println("");
				break;

				
			case DEFAULT:
				System.out.println("Wrong choice entered..:(");
				break;
			}
		}
	
	}

}