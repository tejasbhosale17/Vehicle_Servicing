package operations.models;

import java.util.Scanner;


public class Oil extends Service{
	protected double oil_cost;
	Scanner scan  = new Scanner(System.in);

	public Oil() {
		super("oil");
		// TODO Auto-generated constructor stub
	}

	public Oil(double oil_cost) {
		super();
		this.oil_cost = oil_cost;
	}
	


	@Override
	public String toString() {
		return "Oil [ service_id=" + service_id + ", type=" + type + ", oil_cost=" + oil_cost + ", total_cost="
				+ total_cost + ", remark=" + remark + ", service_request_id=" + service_request_id + "]";
	}

	public Oil(int service_id, String type,double oil_cost, double total_cost, String remark, int service_request_id) {
		super(service_id, type, total_cost, remark, service_request_id);
		this.service_id = service_id;
		this.type = type;
		this.oil_cost = oil_cost;
		this.total_cost = total_cost;
		this.remark = remark;
		this.service_request_id = service_request_id;
		
	}

	public Oil(String type,double oil_cost,double total_cost,String remark,int service_request_id) {
		super(type);
		// TODO Auto-generated constructor stub
		this.oil_cost = oil_cost;
		this.total_cost = total_cost;
		this.remark = remark;
		this.service_request_id = service_request_id;
	}

	public double getOil_cost() {
		return oil_cost;
	}

	public void setOil_cost(double oil_cost) {
		this.oil_cost = oil_cost;
	}

	@Override
	public void acceptService() {

		this.type="oil";
		System.out.println("Enter Oil_cost");
		this.oil_cost=scan.nextDouble();
		System.out.println("Enter Remark..");
		scan.nextLine();
		this.remark=scan.nextLine();
		this.total_cost=this.oil_cost;
	}

	@Override
	public void calculateTotalCost() {
		double total_cost=getOil_cost();
		setTotal_cost(total_cost);
		
	}


//	@Override
//	public void acceptService() {
//		// TODO Auto-generated method stub
//		
//	}
	
}
