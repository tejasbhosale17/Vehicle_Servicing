package operations.models;

import java.sql.Date;

public class Service_requests {

	int service_request_id;
	String vehicle_number;
	Date request_date;
	double bill_amount;
	
	public Service_requests(int service_request_id, String vehicle_number) {
		super();
		this.service_request_id = service_request_id;
		this.vehicle_number = vehicle_number;
	}
	
	public Service_requests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service_requests(int service_request_id, String vehicle_number, Date request_date, double bill_amount) {
		super();
		this.service_request_id = service_request_id;
		this.vehicle_number = vehicle_number;
		this.request_date = request_date;
		this.bill_amount = bill_amount;
	}

	public int getService_request_id() {
		return service_request_id;
	}

	public void setService_request_id(int service_request_id) {
		this.service_request_id = service_request_id;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public double getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(double bill_amount) {
		this.bill_amount = bill_amount;
	}

	@Override
	public String toString() {
		return "Service_requests [service_request_id=" + service_request_id + ", vehicle_number=" + vehicle_number
				+ ", request_date=" + request_date + ", bill_amount=" + bill_amount + "]";
	}
	
	
	
}
