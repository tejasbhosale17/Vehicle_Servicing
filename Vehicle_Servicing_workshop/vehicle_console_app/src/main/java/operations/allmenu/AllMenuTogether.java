package operations.allmenu;

import java.util.Scanner;

import opeartions.service.CustomerService;
import opeartions.service.PartService;
import opeartions.service.VehicleService;

public class AllMenuTogether {
	
	public static int cmenu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Customers");
		System.out.println("2.Fetch Specific Customer");
		System.out.println("3.Delete Customer");
		System.out.println("4.Update Customer");
		System.out.println("5.Add Customer");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void ChooseCustomerMain() {
	System.out.println("Choose Customer Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = cmenu())!=0) {
		switch (choice) {
		case 1:
				CustomerService.getAllCustomers();
				System.out.println("");
			break;

		case 2:
				CustomerService.getSpecificCustomer();
				System.out.println("");
			break;

		case 3:
				CustomerService.removeCustomer();
				System.out.println("");
			break;

		case 4:
				CustomerService.updateCustomer();
				System.out.println("");
			break;

		case 5:
				CustomerService.addCustomer();
				System.out.println("");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
//------------------------------------------------------------------------------------


public static int vmenu() {
	System.out.println("0.Exit");
	System.out.println("1.Fetch All vehicles");
	System.out.println("2.Fetch Specific vehicle");
	System.out.println("3.Delete vehicle");
	System.out.println("4.Update vehicle");
	System.out.println("5.Add vehicle");
	System.out.print("Enter your choice = ");
	System.out.println("");
	return new Scanner(System.in).nextInt();
}
	
public static void ChooseVehicleMain() {
	System.out.println("Choose Vehicle Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = vmenu())!=0) {
		switch (choice) {
		case 1:
				VehicleService.getAllVehicles();
				System.out.println("");
			break;

		case 2:
			VehicleService.getSpecificVehicle();
			System.out.println("");
			break;

		case 3:
			VehicleService.removeVehicle();
			System.out.println("");
			break;

		case 4:
			VehicleService.updateVehicle();
			System.out.println("");
			break;

		case 5:
			VehicleService.addVehicle();
			System.out.println("");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
//------------------------------------------------------------------------------------
public static int cvmenu() {
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
	
public static void ChooseCustomerVehicleMain() {
	System.out.println("Choose Customer Vehicle Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = cvmenu())!=0) {
		switch (choice) {
		case 1:
			
			System.out.println("");
			break;

		case 2:
			
			System.out.println("");
			break;

		case 3:
			
			System.out.println("");
			break;

		case 4:
			
			System.out.println("");
			break;

		case 5:
			
			System.out.println("");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
//----------------------------------------------------------------------------------

public static int smenu() {
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
while((choice = smenu())!=0) {
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

//---------------------------------------------------------------------------
public static int paymenu() {
	System.out.println("0.Exit");
	System.out.println("1.Prepare & Display Bill");
	System.out.println("2.Get Payment Form Customer");
	System.out.println("3.Add Payment");
//	System.out.println("4.Update Service");
//	System.out.println("5.Add Service");
	System.out.print("Enter your choice = ");
	System.out.println("");
	return new Scanner(System.in).nextInt();
}

public static void ChoosePaymentMenu() {
System.out.println("Choose Payment Operations");
int choice;
Scanner scan = new Scanner(System.in);
while((choice = paymenu())!=0) {
	switch (choice) {
	case 1:
			System.out.println("Show all Payments");
		break;

	case 2:
			System.out.println("Show this Payment");
		break;
//
//	case 3:
//			
//			System.out.println("Delete This Payment");
//		break;
//
//	case 4:
//
//			System.out.println("Update this Payment");
//		break;

	case 3:

			System.out.println("Add Payment");
		break;

		
	default:
		System.out.println("Wrong choice entered..:(");
		break;
	}
}
}
//------------------------------------------------------------------------------------
public static int partmenu() {
	System.out.println("0.Exit");
	System.out.println("1.Fetch All Parts");
	System.out.println("2.Fetch Specific Part");
	System.out.println("3.Delete Part");
	System.out.println("4.Update Part");
	System.out.println("5.Add part");
	System.out.print("Enter your choice = ");
	System.out.println("");
	return new Scanner(System.in).nextInt();
}

public static void ChoosePartMain() {
System.out.println("Choose Part Operations");
int choice;
Scanner scan = new Scanner(System.in);
while((choice = partmenu())!=0) {
	switch (choice) {
	case 1:
			PartService.getAllParts();
			System.out.println("");
		break;

	case 2:
		PartService.getSpecificPart();
		System.out.println("");
		break;

	case 3:
		PartService.removePart();
		System.out.println("");
		break;

	case 4:
		PartService.updatePart();
		System.out.println("");
		break;

	case 5:
		PartService.addPart();
		System.out.println("");
		break;

		
	default:
		System.out.println("Wrong choice entered..:(");
		break;
	}
}
}
//-------------------------------------------------------------------------------

public static void TodaysBusiness() {
	System.out.println("Shop khuli nhai aur agaye kitna kamaya dekhne!! ");
}

//----------------------------------------------------------------------------------

public static void givenDateBusiness() {
	System.out.println("denge wo bhi denge pahile dhanda chalu hone do!!!");
}

}
