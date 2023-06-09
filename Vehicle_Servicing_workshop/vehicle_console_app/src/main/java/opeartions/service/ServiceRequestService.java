package opeartions.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServiceRequestDao;
import operations.models.Service_requests;

public class ServiceRequestService {

	static Scanner scan = new Scanner(System.in);
	
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

	public static void getThisServiceRequest() {
		int srid=scan.nextInt();
		try {
			ServiceRequestDao serviceRequestDao = new ServiceRequestDao();
			Service_requests sr=serviceRequestDao.findThisServiceRequest(srid);
			if(sr!=null) {
				System.out.println("Service Request Exists!!");
				System.out.println(sr);
			}else {
				System.out.println("Service Request Does Not Exists!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
