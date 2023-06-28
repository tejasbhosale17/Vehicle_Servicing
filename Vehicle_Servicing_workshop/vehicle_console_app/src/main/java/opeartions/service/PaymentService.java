package opeartions.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.PaymentDao;
import operations.models.Payment;

public class PaymentService {

	Scanner scan = new Scanner(System.in);
	
	
	public void getAllPayments() {
	List<Payment> payList = new ArrayList<>();
		PaymentDao paymentDao = new PaymentDao();
		paymentDao.getAllPayments(payList);
		for(Payment p:payList) {
			System.out.println(p);
		}
		
	}
	
	public void addingThisPayment(Payment p) {
		PaymentDao paymentDao = new PaymentDao();
		paymentDao.addThisPayment(p);
	}
	
	public void TodaysBusiness() {
		double todays_business=0;
		PaymentDao paymentDao = new PaymentDao();
		todays_business=paymentDao.TodaysBusiness();
		System.out.println(todays_business);
	}
	
	
	public void GivenDateBusiness() throws ParseException {
		double givendate_business=0;
//		SimpleDateFormat dateF = new SimpleDateFormat("YYYY-MM-DD");
		PaymentDao paymentDao = new PaymentDao();
		System.out.println("Enter Date in YYYY-MM-DD formate for total business:");
		String dt=scan.next();
//		Date givenDate = (Date) dateF.parse(dt);
		Date givenDate = null;
		givenDate=Date.valueOf(dt);
		System.out.println(givenDate);
		givendate_business=paymentDao.GivenDateBusiness(givenDate);
		System.out.println(givendate_business);
	}
	
	
}
