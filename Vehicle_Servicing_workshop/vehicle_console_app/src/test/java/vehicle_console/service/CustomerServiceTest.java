package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import opeartions.service.CustomerService;

class CustomerServiceTest {

	@Test
	void testgetAllCustomers() throws SQLException {
		CustomerService.getAllCustomers();
	}

	@Test
	void testgetSpecificCustomer() throws SQLException {
		CustomerService.getSpecificCustomer();
	}
	@Test
	void testremoveCustomer()throws SQLException {
		CustomerService.removeCustomer();
	}
	@Test
	void testupdateCustomer() throws SQLException{
		CustomerService.updateCustomer();
	}
	@Test
	void testaddCustomer() throws SQLException{
		CustomerService.addCustomer();
	}
	@Test
	void testaddThisCustomer()throws SQLException {
		CustomerService.addThisCustomer();
	}
	@Test
	void testcustomerFromMobile() throws SQLException{
		CustomerService.customerFromMobile();
	}

}
