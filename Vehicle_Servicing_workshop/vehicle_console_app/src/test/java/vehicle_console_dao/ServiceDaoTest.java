package vehicle_console_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import operations.dao.ServiceDao;
import operations.models.Service;

class ServiceDaoTest {

	@Test
	void testgetAllservices() {
		List<Service> serviceList = new ArrayList<>();
		ServiceDao.getAllservices(serviceList);
		for(Service s:serviceList) {
			System.out.println(s);
		}
	}

}
