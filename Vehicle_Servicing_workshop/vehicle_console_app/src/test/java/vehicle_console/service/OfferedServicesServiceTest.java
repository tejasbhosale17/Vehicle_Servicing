package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import opeartions.service.OfferedServicesService;
import operations.dao.ServiceRequestDao;
import operations.models.Service;
import operations.models.Service_requests;

class OfferedServicesServiceTest {
//
//	@Test
//	void testGetAllServices() {
//		OfferedServicesService.getAllServices();
//	}
//
//	@Test
//	void testFindThatService() {
//		List<Service> serviceList = new ArrayList<>();
////		Service_requests serviceRequest = new Service_requests();
//		int service_request_id=23;
//		serviceList=OfferedServicesService.thisServiceThere(serviceList,service_request_id);;
////		serviceList=serviceRequest.getServiceList();
//		for(Service s: serviceList) 
//		{
//			System.out.println(s);
//		}
//	}
////	
//	@Test
//	void testaddTheService() {
//		OfferedServicesService.addTheService();
//	}
//
//	@Test
//	 void testaddThisServiceByMaintainance() {
//	 Service_requests sr= new Service_requests();
//	 sr=ServiceRequestDao.pushingThisServiceRequest("MH26BB3568");
//	 OfferedServicesService.addThisServiceByMaintainance(sr);
//	 }
	
	
	
//	@Test
//	 void addThisServiceByOil() {
//	 Service_requests sr= new Service_requests();
//	 sr=ServiceRequestDao.pushingThisServiceRequest("MH31DS7890");
//	 OfferedServicesService.addThisServiceByOil(sr);
//	 }
	
	@Test
	void testaddThisServiceByRepair() throws SQLException {
		 Service_requests sr= new Service_requests();
		 sr=ServiceRequestDao.pushingThisServiceRequest("MH31DS7890");
		 OfferedServicesService.addThisServiceByRepair(sr);
	}
}
