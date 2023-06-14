package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.VehicleService;

class VehicleServiceTest {

	@Test
	void testgetAllVehicles() {
		VehicleService.getAllVehicles();
	}

	
	@Test
	void testgetSpecificVehicle() {
		VehicleService.getSpecificVehicle();
	}
	
	@Test
	void testremoveVehiclebyId() {
		VehicleService.removeVehiclebyId();
	}
	
	@Test
	void testremoveVehiclebyVNumber() {
		VehicleService.removeVehiclebyVNumber(" MH01TY8814");
	}
	
	@Test
	void testupdateVehicle() {
		VehicleService.updateVehicle();
	}
	
	@Test
	void testaddVehicle() {
		VehicleService.addVehicle();
	}
	
	@Test
	void testaddVehicleUsingMobile() {
		VehicleService.addVehicleUsingMobile();
	}
}
