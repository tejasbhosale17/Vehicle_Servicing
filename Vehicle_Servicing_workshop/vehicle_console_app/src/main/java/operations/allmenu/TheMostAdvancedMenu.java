//package operations.allmenu;
//
//import java.util.Scanner;
//
//public class TheMostAdvancedMenu {
//
//	public static int menu() {
//		System.out.println("0.Exit");
//		System.out.println("1.Customer");
//		System.out.println("2.Vehicle");
//		System.out.println("3.Service Request");
//		System.out.println("4.Parts");
//		System.out.println("5.Today's Business");
//		System.out.println("6.Given Date's Business");
//		System.out.print("Enter your choice = ");
//		System.out.println("");
//		return new Scanner(System.in).nextInt();
//	}
//	
//public static void main(String[] args) {
//	System.out.println("Choose The Department");
//
//	int choice;
//	Scanner scan = new Scanner(System.in);
//	while((choice = menu())!=0) {
//		switch (choice) {
//		case 1:
//				System.out.println("Customer");
//				AllMenuTogether.ChooseCustomerMain();
//			break;
//
//		case 2:
//				System.out.println("");
//				AllMenuTogether.ChooseVehicleMain();
//			break;
//
//		case 3:
//				AllMenuTogether.ChooseCustomerVehicleMain();
//				System.out.println("");
//				AllMenuTogether.ChooseServiceMenu();
//				AllMenuTogether.ChoosePaymentMenu();
//			break;
//			
//		case 4:
//				AllMenuTogether.ChoosePartMain();
//				System.out.println("");
//			break;
//			
//		case 5:
//				AllMenuTogether.TodaysBusiness();
//				System.out.println("");
//			break;
//			
//		case 6:
//				AllMenuTogether.givenDateBusiness();
//				System.out.println("");
//			break;
//		
//		default:
//				System.out.println("Wrong choice entered..:(");
//			break;
//		}
//	}
//}
//
//
//}
