package operations.models;

public class Customer_Vehicle_Details {
	String vehicle_number;
	int customer_id;
	int vehicle_id;
	String company;
	String model;
	
	public Customer_Vehicle_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer_Vehicle_Details(String vehicle_number, int customer_id, int vehicle_id, String company,
			String model) {
		super();
		this.vehicle_number = vehicle_number;
		this.customer_id = customer_id;
		this.vehicle_id = vehicle_id;
		this.company = company;
		this.model = model;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Customer_Vehicle_Details [vehicle_number=" + vehicle_number + ", customer_id=" + customer_id
				+ ", vehicle_id=" + vehicle_id + ", company=" + company + ", model=" + model + "]";
	}
	
	
	
	
	
}
