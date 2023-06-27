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
	
	public static void getServiceParts() throws SQLException {
		List<Service_Parts> SPList = new ArrayList<>();
		ServicePartsDao servicePartsDao = new ServicePartsDao();
		SPList=servicePartsDao.getAllServiceParts(SPList);
		for(Service_Parts sp : SPList) {
			System.out.println(sp);
		}
	}
	
	
	public static Service_Parts addServiceParts(Service_Parts sp) throws SQLException {
		int isAdded=0;
		
		ServicePartsDao servicePartsDao = new ServicePartsDao();
		isAdded=servicePartsDao.addThisServicePart(sp);
		if(isAdded>0) {
			System.out.println("Inserted ServiceParts...");
		}else {
			System.out.println("Can not Insert ServicePart...");
		}
		return sp;
	}
	
	
}
