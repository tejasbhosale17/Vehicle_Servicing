package opeartions.Menu;

import java.util.Scanner;

public class MainMenu {
	private static CustomerMenu cmenu;
	private static PartsMenu pmenu;
	private static VehicleMenu vmenu;
	private static CustomerVehicleMenu cvmenu;
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Part");
		System.out.println("3.Vehicle");
		System.out.println("4.Customer Vehicle");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void TheMainMenu() {
	System.out.println("Choose The Department");
	MainMenu m =new MainMenu();
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				m.cmenu.ChooseCustomerMain();
				System.out.println("");
			break;

		case 2:
				m.pmenu.ChoosePartMain();
				System.out.println("");
			break;

		case 3:
				m.vmenu.ChooseVehicleMain();
				System.out.println("");
			break;
			
		case 4:
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
