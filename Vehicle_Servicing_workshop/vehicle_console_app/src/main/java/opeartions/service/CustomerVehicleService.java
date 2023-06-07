package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import operations.dao.CustomerVehicleDao;
import operations.models.Customer_vehicles;

public class CustomerVehicleService {
	static CustomerVehicleDao CustVehicleDao;
	public void getAllCustVehicles() {
		List<Customer_vehicles> CVList = new ArrayList<>();
		try {
			CustVehicleDao = new CustomerVehicleDao();
			CustVehicleDao.getAllVehicles(CVList);
			for(Customer_vehicles v: CVList) {
				System.out.println(v);
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
