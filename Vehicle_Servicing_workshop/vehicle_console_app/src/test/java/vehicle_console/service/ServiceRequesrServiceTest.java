package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.ServiceRequestService;
import operations.models.Customer_Vehicle_Details;
import operations.models.Service;
import operations.models.Service_requests;

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
	
//	@Test
//	void testgetServiceRequest() {
//		ServiceRequestService.getServiceRequest();
//	}
	
//	@Test
//	void testpushServiceRequest() {
//		Customer_Vehicle_Details cvd= new Customer_Vehicle_Details("MH26BB8503",2,11,"bajaj","discover125");
//		int n=ServiceRequestService.pushServiceRequest(cvd);
//		System.out.println("Service Request Inserted: "+n);
//	}
//	
//	@Test
//	void testExistingServicesForToday() {
//		Service s= new Service();
//		s=ServiceRequestService.ExistingServicesForToday();
//		System.out.println(s);
//	}

	@Test
	void testListOfServiceRequestsForDate() {
		Service_requests sq= new Service_requests();
		sq=ServiceRequestService.ListOfServiceRequestsForDate();
		System.out.println(sq);
	}


}
