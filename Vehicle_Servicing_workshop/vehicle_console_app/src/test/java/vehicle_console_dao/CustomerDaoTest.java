package vehicle_console_dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import operations.dao.CustomerDao;
import operations.models.Customer;

class CustomerDaoTest {

	static Scanner scan = new Scanner(System.in);

	
	
	@Test
	void testgetAllCustomers() throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		CustomerDao customerDao = new CustomerDao();
		customerDao.getAllCustomers(customerList);
		for (Customer customer : customerList)
		{
			System.out.println(customer);
		}
		
	}
	
	@Test
	void testgetThatCustomer() throws SQLException {
		long mobile=scan.nextLong();
		
		CustomerDao customerDao = new CustomerDao();
		Customer customer =new Customer();
		customer=customerDao.getThatCustomer(mobile);
		if(customer!=null) {
			System.out.println(customer);
		}else {
			System.out.println("Customer Does not exists!");
		}
		
	}  
	
	@Test
	void testremoveThatCustomer() throws SQLException {
		
		CustomerDao customerDao = new CustomerDao();
		customerDao.removeThatCustomer(11);
	}
	
	@Test
	void testaddThisCustomer() throws SQLException {
		int cpu=0;
		CustomerDao customerDao = new CustomerDao();
		cpu=customerDao.addThisCustomer(11, "Tejas", scan.nextLong(), "tejas@gmail.com", "vcab gibcgquci");
		System.out.println(cpu);
	}
	
	@Test
	void testupdateThisCustomer() throws SQLException {
		int ncu=0;
		CustomerDao customerDao = new CustomerDao();
		ncu=customerDao.updateThisCustomer(11, scan.nextLong(),"caibi ahucin");
		System.out.println(ncu);
	}
	

}
