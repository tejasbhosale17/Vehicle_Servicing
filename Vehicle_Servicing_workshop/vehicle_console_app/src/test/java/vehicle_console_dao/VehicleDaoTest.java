package vehicle_console_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import operations.dao.VehicleDao;
import operations.models.Vehicle;

class VehicleDaoTest {

	@Test
	void testgetAllVehicles() {
		List<Vehicle> vehicleList = new ArrayList<>();
		try {
			VehicleDao vehicleDao = new VehicleDao();
			vehicleDao.getAllVehicles(vehicleList);
			for(Vehicle v: vehicleList) {
				System.out.println(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	void testgetThatVehicle() {
		try {
			VehicleDao vehicleDao = new VehicleDao();
			Vehicle v=vehicleDao.getThatVehicle(12);
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
	
	@Test
	void testremoveThatVehicleUsingId() {
		try {
			VehicleDao vehicleDao = new VehicleDao();
			int isRemoved=vehicleDao.removeThatVehicleUsingId(12);
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
	
	@Test
	void testchangeThatVehicle() {
		try {
			VehicleDao vehicleDao = new VehicleDao();
			int isUpdated=vehicleDao.changeThatVehicle(11,"discover125");
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
	
	@Test
	void testaddThisVehicle() {
		try {
			System.out.println("Enter Vehicle id, company, model");
			VehicleDao vehicleDao = new VehicleDao();
			int isAdded=vehicleDao.addThisVehicle(12,"RoyalEnfield","ContinentalGT650");
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
