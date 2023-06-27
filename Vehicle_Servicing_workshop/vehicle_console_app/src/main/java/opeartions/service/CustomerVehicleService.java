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
	
	
	public static void getAllCustVehicles() throws SQLException {
		List<Customer_vehicles> CVList = new ArrayList<>();
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		CustVehicleDao.getAllVehicles(CVList);
		for(Customer_vehicles cv: CVList) {
			System.out.println(cv);
		}		
	}

//------------------------------------------------------------------------------------------
	public static void addCustVehicle() throws SQLException {
		System.out.println("Enter vehicle numer,customerid,vehicle id:");
		int isAdded=0;
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		isAdded=CustVehicleDao.addCustomerVehicle(scan.next(),scan.nextInt(),scan.nextInt());
		if(isAdded>0) {
			System.out.println("Customer Vehicle added Succesfully!!");
		}else {
			System.out.println("Failed to add customer_vehicle...");
		}
	}

//------------------------------------------------------------------------------------
	public static void updateCustVehicle() throws SQLException {
		System.out.println("Enter old vehicle number to update");
		String old_vehicle_number=scan.next();
		System.out.println("Enter new vehicle number to update");
		String new_vehicle_number=scan.next();
		int isUpdated=0;
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		isUpdated=CustVehicleDao.updateThisCustomerVehicle(old_vehicle_number,new_vehicle_number);
		
	}
//----------------------------------------------------------------------------------------
	public static void removeCustVehicle() throws SQLException {
		System.out.println("Enter Vehicle_number to delete the vehicle!!");
		String vehicle_number=scan.next();
		int isDeleted=0;
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		isDeleted=CustVehicleDao.removeThisVehicle(vehicle_number);
		if(isDeleted>0) {
			System.out.println("Vehicle Deleted Succesfully...");
		}else {
			System.out.println("Vehicle Deleted Unsuccesfully...");
		}
	}
	
	
//----------------------------------------------------------------------------------------
	
	public static void findThisVehicle() throws SQLException {
		System.out.println("Enter Vehicle Number to check if we have it here:");
		String vnumber=scan.next();
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		Customer_vehicles CV= new Customer_vehicles();
		CV=CustVehicleDao.searchThisVehicle(vnumber);
		if(CV!=null) {
			System.out.println("Vehicle Details are here...");
			System.out.println(CV);
		}else {
			System.out.println("Vehicle Does not Exists!");
		}	
	}

	
//----------------------------------------------------------------------------------------
	public static void AllVehiclesOfPerticularCustomer(int customer_id) throws SQLException {
		int isExists=0;
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		
		isExists=CustVehicleDao.ListVehicleOfCustomer(customer_id);
		if(isExists<0) {
			System.out.println("Vehicle Does not Exists!");
		}	
	}	
	
//-------------------------------------------------------------------------------------
	public static void DetailsofAllCustomerVehicles(int customer_id) throws SQLException {
		List<Customer_Vehicle_Details> CVDList = new ArrayList<>();
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		CustVehicleDao.ListVehicleDetails(CVDList,customer_id);
		for(Customer_Vehicle_Details cv: CVDList) {
			System.out.println(cv);
		}		
	}
//----------------------------------------------------------------------------------
	
	public static Customer_Vehicle_Details hereIsYourVehicle(int customer_id,String vehicle_number) throws SQLException {
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		Customer_Vehicle_Details cvd=new Customer_Vehicle_Details();
		cvd=CustVehicleDao.allDetailsCustomerVehicle(customer_id,vehicle_number);
//			System.out.println(cvd);
		if(cvd!=null) {
			System.out.println("Heres is your Vehicle Details:");
			return cvd;
		}else {
			System.out.println("Error in hereIsYourVehicle...");
		}	
		return null;
	}
//-------------------------------------------------------------------------------------------------
	public static void havingYourVehicle(int customer_id,int vid) throws SQLException {
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		CustVehicleDao.thisMyVehicle(customer_id,vid);
//			System.out.println();
//			if(cvd!=null) {
//				System.out.println("Heres is your Vehicle Details:");
//				return cvd;
//			}else {
//				System.out.println("Error in hereIsYourVehicle...");
//			}
	}
	
//--------------------------------------------------------------------------------	
	public static void addCustersVehicle(int customer_id) throws SQLException {
		System.out.println("Enter vid & vehicle numer");
		int isAdded=0;
		int vid=scan.nextInt();
		String vehicle_number=scan.next();
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		
		isAdded=CustVehicleDao.addCustomerVehicle(vehicle_number,customer_id,vid);
		if(isAdded>0) {
			System.out.println("Customer Vehicle added Succesfully!!");
		}else {
			System.out.println("Failed to add customer_vehicle...");
		}
	}
	
	
	public static int findVidOfThisVehicle(String vehicle_number) throws SQLException {
		int vid=0;
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		vid=CustVehicleDao.FoundYourVehicle(vehicle_number);
		return vid;
	}
	
	public static void AddThisCustomerVehicle(String vehicle_number,int customer_id) throws SQLException {
		String model=VehicleService.addVehicle();
		int vid=VehicleService.findVidByModel(model);
		int isAdded=0;
		CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
		isAdded=CustVehicleDao.addCustomerVehicle(vehicle_number,customer_id,vid);
		if(isAdded>0) {
			System.out.println("Customer Vehicle added Succesfully!!");
		}else {
			System.out.println("Failed to add customer_vehicle...");
		}
	}
	
}
