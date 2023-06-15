package vehicle_console_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import operations.dao.CustomerVehicleDao;
import operations.models.Customer_vehicles;

class CustomerVehicleDaoTest {

	@Test
	void testgetAllCustomerVehicles() {
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
	
	@Test
	void testsearchThisVehicle() {
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			Customer_vehicles CV= new Customer_vehicles();
			CV=CustVehicleDao.searchThisVehicle("MH01TY8814");
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
	@Test
	void testaddCustomerVehicle() {
		int isAdded=0;
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			isAdded=CustVehicleDao.addCustomerVehicle("MH26BB3568",8,3);
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
	
	@Test
	void testremoveThisVehicle() {
		int isDeleted=0;
		try {
			CustomerVehicleDao CustVehicleDao = new CustomerVehicleDao();
			isDeleted=CustVehicleDao.removeThisVehicle("MH26BB3568");
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
	

	

}
