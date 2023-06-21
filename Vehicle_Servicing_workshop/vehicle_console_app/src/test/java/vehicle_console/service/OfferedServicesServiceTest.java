package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import opeartions.service.OfferedServicesService;
import operations.models.Service;

class OfferedServicesServiceTest {
//
//	@Test
//	void testGetAllServices() {
//		OfferedServicesService.getAllServices();
//	}
//
	@Test
	void testFindThatService() {
		List<Service> serviceList = new ArrayList<>();
		int service_request_id=23;
		serviceList=OfferedServicesService.thisServiceThere(serviceList,service_request_id);;
		for(Service s: serviceList) 
		{
			System.out.println(s);
		}
	}
//	
//	@Test
//	void testaddTheService() {
//		OfferedServicesService.addTheService();
//	}

}
