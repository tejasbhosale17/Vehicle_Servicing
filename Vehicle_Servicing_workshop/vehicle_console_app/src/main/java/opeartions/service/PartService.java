package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.PartDao;
import operations.models.Part;
import operations.models.Service;

public class PartService {

	static Scanner scan = new Scanner(System.in);
	
	public static void getAllParts() throws SQLException {
		List<Part> partList = new ArrayList<>();
		PartDao partDao = new PartDao();
		partDao.getAppParts(partList);
		for(Part p : partList) {
			System.out.println(p);
		}
	}
//-------------------------------------------------------------------------------
	public static void getSpecificPartById() throws SQLException {
		System.out.println("Enter partid to find part:");
		int id=scan.nextInt();
		PartDao partDao = new PartDao();
		Part part = new Part();
		part=partDao.findThisPartById(id);
		if(part!=null) {
			System.out.println(part);
		}else {
			System.out.println("Part not found.. :(");
		} 
	}
//-------------------------------------------------------------------------------------
	public static void getSpecificPartByServiceId(Service service) throws SQLException {
		int id=service.getService_id();
		PartDao partDao = new PartDao();
		Part part = new Part();
		part=partDao.findThisPartById(id);
		if(part!=null) {
			System.out.println(part);
		}else {
			System.out.println("Part not found.. :(");
		} 
	}
	
//-------------------------------------------------------------------------------
	public static int getSpecificPartByName(String part_name) throws SQLException {
		int part_id=0;
		PartDao partDao = new PartDao();
		Part part = new Part();
		part=partDao.findThisPartByName(part_name);
		if(part!=null) {
			System.out.println(part);
			part_id=part.getPid();
			System.out.println(part_id);
		}else {
			System.out.println("Part not found.. :(");
		} 
		return part_id;
	}
//-------------------------------------------------------------------------------

	public static void removePart() throws SQLException {
		System.out.println("Enter pid to delete the part:");
		int id= scan.nextInt();
		PartDao partDao = new PartDao();
		int isRemoved=partDao.removeThisPart(id);
		if(isRemoved>0) {
			System.out.println("Part Removed Succesfully!");
		}else {
			System.out.println("Part Not Found...");
		}
		
	}
//-------------------------------------------------------------------------------

	public static void updatePart() throws SQLException {
		System.out.println("Enter part id and price to update");
		PartDao partDao = new PartDao();
		int isUpdated=partDao.updateThisPart(scan.nextInt(),scan.nextDouble());
		if(isUpdated>0) {
			System.out.println(isUpdated+" Part Updated Sucesfully!");
		}else {
			System.out.println("Part not found...");
		}
		
	}
//-------------------------------------------------------------------------------

	public static void addPart() throws SQLException {
		System.out.println("Enter id,name,desc,price:");
		PartDao partDao = new PartDao();
		int id=scan.nextInt();
		String name=scan.next();
		scan.nextLine();
		String descrip = scan.nextLine();
		double price=scan.nextDouble();
		int isInserted =partDao.addThisPart(id,name,descrip,price);
		if(isInserted>0) {
			System.out.println(isInserted+" Part Added Succesfully!");
		}else{
			System.out.println("Part not Found...");
		}
		
		
	}

}
