package vehicle_console.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import opeartions.service.PaymentService;
import operations.dao.PaymentDao;

class PaymentServiceTest {

//	@Test
//	void testTodaysBusiness() {
//		PaymentService paymentService =  new PaymentService();
//		paymentService.TodaysBusiness();
//	}

	@Test
	void testGivenDateBusiness() throws ParseException {
		PaymentService paymentService =  new PaymentService();
		paymentService.GivenDateBusiness();
	}
}
