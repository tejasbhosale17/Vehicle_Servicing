package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.CustomerService;
import opeartions.service.CustomerVehicleService;

class CustomerVehicleServiceTest {

	@Test
	void testGetAllCustomers() {
		CustomerVehicleService.getAllCustVehicles();
	}

}
