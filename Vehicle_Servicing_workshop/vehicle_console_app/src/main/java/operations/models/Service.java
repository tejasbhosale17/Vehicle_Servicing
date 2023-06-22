package operations.models;

public abstract class Service {
	protected int service_id;
	protected String type;
//	 double oil_cost;
//	 double labour_charges;
	protected double total_cost;
	protected String remark;
	protected int service_request_id;
	 
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Service(String type) {

		this.type=type;
		// TODO Auto-generated constructor stub
	}
	
	public Service(int service_id, String type, double total_cost, String remark, int service_request_id) {
		super();
		this.service_id = service_id;
		this.type = type;
		this.total_cost = total_cost;
		this.remark = remark;
		this.service_request_id = service_request_id;
	}
	
	public int getService_id() {
		return service_id;
	}
	
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getTotal_cost() {
		return total_cost;
	}
	
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getService_request_id() {
		return service_request_id;
	}
	
	public void setService_request_id(int service_request_id) {
		this.service_request_id = service_request_id;
	}


	public abstract void acceptService();
	public abstract void calculateTotalCost(); 
	
}




