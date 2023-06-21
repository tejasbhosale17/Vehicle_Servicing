package operations.models;

public class Oil extends Service{
	double oil_cost;


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

	public Oil(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public double getOil_cost() {
		return oil_cost;
	}

	public void setOil_cost(double oil_cost) {
		this.oil_cost = oil_cost;
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
