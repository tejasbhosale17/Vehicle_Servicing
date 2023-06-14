package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.CustomerService;

class CustomerServiceTest {

	@Test
	void testgetAllCustomers() {
		CustomerService.getAllCustomers();
	}

	@Test
	void testgetSpecificCustomer() {
		CustomerService.getSpecificCustomer();
	}
	@Test
	void testremoveCustomer() {
		CustomerService.removeCustomer();
	}
	@Test
	void testupdateCustomer() {
		CustomerService.updateCustomer();
	}
	@Test
	void testaddCustomer() {
		CustomerService.addCustomer();
	}
	@Test
	void testaddThisCustomer() {
		CustomerService.addThisCustomer();
	}
	@Test
	void testcustomerFromMobile() {
		CustomerService.customerFromMobile();
	}

}
