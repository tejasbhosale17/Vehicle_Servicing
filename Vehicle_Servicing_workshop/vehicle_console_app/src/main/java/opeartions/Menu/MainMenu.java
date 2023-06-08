package opeartions.Menu;

import java.util.Scanner;





enum EMainMenu{
	EXIT,CUSTOMER,PART,VEHICLE,CUSTOMER_VEHICLE,DEFAULT
}


public class MainMenu {
	private static CustomerMenu cmenu;
	private static PartsMenu pmenu;
	private static VehicleMenu vmenu;
	private static CustomerVehicleMenu cvmenu;
	
	public static EMainMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Part");
		System.out.println("3.Vehicle");
		System.out.println("4.Customer Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>4 ? EMainMenu.values()[5] :EMainMenu.values()[choice]);
//		return EMainMenu.values()[choice];
	}
	
public static void TheMainMenu() {
	System.out.println("Choose The Department");
	MainMenu m =new MainMenu();
	EMainMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=EMainMenu.EXIT) {
		switch (choice) {
		case CUSTOMER:
				m.cmenu.ChooseCustomerMain();
				System.out.println("");
			break;

		case PART:
				m.pmenu.ChoosePartMain();
				System.out.println("");
			break;

		case VEHICLE:
				m.vmenu.ChooseVehicleMain();
				System.out.println("");
			break;
			
		case CUSTOMER_VEHICLE:
			m.cvmenu.ChooseCustomerVehicleMain();
			System.out.println("");
		break;
			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}



}
