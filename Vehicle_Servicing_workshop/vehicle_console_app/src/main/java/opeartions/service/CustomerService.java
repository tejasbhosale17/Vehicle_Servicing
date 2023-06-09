package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.CustomerDao;
import operations.models.Customer;

public class CustomerService {
		 static Scanner scan = new Scanner(System.in);

		 
	public static void getAllCustomers() {
		List<Customer> customerList= new ArrayList<>(); 
		try {
			CustomerDao customerDao = new CustomerDao();
			customerDao.getAllCustomers(customerList);
			for (Customer customer : customerList)
			{
				System.out.println(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
//-------------------------------------------------------------------------------------
	public static void getSpecificCustomer() {
		System.out.println("Enter mobile no to search the customer:");
		long mobile=scan.nextLong();
		try {
			CustomerDao customerDao = new CustomerDao();
			Customer customer =new Customer();
			customer=customerDao.getThatCustomer(mobile);
			if(customer!=null) {
				System.out.println(customer);
			}else {
				System.out.println("Customer Does not exists!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//------------------------------------------------------------------------
	public static void removeCustomer() {
		System.out.println("Enter Customer id to remove:");
		int id=scan.nextInt();
		try {
			CustomerDao customerDao = new CustomerDao();
			int isDeleted=customerDao.removeThatCustomer(id);
			if(isDeleted>0) {
				System.out.println("Customer Deleted Succesfully!");
			}else {
				System.out.println("Customer Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//------------------------------------------------------------------------

	public static void updateCustomer() {
		System.out.println("Enter id of the customer u want to update:");
		int id=scan.nextInt();
		System.out.println("Enter email & address of the customer");
		String email=scan.next();
		scan.nextLine();
		String addr=scan.nextLine();
		try {
			CustomerDao customerDao = new CustomerDao();
			int isUpdated=customerDao.updateThisCustomer(id,email,addr);
			if(isUpdated>0) {
				System.out.println("Customer Updated Sucessfully!");
			}else {
				System.out.println("Customer Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//------------------------------------------------------------------------

	public static void addCustomer() {
		try {
			CustomerDao customerDao = new CustomerDao();
			int isInserted=customerDao.addThisCustomer(scan.nextInt(),scan.next(),scan.nextLong(),scan.next(),scan.next());
			if(isInserted>0){
				System.out.println("Customer Added Succesfully!");
			}else {
				System.out.println("Custommer does not exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//---------------------------------------------------------------------------


}
