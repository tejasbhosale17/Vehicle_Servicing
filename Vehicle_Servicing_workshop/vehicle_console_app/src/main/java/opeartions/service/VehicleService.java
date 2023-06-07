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
//------------------------------------------------------------------------------------

	public static void removeVehicle() {
		System.out.println("Enter vid to remove vehicle:");
		int id=scan.nextInt();
		try {
			vehicleDao = new VehicleDao();
			int isRemoved=vehicleDao.removeThatVehicle(id);
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

	public static void addVehicle() {
		try {
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

}
