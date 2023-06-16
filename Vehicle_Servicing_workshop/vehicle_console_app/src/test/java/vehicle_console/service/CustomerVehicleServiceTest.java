package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import opeartions.service.CustomerVehicleService;
import operations.models.Customer_Vehicle_Details;

class CustomerVehicleServiceTest {
//
//	@Test
//	void testGetAllCustomers() {
//		CustomerVehicleService.getAllCustVehicles();
//	}
//	
//	
//	
//	@Test
//	void testDetailsofAllCustomerVehicles() {
//		int customer_id=2;
//		CustomerVehicleService.DetailsofAllCustomerVehicles(customer_id);
//	}
//	
//	@Test
//	void testaddCustVehicle(){
//		CustomerVehicleService.addCustVehicle();
//	}
//	
//	@Test
//	void testupdateCustVehicle(){
//		CustomerVehicleService.updateCustVehicle();
//	}
//	
//	@Test
//	void testremoveCustVehicle(){
//		CustomerVehicleService.removeCustVehicle();
//	}
//	
//	@Test
//	void testfindThisVehicle(){
//		CustomerVehicleService.findThisVehicle();
//	}
//	
//	@Test
//	void testAllVehiclesOfPerticularCustomer(){
//		CustomerVehicleService.AllVehiclesOfPerticularCustomer(2);
//	}
//	
//	@Test
//	void testaddCustersVehicle(){
//		CustomerVehicleService.addCustersVehicle(11);
//	}
//
//	@Test
//	void testFindThatCustomerVehicle(){
//		CustomerVehicleService.findThisVehicle();
//	}
	
	@Test
	void testhereIsYourVehicle() {
		Customer_Vehicle_Details cvd =new Customer_Vehicle_Details();
		cvd=CustomerVehicleService.hereIsYourVehicle(2,11);
		if(cvd!=null) {
			System.out.println("Succesfull...");
		}else {
			System.out.println("Unsucessfull....");
		}
	}
	
//	void testallDetailsCustomerVehicle() {
//		Customer_Vehicle_Details cvd =new Customer_Vehicle_Details();
//		cvd=CustomerVehicleService.allDetailsCustomerVehicle(2,11);
//	}
}
