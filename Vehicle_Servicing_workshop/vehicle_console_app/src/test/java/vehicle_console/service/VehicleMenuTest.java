package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import opeartions.Menu.VehicleMenu;

class VehicleMenuTest {

	@Test
	void testVehicleMenu() throws SQLException {
		VehicleMenu.ChooseVehicleMain();
	}

}
