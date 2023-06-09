package operations.allmenu;

import java.util.Scanner;


import opeartions.service.CustomerService;
import opeartions.service.CustomerVehicleService;
import opeartions.service.OfferedServicesService;
import opeartions.service.PartService;
import opeartions.service.VehicleService;

enum ECustomerMenu{
	EXIT,ALL_CUSTOMERS,SPECIFIC_CUSTOMER,
	DELETE_CUSTOMER,UPDATE_CUSTOMER,ADD_CUSTOMER,DEFAULT
}


enum EVehicleMenu{
	EXIT,ALL_VEHICLES,SPECIFIC_VEHICLE,
	DELETE_VEHICLE,UPDATE_VEHICLE,ADD_VEHICLE,DEFAULT
}

enum ECVMenu{
	EXIT,ALL_CUSTOMER_VEHICLES,SPECIFIC_CUSTOMER_VEHICLE,
	DELETE_CUSTOMER_VEHICLE,UPDATE_CUSTOMER_VEHICLE,
	ADD_CUSTOMER_VEHICLE,DEFAULT
}

enum EServiceMenu{
	EXIT,ALL_SERVICES,SPECIFIC_SERVICES,
	DELETE_SERVICES,UPDATE_SERVICES,ADD_SERVICES,DEFAULT
}

enum EPartMenu{
	EXIT,ALL_PARTS,SEPCIFIC_PART,
	DELETE_PART,UPDATE_PART,ADD_PART,DEFAULT
}




public class AllMenuTogether {
	
	public static ECustomerMenu cmenu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Customers");
		System.out.println("2.Fetch Specific Customer");
		System.out.println("3.Delete Customer");
		System.out.println("4.Update Customer");
		System.out.println("5.Add Customer");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? ECustomerMenu.values()[6] :ECustomerMenu.values()[choice]);
	}
	
	
public static void ChooseCustomerMain() {
	System.out.println("Choose Customer Operations");
	ECustomerMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = cmenu())!=ECustomerMenu.EXIT) {
		switch (choice) {
		case ALL_CUSTOMERS:
				CustomerService.getAllCustomers();
				System.out.println("");
			break;

		case SPECIFIC_CUSTOMER:
				CustomerService.getSpecificCustomer();
				System.out.println("");
			break;

		case DELETE_CUSTOMER:
				CustomerService.removeCustomer();
				System.out.println("");
			break;

		case UPDATE_CUSTOMER:
				CustomerService.updateCustomer();
				System.out.println("");
			break;

		case ADD_CUSTOMER:
				CustomerService.addCustomer();
				System.out.println("");
			break;

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
//------------------------------------------------------------------------------------


public static EVehicleMenu vmenu() {
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
	while((choice= vmenu())!=EVehicleMenu.EXIT) {
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
//------------------------------------------------------------------------------------

public static ECVMenu cvmenu() {
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
	
public static void ChooseCustomerVehicleMain() {
	System.out.println("Choose Customer Vehicle Operations");
	ECVMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = cvmenu())!=ECVMenu.EXIT) {
		switch (choice) {
		case ALL_CUSTOMER_VEHICLES:
			CustomerVehicleService.getAllCustVehicles();
			System.out.println("");
			break;

		case SPECIFIC_CUSTOMER_VEHICLE:
			CustomerVehicleService.findThisVehicle();
			System.out.println("");
			break;

		case DELETE_CUSTOMER_VEHICLE:
			CustomerVehicleService.removeCustVehicle();
			System.out.println("");
			break;

		case UPDATE_CUSTOMER_VEHICLE:
			CustomerVehicleService.updateCustVehicle();
			System.out.println("");
			break;

		case ADD_CUSTOMER_VEHICLE:
			CustomerVehicleService.addCustVehicle();
			System.out.println("");
			break;

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
//----------------------------------------------------------------------------------

public static EServiceMenu smenu() {
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
System.out.println("Choose Customer Operations");
EServiceMenu choice;
Scanner scan = new Scanner(System.in);
while((choice = smenu())!=EServiceMenu.EXIT) {
	switch (choice) {
	case ALL_SERVICES:
			OfferedServicesService.getAllServices();
		break;

	case SPECIFIC_SERVICES:
			System.out.println("Show this service");
		break;

	case DELETE_SERVICES:
			
			System.out.println("Delete This Service");
		break;

	case UPDATE_SERVICES:

			System.out.println("Update this service");
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
public static EPartMenu partmenu() {
	System.out.println("0.Exit");
	System.out.println("1.Fetch All Parts");
	System.out.println("2.Fetch Specific Part");
	System.out.println("3.Delete Part");
	System.out.println("4.Update Part");
	System.out.println("5.Add part");
	System.out.print("Enter your choice = ");
	System.out.println("");
	int choice = new Scanner(System.in).nextInt();
	return (choice<0 ||choice>5 ? EPartMenu.values()[6] :EPartMenu.values()[choice]);
}

public static void ChoosePartMain() {
System.out.println("Choose Part Operations");
EPartMenu choice;
Scanner scan = new Scanner(System.in);
while((choice = partmenu())!=EPartMenu.EXIT) {
	switch (choice) {
	case ALL_PARTS:
			PartService.getAllParts();
			System.out.println("");
		break;

	case SEPCIFIC_PART:
		PartService.getSpecificPart();
		System.out.println("");
		break;

	case DELETE_PART:
		PartService.removePart();
		System.out.println("");
		break;

	case UPDATE_PART:
		PartService.updatePart();
		System.out.println("");
		break;

	case ADD_PART:
		PartService.addPart();
		System.out.println("");
		break;

		
	case DEFAULT:
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
