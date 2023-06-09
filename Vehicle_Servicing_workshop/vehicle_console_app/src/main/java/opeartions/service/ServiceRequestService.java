package opeartions.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import operations.dao.ServiceRequestDao;
import operations.models.Service_requests;

public class ServiceRequestService {

	
	public static void getAllServiceRequests() {
		List<Service_requests> srlist =new ArrayList<>();
		ServiceRequestDao serviceRequestDao;
		try {
			serviceRequestDao = new ServiceRequestDao();
			serviceRequestDao.listAllServiceRequests(srlist);
			for(Service_requests sr:srlist) {
				System.out.println(sr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
