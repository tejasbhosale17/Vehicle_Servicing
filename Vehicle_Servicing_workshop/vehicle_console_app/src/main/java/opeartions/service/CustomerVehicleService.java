package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.CustomerVehicleDao;
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

	public static void addCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public static void updateCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public static void removeCustVehicle() {
		// TODO Auto-generated method stub
		
	}

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


}
