package vehicle_console_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import operations.dao.ServiceRequestDao;
import operations.models.Service;
import operations.models.Service_requests;

class ServiceRequestDaoTest {

//	@Test
//	void test() {
//		Service_requests sr= new Service_requests();
//		 sr=ServiceRequestDao.pushingThisServiceRequest("MH26BB3568");
//		 System.out.println(sr.getServiceList());
//	}
	
	@Test
	void testTodaysListServiceRequestsForThisVehicle() {
		List<Service_requests> srList = new ArrayList<>();
		ServiceRequestDao.ListServiceRequestsForDate(srList);
		for(Service_requests s:srList) {
			System.out.println(s);
		}
	}

}
