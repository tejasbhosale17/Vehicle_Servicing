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
