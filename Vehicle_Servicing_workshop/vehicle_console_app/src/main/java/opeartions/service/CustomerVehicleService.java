package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import operations.dao.CustomerVehicleDao;
import operations.models.Customer_vehicles;

public class CustomerVehicleService {
	//static CustomerVehicleDao CustVehicleDao;
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

	public void addCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public void updateCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public void removeCustVehicle() {
		// TODO Auto-generated method stub
		
	}

	public void getSpecificCustVehicle() {
		// TODO Auto-generated method stub
		
	}

}
