package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import opeartions.service.CustomerVehicleService;

class CustomerVehicleServiceTest {

//	@Test
//	void testGetAllCustomers() {
//		CustomerVehicleService.getAllCustVehicles();
//	}
//	
//	@Test
//	void testFindThatCustomerVehicle(){
//		CustomerVehicleService.findThisVehicle();
//	}
	
	@Test
	void testDetailsofAllCustomerVehicles() {
		int customer_id=2;
		CustomerVehicleService.DetailsofAllCustomerVehicles(customer_id);
	}
}
