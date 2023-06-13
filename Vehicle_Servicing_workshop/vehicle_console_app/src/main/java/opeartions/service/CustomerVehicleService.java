package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.CustomerVehicleDao;
import operations.models.Customer_Vehicle_Details;
import operations.models.Customer_vehicles;

public class CustomerVehicleService {
	//static CustomerVehicleDao CustVehicleDao;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void getAllCustVehicles() {
		List<Customer_vehicles> CVList = new ArrayList<>();
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			CustVehicleDao.getAllVehicles(CVList);
			for(Customer_vehicles cv: CVList) {
				System.out.println(cv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	//------------------------------------------------------------------------------------------
	public static void addCustVehicle() {
		System.out.println("Enter vehicle numer,customerid,vehicle id:");
		int isAdded=0;
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			isAdded=CustVehicleDao.addCustomerVehicle(scan.next(),scan.nextInt(),scan.nextInt());
			if(isAdded>0) {
				System.out.println("Customer Vehicle added Succesfully!!");
			}else {
				System.out.println("Failed to add customer_vehicle...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//------------------------------------------------------------------------------------
	public static void updateCustVehicle() {
		
		
	}
//----------------------------------------------------------------------------------------
	public static void removeCustVehicle() {
		System.out.println("Enter Vehicle_number to delete the vehicle!!");
		String vehicle_number=scan.next();
		int isDeleted=0;
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			isDeleted=CustVehicleDao.removeThisVehicle(vehicle_number);
			if(isDeleted>0) {
				System.out.println("Vehicle Deleted Succesfully...");
			}else {
				System.out.println("Vehicle Deleted Unsuccesfully...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//----------------------------------------------------------------------------------------
	
	public static void findThisVehicle() {
		System.out.println("Enter Vehicle Number to check if we have it here:");
		String vnumber=scan.next();
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			Customer_vehicles CV= new Customer_vehicles();
			CV=CustVehicleDao.searchThisVehicle(vnumber);
			if(CV!=null) {
				System.out.println("Vehicle Details are here...");
				System.out.println(CV);
			}else {
				System.out.println("Vehicle Does not Exists!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
//----------------------------------------------------------------------------------------
	public static void AllVehiclesOfPerticularCustomer(int customer_id) {
		int isExists=0;
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			
			isExists=CustVehicleDao.ListVehicleOfCustomer(customer_id);
			if(isExists<0) {
				System.out.println("Vehicle Does not Exists!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	
//-------------------------------------------------------------------------------------
	public static void DetailsofAllCustomerVehicles(int customer_id) {
		List<Customer_Vehicle_Details> CVDList = new ArrayList<>();
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			CustVehicleDao.ListVehicleDetails(CVDList,customer_id);
			for(Customer_Vehicle_Details cv: CVDList) {
				System.out.println(cv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
//----------------------------------------------------------------------------------
	
	public static void hereIsYourVehicle(int customer_id,int vid) {
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			CustVehicleDao.thisMyVehicle(customer_id,vid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
//--------------------------------------------------------------------------------	
	public static void addCustersVehicle(int customer_id) {
		System.out.println("Enter vid & vehicle numer");
		int isAdded=0;
		int vid=scan.nextInt();
		String vehicle_number=scan.next();
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			
			isAdded=CustVehicleDao.addCustomerVehicle(vehicle_number,customer_id,vid);
			if(isAdded>0) {
				System.out.println("Customer Vehicle added Succesfully!!");
			}else {
				System.out.println("Failed to add customer_vehicle...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
