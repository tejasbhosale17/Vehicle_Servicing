package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.CustomerDao;
import operations.models.Customer;

public class CustomerService {
		 static Scanner scan = new Scanner(System.in);

		 
	public static void getAllCustomers() throws SQLException {
		List<Customer> customerList= new ArrayList<>(); 
		CustomerDao customerDao = new CustomerDao();
		customerDao.getAllCustomers(customerList);
		for (Customer customer : customerList)
		{
			System.out.println(customer);
		}		
	}
	
//-------------------------------------------------------------------------------------
	public static int getSpecificCustomer() throws SQLException {
		System.out.println("Enter mobile no to search the customer:");
		long mobile=scan.nextLong();
		int isHere=0;
		CustomerDao customerDao = new CustomerDao();
		Customer customer =new Customer();
		customer=customerDao.getThatCustomer(mobile);
		if(customer!=null) {
			System.out.println(customer);
			isHere=1;
			return isHere;
		}else {
			System.out.println("Customer Does not exists!");
		}
		return isHere;
		
	}
//------------------------------------------------------------------------
	public static void removeCustomer() throws SQLException {
		System.out.println("Enter Customer id to remove:");
		int id=scan.nextInt();
		CustomerDao customerDao = new CustomerDao();
		int isDeleted=customerDao.removeThatCustomer(id);
		if(isDeleted>0) {
			System.out.println("Customer Deleted Succesfully!");
		}else {
			System.out.println("Customer Does not Exists...");
		}
		
	}
	//------------------------------------------------------------------------

	public static void updateCustomer() throws SQLException {
		System.out.println("Enter id of the customer u want to update:");
		int id=scan.nextInt();
		System.out.println("Enter mobile no & address of the customer");
		long mobileno=scan.nextInt();
//		String email=scan.next();
		scan.nextLine();
		String addr=scan.nextLine();
		CustomerDao customerDao = new CustomerDao();
		int isUpdated=customerDao.updateThisCustomer(id,mobileno,addr);
		if(isUpdated>0) {
			System.out.println("Customer Updated Sucessfully!");
		}else {
			System.out.println("Customer Does not Exists...");
		}
		
	}
	//------------------------------------------------------------------------

	public static void addCustomer() throws SQLException {
		System.out.println("Enter customer_id,name,mobile,email,address:");
		CustomerDao customerDao = new CustomerDao();
		int isInserted=customerDao.addThisCustomer(scan.nextInt(),scan.next(),scan.nextLong(),scan.next(),scan.next());
		if(isInserted>0){
			System.out.println("Customer Added Succesfully!");
		}else {
			System.out.println("Custommer does not exists...");
		}
		
	}

//---------------------------------------------------------------------------------
	public static int addThisCustomer() throws SQLException {
		System.out.println("Enter customer_id,name,mobile,email,address:");
		int cid=0;
		CustomerDao customerDao = new CustomerDao();
		cid=scan.nextInt();
		int isInserted=customerDao.addThisCustomer(cid,scan.next(),scan.nextLong(),scan.next(),scan.next());
		if(isInserted>0){
			System.out.println("Customer Added Succesfully!");
		}else {
			System.out.println("Can not add Customer... :(");
		}
		return cid;
	}
	
	
	
	
//---------------------------------------------------------------------------

	public static int customerFromMobile() throws SQLException{
		System.out.println("Enter mobile no to search the customer:");
		long mobile=scan.nextLong();
		int cid=0;
		CustomerDao customerDao = new CustomerDao();
		cid=customerDao.getThisCustomerId(mobile);
		if(cid>0) {
			System.out.println("Customer Exists!!");
			
		}else {
			System.out.println("Customer Does not exists!");
			//cid=addThisCustomer();
			//return cid;
		}
		return cid;
	}
}
