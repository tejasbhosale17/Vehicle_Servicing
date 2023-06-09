package operations.models;

public class Service {
	int service_id;
	 String type;
	 double oil_cost;
	 double labour_charges;
	 double total_cost;
	 String remark;
	 int service_request_id;
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(int service_id, String type, double oil_cost, double labour_charges, double total_cost,
			String remark, int service_request_id) {
		super();
		this.service_id = service_id;
		this.type = type;
		this.oil_cost = oil_cost;
		this.labour_charges = labour_charges;
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
	public double getOil_cost() {
		return oil_cost;
	}
	public void setOil_cost(double oil_cost) {
		this.oil_cost = oil_cost;
	}
	public double getLabour_charges() {
		return labour_charges;
	}
	public void setLabour_charges(double labour_charges) {
		this.labour_charges = labour_charges;
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
	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", type=" + type + ", oil_cost=" + oil_cost + ", labour_charges="
				+ labour_charges + ", total_cost=" + total_cost + ", remark=" + remark + ", service_request_id="
				+ service_request_id + "]";
	}
	 
}
