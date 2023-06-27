package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import opeartions.service.ServicePartsService;

class ServicePartsServiceTest {

	@Test
	void testgetServiceParts() throws SQLException {
		ServicePartsService.getServiceParts();
	}


}
