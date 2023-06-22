package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import opeartions.service.OfferedServicesService;
import opeartions.service.ServiceRequestService;
import operations.dao.ServiceRequestDao;
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
		sq=ServiceRequestDao.findThisServiceRequestbyVehicleNumber("MH26BB3568",35);
		System.out.println("From test case"+ sq);
		ServiceRequestService.ListOfServiceRequestsForDate(sq);
		System.out.println(sq);
	}


//	@Test
//	void test() {
//		int service_request_id=0;
//		List<Service> serviceList = new ArrayList<>();
//		try {
//			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
//			List<Service_requests> srList = new ArrayList<>();
//			System.out.println("Here is the list of Services for today:");
//			serviceRequestDao.ListServiceRequestsForDate(srList);
//			for(Service_requests s: srList) {
//				System.out.println(s);
//			}
//			System.out.println("Enter service_request_id:");
//			service_request_id=29;
//			for(Service_requests s: srList) {
//				if(service_request_id ==s.getService_request_id()) 
//				{
//					System.out.println(s);
//					serviceList=OfferedServicesService.thisServiceThere(serviceList,service_request_id);
//					s.setServiceList(serviceList);
//					List<Service> servList= new ArrayList<>();
//					servList=s.getServiceList();
//					for(Service serv:servList){
//						System.out.println(serv);
//					}
//					
////					return s;
//				}
//			}
////			for(Service s: serviceList) {
////				System.out.println(s);
////			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
}
