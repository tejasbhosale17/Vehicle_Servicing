package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import opeartions.service.CustomerVehicleService;

class HereIsYourVehicleTest {

	@Test
	void testHereIsYourVehicle() {
		CustomerVehicleService.hereIsYourVehicle(2, 11);
	}

}
