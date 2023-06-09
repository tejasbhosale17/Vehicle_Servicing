package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServiceDao;

import operations.models.Service;

public class OfferedServicesService {

	static Scanner scan = new Scanner(System.in);
	
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
//------------------------------------------------------------------------------------------
	public static void thisServiceThere() {
		try {
			System.out.println("Enter Service_id:");
			int sid=scan.nextInt();
			ServiceDao serviceDao = new ServiceDao();
			Service s=serviceDao.findThisService(sid);
			if(s!=null) {
				System.out.println("Service Already Exists!!");
				System.out.println(s);
			}else {
				System.out.println("Service Does not Exists!!");
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}	
	}
//------------------------------------------------------------------------------------------
	
	
	
	
}

