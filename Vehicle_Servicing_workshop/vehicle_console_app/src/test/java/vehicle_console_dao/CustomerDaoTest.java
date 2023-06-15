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
	void testgetAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		try {
			CustomerDao customerDao = new CustomerDao();
			customerDao.getAllCustomers(customerList);
			for (Customer customer : customerList)
			{
				System.out.println(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testgetThatCustomer() {
		long mobile=scan.nextLong();
		
		try {
			CustomerDao customerDao = new CustomerDao();
			Customer customer =new Customer();
			customer=customerDao.getThatCustomer(mobile);
			if(customer!=null) {
				System.out.println(customer);
			}else {
				System.out.println("Customer Does not exists!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  
	
	@Test
	void testremoveThatCustomer() {
		
		try {
			CustomerDao customerDao = new CustomerDao();
			customerDao.removeThatCustomer(11);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testaddThisCustomer() {
		int cpu=0;
		try {
			CustomerDao customerDao = new CustomerDao();
			cpu=customerDao.addThisCustomer(11, "Tejas", scan.nextLong(), "tejas@gmail.com", "vcab gibcgquci");
			System.out.println(cpu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testupdateThisCustomer() {
		int ncu=0;
		try {
			CustomerDao customerDao = new CustomerDao();
			ncu=customerDao.updateThisCustomer(11, scan.nextLong(),"caibi ahucin");
			System.out.println(ncu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
