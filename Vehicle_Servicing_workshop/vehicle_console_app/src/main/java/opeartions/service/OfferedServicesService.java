package opeartions.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.PartDao;
import operations.dao.ServiceDao;
import operations.models.Maintainance;
import operations.models.Oil;
import operations.models.Part;
import operations.models.Service;
import operations.models.Service_Parts;
import operations.models.Service_requests;

public class OfferedServicesService {

	static Scanner scan = new Scanner(System.in);
	
	public static void getAllServices(){
		List<Service> serviceList = new ArrayList<>();
		try {
			ServiceDao serviceDao = new ServiceDao();
			serviceDao.getAllservices(serviceList);
			for(Service s: serviceList) 
			{
				System.out.println(s);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
////---------------------------------------------------------------------------------------------------
	public static List<Service> thisServiceThere(List<Service> serviceList,int service_request_id) {
//		List<Service> serviceList = new ArrayList<>();
		try {
//			System.out.println("Enter Service_request_id:");
//			int service_request_id=scan.nextInt();
			ServiceDao serviceDao = new ServiceDao();
			serviceDao.findThisService(serviceList,service_request_id);
//			for(Service s: serviceList) 
//			{
//				System.out.println(s);
//			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return serviceList;	
	}
//-----------------------------------------------------------------------------------------------------
	public static void RemoveThisService() {
		int sid=scan.nextInt();
		int isRemoved=0;
		try {
			ServiceDao serviceDao  =new ServiceDao();
			isRemoved=serviceDao.deleteThisService(sid);
			if(isRemoved > 0) {
				System.out.println("Service Removed!!");
			}else {
				System.out.println("Service Does not exists!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//-------------------------------------------------------------------------------------
	
//	public static void updateThisService(Service s) {
//		System.out.println("enter service_id of the service want to update:");
//		int sid=s.getService_id()
//		System.out.println("enter labour_charges and total_charges want to change:");
//		double lc=
//		double tc=scan.nextInt();
//		int isUpdated=0;
//		try {
//			ServiceDao serviceDao  =new ServiceDao();
//			isUpdated=serviceDao.updateThisService(sid,lc,tc);
//			if(isUpdated > 0) {
//				System.out.println("Service Exists and Updated!!");
//			}else {
//				System.out.println("Service Does Not Exists!!");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//-------------------------------------------------------------------------------------
//	public static void addTheService() {
//		System.out.println("Enter service_id,type,oil_charges,labour charges,total_amount,remark,service_request_id");
//		int isAdded=0;
//		int service_id=scan.nextInt();
//		System.out.println("choose type: oil/maintainance");
//		String type=scan.next();
//		double oil_cost=scan.nextDouble();
//		double labour_charges=scan.nextDouble();
//		double total_cost=scan.nextDouble();
//		System.out.println("Enter remark");
//		scan.nextLine();
//		String remark=scan.nextLine();
//		System.out.println("Enter vehicle number");
//		String vehicle_number=scan.next();
//		ServiceRequestService.getServiceRequestByVehicleNumber(vehicle_number);
//		System.out.println("Enter Service request id");
//		int service_request_id=scan.nextInt();
//		double bill_amount=oil_cost+labour_charges;
//		
////		ServiceRequestService.addServiceRequest(service_request_id, vehicle_number, bill_amount);
//		try {
//			ServiceDao serviceDao  =new ServiceDao();
//			isAdded=serviceDao.addThisService(service_id, type, oil_cost, labour_charges, total_cost, remark, service_request_id);
//			if(isAdded>0) {
//				System.out.println("Service Inserted Succesfully...");
//			}else {
//				System.out.println("Insertion of Service Unsuccesfull...");
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
//------------------------------------------------------------------------------
	
//	public static void addingThisService() {
//		System.out.println("Enter service_id,type,oil_charges,labour charges,total_amount,remark");
//		int isAdded=0;
//		try {
//			ServiceDao serviceDao  =new ServiceDao();
//			System.out.println("Enter remark first");
//			String remark=scan.nextLine();
//			serviceDao.addThisService(scan.nextInt(), scan.next(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), remark, scan.nextInt());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	//--------------------------------------------------------------------------------------------------------------
	public static void addThisServiceByMaintainance(Service_requests sr) {
		List<Service> srList = new ArrayList<>();
		boolean serviceFound=false;
		ServiceRequestService.ListOfServiceRequestsForDate(sr);
		srList=sr.getServiceList();
		System.out.println(srList);
		int srid=sr.getService_request_id();
		Maintainance m = null;
		if(srList.isEmpty()) {	
			m=new Maintainance();
			m.acceptService();
			m.calculateTotalCost();
			ServiceDao.addThisServiceByMaintainance(m,srid);
		}else {
			for(Service s:srList) {
				if(s instanceof  Maintainance) 
					{
						m=(Maintainance) s;
						serviceFound=true;
						break;
					}
			}
				if(serviceFound) {
					System.out.println(m);
					m.acceptService();
					m.calculateTotalCost();
					ServiceDao.updateThisMainatainance(m);
					
				}else {
					m =new Maintainance();
					srList.add(m);
					m.acceptService();
					m.calculateTotalCost();
					ServiceDao.addThisServiceByMaintainance(m,srid);
					
				}
			}
			
		
		
	}
//----------------------------------------------------------------------------------------
//	public static void addThisServiceByMaintainance(Service_requests sr) {
//		List<Service> srList = sr.getServiceList();
//		Maintainance m =null;
//		boolean serviceFound=false;
//		ServiceRequestService.ListOfServiceRequestsForDate(sr);
//		System.out.println(srList);
//		int srid=sr.getService_request_id();
//			if(srList.isEmpty()) {
//				System.out.println("Adding oil if serviceList empty");		
//				m =new Maintainance();
//				m.acceptService();
//				m.calculateTotalCost();
//				ServiceDao.addThisServiceByMaintainance(m, srid);
//				
//			}else {
//				for(Service s:srList)
//				{
//					if(s instanceof  Maintainance) 
//					{
//						m=(Maintainance) s;
//						serviceFound=true;
//						break;
//					}
//				}if(serviceFound) {
//						System.out.println(m);
//							m.acceptService();
//							m.calculateTotalCost();
//							ServiceDao.updateThisMainatainance(m);
//						
//					}else {
//	//					System.out.println("Enter Oil_cost:");
//	//					double oil_cost=scan.nextDouble();
//	//					double labour_charges=0;
//	//					int sid=s.getService_id();
////						System.out.println(s);
//						m =new Maintainance();
//						srList.add(m);
//						m.acceptService();
//						m.calculateTotalCost();
//						ServiceDao.addThisServiceByMaintainance(m,srid);
//						}
//					
//			}
//	}
//----------------------------------------------------------------------------------------
//	public static void addThisServiceByOil(Service_requests sr) {
//		List<Service> srList = sr.getServiceList();
//		Oil o =null;
//		boolean serviceFound=false;
//		ServiceRequestService.ListOfServiceRequestsForDate(sr);
//		System.out.println(srList);
//		int srid=sr.getService_request_id();
//			if(srList.isEmpty()) {
//				System.out.println("Adding oil if serviceList empty");
//				
//				o =new Oil();
//				o.acceptService();
//				o.calculateTotalCost();
//				ServiceDao.addThisServiceByOil(o,srid);
//				
//			}else {
//				for(Service s:srList)
//				{
//					if(s instanceof  Maintainance) 
//					{
//						o=(Oil) s;
//						serviceFound=true;
//						break;
//					}
//				}if(serviceFound) {
//						System.out.println(o);
//							o.acceptService();
//							o.calculateTotalCost();
//							ServiceDao.updateThisOil(o);
//						
//					}else {
//	//					System.out.println("Enter Oil_cost:");
//	//					double oil_cost=scan.nextDouble();
//	//					double labour_charges=0;
//	//					int sid=s.getService_id();
////						System.out.println(s);
//						o =new Oil();
//						srList.add(o);
//						o.acceptService();
//						o.calculateTotalCost();
//						ServiceDao.addThisServiceByOil(o,srid);
//						}
//					
//			}
//	}
//--------------------------------------------------------------------------------------------------------
	public static void addThisServiceByOil(Service_requests sr) {
		List<Service> srList = new ArrayList<>();
		boolean serviceFound=false;
		ServiceRequestService.ListOfServiceRequestsForDate(sr);
		srList=sr.getServiceList();
		System.out.println(srList);
		int srid=sr.getService_request_id();
		Oil o= null;
		
		if(srList.isEmpty()) {	
			o=new Oil();
			o.acceptService();
			o.calculateTotalCost();
			ServiceDao.addThisServiceByOil(o, srid);
		}else {
			for(Service s:srList) {
				if(s instanceof  Oil) 
					{
						o=(Oil) s;
						serviceFound=true;
						break;
					}
			}
				if(serviceFound) {
					System.out.println(o);
					o.acceptService();
					o.calculateTotalCost();
					ServiceDao.updateThisOil(o);
					
				}else {
					o =new Oil();
					srList.add(o);
					o.acceptService();
					o.calculateTotalCost();
					ServiceDao.addThisServiceByOil(o, srid);
					
				}
			}
	}
	
//---------------------- REPAIR -------------------------------------------------------------------------------
public static void addThisServiceByRepair(Service_requests sr) {
	List<Service> srList = new ArrayList<>();
	List<Service_Parts>spList = new ArrayList<>();
	System.out.println("Repairing Your Vehicle:");
	boolean serviceFound=false;
	ServiceRequestService.ListOfServiceRequestsForDate(sr);
	srList=sr.getServiceList();
	System.out.println(srList);
	int srid=sr.getService_request_id();
	Maintainance m = null;
	Service_Parts sp =new Service_Parts();
	if(srList.isEmpty()) {	
		m=new Maintainance();
		m.acceptService();
		m.calculateTotalCost();
		ServiceDao.addThisServiceByMaintainance(m,srid);
		srList.add(m);
	}else {
		for(Service s:srList) {
			if(s instanceof  Maintainance) 
				{
					m=(Maintainance) s;
					serviceFound=true;
					break;
				}
		}
		if(serviceFound) {
			System.out.println(m);
			m.acceptService();
			PartService.getAllParts();
			System.out.println("You want to add any part enter 1 for yes 0 for no:");
			
			while(scan.nextInt()==1){
				System.out.println("Enter part_id and quantity:");
				int part_id=scan.nextInt();
				int quantity=scan.nextInt();
				Part p=PartDao.findThisPartById(part_id);
				m.calculateTotalRepairingCost(p,quantity);
				sp.setService_id(m.getService_id());
				sp.setPart_id(p.getPid());
				sp.setQuantity(quantity);
				sp=ServicePartsService.addServiceParts(sp);
			//============ setting servicePartsList===============
//				m.setTotal_cost(sp.getQuantity()*p.getPrice());	
				spList.add(sp);
				
			}
			m.setPartList(spList);
			List<Service_Parts> servPart = m.getPartList();
			for(Service_Parts x:servPart) {
				System.out.println(x);
			}
//				m.calculateTotalCost();
			ServiceDao.updateThisMainatainance(m);
			
		}else {
			m =new Maintainance();
			srList.add(m);
			m.acceptService();
			m.calculateTotalCost();
			ServiceDao.addThisServiceByMaintainance(m,srid);
		}
	}
	
}
	
	
	
	
}

