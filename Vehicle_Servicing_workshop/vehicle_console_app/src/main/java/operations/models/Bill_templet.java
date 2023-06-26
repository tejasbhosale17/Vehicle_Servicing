package operations.models;

import java.sql.Date;

public class Bill_templet {
	
	String Service_Station_name="Vehicle Service Station";
	Date Service_date;
	Customer c;
	Customer_Vehicle_Details cvd;
	Part p;
	Service_requests sr;
	
	public Bill_templet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill_templet(String service_Station_name, Date service_date, Customer c, Customer_Vehicle_Details cvd,
			Part p, Service_requests sr) {
		super();
		Service_Station_name = service_Station_name;
		Service_date = service_date;
		this.c = c;
		this.cvd = cvd;
		this.p = p;
		this.sr = sr;
	}

	public String getService_Station_name() {
		return Service_Station_name;
	}

	public void setService_Station_name(String service_Station_name) {
		Service_Station_name = service_Station_name;
	}

	public Date getService_date() {
		return Service_date;
	}

	public void setService_date(Date service_date) {
		Service_date = service_date;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public Customer_Vehicle_Details getCvd() {
		return cvd;
	}

	public void setCvd(Customer_Vehicle_Details cvd) {
		this.cvd = cvd;
	}

	public Part getP() {
		return p;
	}

	public void setP(Part p) {
		this.p = p;
	}

	public Service_requests getSr() {
		return sr;
	}

	public void setSr(Service_requests sr) {
		this.sr = sr;
	}

	@Override
	public String toString() {
		return "Bill_templet [Service_Station_name=" + Service_Station_name + ", Service_date=" + Service_date + ", c="
				+ c + ", cvd=" + cvd + ", p=" + p + ", sr=" + sr + "]";
	}

	
}
