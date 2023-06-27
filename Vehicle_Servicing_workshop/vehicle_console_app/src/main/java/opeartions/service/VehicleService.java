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
	
	public static void getAllVehicles() throws SQLException {
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleDao = new VehicleDao();
		vehicleDao.getAllVehicles(vehicleList);
		for(Vehicle v: vehicleList) {
			System.out.println(v);
		}		
	}
//------------------------------------------------------------------------------------
	public static void getSpecificVehicle() throws SQLException {
		System.out.println("Enter vid to find Vehicle");
		int id=scan.nextInt();
		vehicleDao = new VehicleDao();
		Vehicle v=vehicleDao.getThatVehicle(id);
		if(v!=null) {
			System.out.println(v);
		}else {
			System.out.println("Vehicle Does not Exists...");
		}	
	}
	
//-------------------------------------------------------------------------------------
	
	public static void ThisIsYourVehicle(int vehicle_id) throws SQLException {
		vehicleDao = new VehicleDao();
		Vehicle v=vehicleDao.getThatVehicle(vehicle_id);
		if(v!=null) {
			System.out.println(v);
		}else {
			System.out.println("Vehicle Does not Exists...");
		}	
	}
	
	
//------------------------------------------------------------------------------------

	public static void removeVehiclebyId() throws SQLException {
		System.out.println("Enter vehicle id to remove vehicle:");
		int vid=scan.nextInt();
		vehicleDao = new VehicleDao();
		int isRemoved=vehicleDao.removeThatVehicleUsingId(vid);
		if(isRemoved !=0) {
			System.out.println("Vehicle Deleted Succesfully!");
		}else {
			System.out.println("Vehicle Does not Exists...");
		}
	}
//-----------------------------------------------------------------------------------
	
	public static void removeVehiclebyVNumber(String vehicle_number) throws SQLException {

		CustomerVehicleService.removeCustVehicle();
	}
	
//------------------------------------------------------------------------------------

	public static void updateVehicle() throws SQLException {
		System.out.println("Enter vid to update vehicle:");
		int id=scan.nextInt();
		System.out.println("Enter model of vehicle to update:");
		vehicleDao = new VehicleDao();
		int isUpdated=vehicleDao.changeThatVehicle(id,scan.next());
		if(isUpdated !=0) {
			System.out.println(isUpdated+" Vehicle Updated Succesfully!");
		}else {
			System.out.println("Vehicle Does not Exists...");
		}
	}
//------------------------------------------------------------------------------------
//
	public static String addVehicle() throws SQLException {
		String model=null;
		int vid=0;
		System.out.println("Enter company, model");
		vehicleDao = new VehicleDao();
		String company=scan.next();
		model =scan.next();
		vid=findVidByModel(model);
		if(vid==0) {
			int isAdded=vehicleDao.addThisVehicle(company,model);
			if(isAdded !=0) {
				System.out.println(isAdded+" Vehicle Inserted Succesfully!");
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		}
		return model;
	}
//-------------------------------------------------------------------------------------------------
	public static void addVehicleUsingMobile() throws SQLException {
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
	
	public static void ifVidExists(int customer_id,int vid) throws SQLException {
//		System.out.println("Is your vehicle there? true/false");
//		boolean isThere=scan.nextBoolean();
//		if(isThere==true) {
			CustomerVehicleService.havingYourVehicle(customer_id,vid);
//		}else {
//			getAllVehicles();
//			CustomerVehicleService.addCustVehicle();
//		}
	}
	
	public static void ifVidDoesntExists(int customer_id,int vid) throws SQLException {
		addVehicle();
		getAllVehicles();
		CustomerVehicleService.addCustersVehicle(customer_id);
		ifVidExists(customer_id,vid);
	}
	
//==========================================================================
	public static int findVidByModel(String model) throws SQLException {
		int vid=0;
		vehicleDao = new VehicleDao();
		Vehicle v=vehicleDao.findThisVehicleId(model);
		if(v!=null) {
			vid=v.getVid();
		}else {
			System.out.println("Vehicle Does not Exists...");
		}
		return vid;
	}
	
	
	
}
