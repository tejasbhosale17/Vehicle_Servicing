package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.ServiceRequestService;

class ServiceRequesrServiceTest {

//	@Test
//	void testServiceRequestServce() {
//		ServiceRequestService.getAllServiceRequests();
//	}
//	
//	@Test
//	void testgetServiceRequestByVehicleNumber() {
//		ServiceRequestService.getServiceRequestByVehicleNumber("MH01RM4141");
//	}
//	
//	@Test
//	void testupdateServiceRequest() {
//		ServiceRequestService.updateServiceRequest("MH01RM4141");
//	}
//	
//	@Test
//	void testdeleteThisServiceRequest() {
//		ServiceRequestService.deleteThisServiceRequest("MH01RM4141");
//	}
	
//	@Test
//	void testaddServiceRequest() {
//		ServiceRequestService.addServiceRequest(6,"MH11PD5161");
//	}
	
	@Test
	void testgetServiceRequest() {
		ServiceRequestService.getServiceRequest();
	}
}
