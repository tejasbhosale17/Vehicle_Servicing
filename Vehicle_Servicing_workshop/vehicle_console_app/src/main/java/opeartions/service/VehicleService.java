package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.VehicleDao;
import operations.models.Vehicle;

public class VehicleService {
	static Scanner scan = new Scanner(System.in);
	static VehicleDao vehicleDao;
	
	public static void getAllVehicles() {
		List<Vehicle> vehicleList = new ArrayList<>();
		try {
			vehicleDao = new VehicleDao();
			vehicleDao.getAllVehicles(vehicleList);
			for(Vehicle v: vehicleList) {
				System.out.println(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
//------------------------------------------------------------------------------------
	public static void getSpecificVehicle() {
		System.out.println("Enter vid to find Vehicle");
		int id=scan.nextInt();
		try {
			vehicleDao = new VehicleDao();
			Vehicle v=vehicleDao.getThatVehicle(id);
			if(v!=null) {
				System.out.println(v);
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
//-------------------------------------------------------------------------------------
	
	public static void ThisIsYourVehicle(int vehicle_id) {
		try {
			vehicleDao = new VehicleDao();
			Vehicle v=vehicleDao.getThatVehicle(vehicle_id);
			if(v!=null) {
				System.out.println(v);
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
//------------------------------------------------------------------------------------

	public static void removeVehiclebyId() {
		System.out.println("Enter vehicle id to remove vehicle:");
		int vid=scan.nextInt();
		try {
			vehicleDao = new VehicleDao();
			int isRemoved=vehicleDao.removeThatVehicleUsingId(vid);
			if(isRemoved !=0) {
				System.out.println("Vehicle Deleted Succesfully!");
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------------------
	
	public static void removeVehiclebyVNumber(String vehicle_number) {

		CustomerVehicleService.removeCustVehicle();
	}
	
//------------------------------------------------------------------------------------

	public static void updateVehicle() {
		System.out.println("Enter vid to update vehicle:");
		int id=scan.nextInt();
		System.out.println("Enter model of vehicle to update:");
		try {
			vehicleDao = new VehicleDao();
			int isUpdated=vehicleDao.changeThatVehicle(id,scan.next());
			if(isUpdated !=0) {
				System.out.println(isUpdated+" Vehicle Updated Succesfully!");
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//------------------------------------------------------------------------------------
//
	public static void addVehicle() {
		try {
			System.out.println("Enter Vehicle id, company, model");
			vehicleDao = new VehicleDao();
			int isAdded=vehicleDao.addThisVehicle(scan.nextInt(),scan.next(),scan.next());
			if(isAdded !=0) {
				System.out.println(isAdded+" Vehicle Inserted Succesfully!");
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//-------------------------------------------------------------------------------------------------
	public static void addVehicleUsingMobile() {
		CustomerService.getAllCustomers();
		int customer_id=CustomerService.customerFromMobile();
		CustomerVehicleService.DetailsofAllCustomerVehicles(customer_id);
		//getAllVehicles();
		System.out.println("Enter vehicle id from above list if it exitst else enter 0");
		int vid=scan.nextInt();
//		int isCVThere=0;
		if(vid>0) {
			ifVidExists(customer_id,vid);
//			System.out.println("Is your vehicle there?");
//			boolean isThere=scan.nextBoolean();
//			if(isThere==true) {
//				CustomerVehicleService.hereIsYourVehicle(customer_id,vid);
//			}else {
//				getAllVehicles();
//				CustomerVehicleService.addCustVehicle();
//			}
		}else {
			ifVidDoesntExists(customer_id,vid);
//			addVehicle();
//			getAllVehicles();
//			CustomerVehicleService.addCustersVehicle(customer_id);
//			addVehicleUsingMobile();
		}
	}
	
	public static void ifVidExists(int customer_id,int vid) {
//		System.out.println("Is your vehicle there? true/false");
//		boolean isThere=scan.nextBoolean();
//		if(isThere==true) {
			CustomerVehicleService.hereIsYourVehicle(customer_id,vid);
//		}else {
//			getAllVehicles();
//			CustomerVehicleService.addCustVehicle();
//		}
	}
	
	public static void ifVidDoesntExists(int customer_id,int vid) {
		addVehicle();
		getAllVehicles();
		CustomerVehicleService.addCustersVehicle(customer_id);
		ifVidExists(customer_id,vid);
	}
	
	
	
}
