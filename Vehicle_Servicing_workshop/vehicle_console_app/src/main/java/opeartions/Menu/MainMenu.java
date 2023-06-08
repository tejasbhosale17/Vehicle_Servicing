package opeartions.Menu;

import java.util.Scanner;

public class MainMenu {
	private static CMenu cmenu;
	private static PMenu pmenu;
	private static VMenu vmenu;
	private static CVMenu cvmenu;
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
				m.cmenu.CustomerMain();
				System.out.println("");
			break;

		case 2:
				m.pmenu.PartMain();
				System.out.println("");
			break;

		case 3:
				m.vmenu.VehicleMain();
				System.out.println("");
			break;
			
		case 4:
			m.cvmenu.CustVehicleMain();
			System.out.println("");
		break;
			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}



}
