package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import opeartions.service.BillGenerateService;

class BillGenetrateServiceTest {

	@Test
	void testBillGenerateService()  {
		BillGenerateService billGenerateService = new BillGenerateService();
		try {
			billGenerateService.showBill();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
