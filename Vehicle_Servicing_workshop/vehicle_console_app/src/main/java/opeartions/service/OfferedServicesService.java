package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import operations.dao.ServiceDao;

import operations.models.Service;

public class OfferedServicesService {

	
	public static void getAllServices(){
		List<Service> serviceList = new ArrayList<>();
		try {
			ServiceDao serviceDao = new ServiceDao();
			serviceDao.getAllservices(serviceList);
			for(Service s: serviceList) 
			{
				System.out.println("1"+s);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}
	
	
	
}

