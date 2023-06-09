package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.OfferedServicesService;

class OfferedServicesServiceTest {

	@Test
	void testGetAllServices() {
		OfferedServicesService.getAllServices();
	}

	@Test
	void testFindThatService() {
		OfferedServicesService.thisServiceThere();;
	}

}
