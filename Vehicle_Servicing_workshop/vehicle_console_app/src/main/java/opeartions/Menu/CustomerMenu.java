package opeartions.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import opeartions.service.CustomerService;

enum ECustomerMenu{
	EXIT,ALL_CUSTOMERS,SPECIFIC_CUSTOMER,
	DELETE_CUSTOMER,UPDATE_CUSTOMER,ADD_CUSTOMER,DEFAULT
}

public class CustomerMenu {
	public static ECustomerMenu menu() {
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
	
public static void ChooseCustomerMain() throws SQLException {
	System.out.println("Choose Customer Operations");
	ECustomerMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=ECustomerMenu.EXIT) {
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
}
