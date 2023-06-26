package operations.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import operations.dao.ServiceDao;

public class Maintainance extends Service{

	Scanner scan = new Scanner(System.in);
	double labour_charges;
	double part_cost;
	List<Service_Parts> partList;
	
	
	@Override
	public String toString() {
		return  "Maintainance [ service_id=" + service_id + ", type=" + type+", labour_charges=" + labour_charges
				+ ", total_cost=" + total_cost + ", remark=" + remark + ", service_request_id=" + service_request_id
				+ "]";
	}


	public Maintainance(String type,double labour_charges, String remark,int service_request_id) {
		super("maintainance");
		this.type = type;
		this.labour_charges=labour_charges;
		this.remark = remark;
		this.service_request_id = service_request_id;
	}
	
	public Maintainance() {
		super("maintainance");
		this.labour_charges = 0;
		this.partList = new ArrayList<Service_Parts>();
	}

	public Maintainance(int service_id, String type,double labour_charges, double total_cost, String remark, int service_request_id) {
		super(service_id, type, total_cost, remark, service_request_id);
		this.service_id = service_id;
		this.type = type;
		this.labour_charges=labour_charges;
		this.total_cost = total_cost;
		this.remark = remark;
		this.service_request_id = service_request_id;
	}

	public Maintainance(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}


	public double getLabour_charges() {
		return labour_charges;
	}

	public void setLabour_charges(double labour_charges) {
		this.labour_charges = labour_charges;
	}


	public List<Service_Parts> getPartList() {
		return partList;
	}

	public void setPartList(List<Service_Parts> partList) {
		this.partList = partList;
	}

	@Override
	public void acceptService() {
		System.out.println("Enter labour_charges,remark");
		this.type="maintainance";
		this.labour_charges=scan.nextDouble();
		scan.nextLine();
		this.remark=scan.nextLine();
		this.total_cost=this.labour_charges;
		this.service_request_id=0;
//		/Maintainance m = new Maintainance(type,labour_charges,remark,service_request_id);
		//ServiceDao.addThisServiceByMaintainance(m);
	}

	@Override
	public void calculateTotalCost() {
		double total_cost=getLabour_charges();
		setTotal_cost(total_cost);
		
	}
	
	public void calculateTotalRepairingCost(Part p, int quantity) {
		double total_cost=getLabour_charges()+(p.getPrice()*quantity);
		setTotal_cost(total_cost);
	}
	
}
