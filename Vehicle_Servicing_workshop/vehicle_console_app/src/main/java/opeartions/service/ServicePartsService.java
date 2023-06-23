package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServicePartsDao;
import operations.models.Part;
import operations.models.Service;
import operations.models.Service_Parts;

public class ServicePartsService {

	
	static Scanner scan = new Scanner(System.in);
	
	public static void getServiceParts() {
		List<Service_Parts> SPList = new ArrayList<>();
		try {
			ServicePartsDao servicePartsDao = new ServicePartsDao();
			SPList=servicePartsDao.getAllServiceParts(SPList);
			for(Service_Parts sp : SPList) {
				System.out.println(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Service_Parts addServiceParts(Service_Parts sp) {
		int isAdded=0;
		
		try {
			
			ServicePartsDao servicePartsDao = new ServicePartsDao();
			isAdded=servicePartsDao.addThisServicePart(sp);
			if(isAdded>0) {
				System.out.println("Inserted ServiceParts...");
			}else {
				System.out.println("Can not Insert ServicePart...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}
	
	
}
