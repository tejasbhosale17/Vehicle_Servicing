package operations.models;

import java.util.ArrayList;
import java.util.List;

public class Maintainance extends Service{

	double labour_charges;
	double part_cost;
	List<Service_Parts> partList;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateTotalCost() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
