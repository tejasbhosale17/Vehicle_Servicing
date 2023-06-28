package opeartions.Menu;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import opeartions.service.BillGenerateService;
import opeartions.service.PaymentService;
import operations.models.Bill_templet;

enum EMainMenu{
	EXIT,CUSTOMER,PART,VEHICLE,CUSTOMER_VEHICLE,
//	SERVICE,
	SERVICE_REQUEST,GENERATE_BILL,TODAYS_BUSINESS, GIVENDATE_BUSINESS , DEFAULT
}


public class MainMenu {
	private static CustomerMenu cmenu;
	private static PartsMenu pmenu;
	private static VehicleMenu vmenu;
	private static CustomerVehicleMenu cvmenu;
	private static ServiceMenu serviceMenu;
	private static ServiceRequestMenu serviceRequestMenu; 
	
	public static EMainMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Part");
		System.out.println("3.Vehicle");
		System.out.println("4.Customer Vehicle");
//		System.out.println("5.Service");
		System.out.println("5.Service Request");
		System.out.println("6.Generate Bill");
		System.out.println("7.Today's Business");
		System.out.println("8.Given Date's Business");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>9 ? EMainMenu.values()[9] :EMainMenu.values()[choice]);
//		return EMainMenu.values()[choice];
	}
	
public static void TheMainMenu() throws SQLException {
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
//			
//		case SERVICE:
////			m.serviceMenu.ChooseServiceMenu();
//			System.out.println("Service");
//		break;
			
		case SERVICE_REQUEST:
			m.serviceRequestMenu.ChooseServiceReqMenu();
			System.out.println("");
		break;
		
		case GENERATE_BILL:
			System.out.println("Here is your Bill");
			BillGenerateService billGenerateService = new BillGenerateService();
			try {
				billGenerateService.showBill();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
			
		case TODAYS_BUSINESS:
			PaymentService paymentService =  new PaymentService();
			paymentService.TodaysBusiness();
			break;
		
		case GIVENDATE_BUSINESS:
			PaymentService payService =  new PaymentService();
			try {
				payService.GivenDateBusiness();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}



}
