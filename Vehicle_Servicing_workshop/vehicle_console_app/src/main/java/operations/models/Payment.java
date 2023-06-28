package operations.models;

import java.sql.Date;

public class Payment {
int payment_id;
int service_request_id;
Long mobile;
Date transaction_date;
double paid_amount;


public Payment(int payment_id, int service_request_id, Date transaction_date, double paid_amount) {
	super();
	this.payment_id = payment_id;
	this.service_request_id = service_request_id;
	this.transaction_date = transaction_date;
	this.paid_amount = paid_amount;
}


public Payment(int service_request_id, Long mobile, double paid_amount) {
	super();
	this.service_request_id = service_request_id;
	this.mobile = mobile;
	this.paid_amount = paid_amount;
}


public Payment() {
	super();
	// TODO Auto-generated constructor stub
}


public Payment(int payment_id, int service_request_id, Long mobile, Date transaction_date, double paid_amount) {
	super();
	this.payment_id = payment_id;
	this.service_request_id = service_request_id;
	this.mobile = mobile;
	this.transaction_date = transaction_date;
	this.paid_amount = paid_amount;
}


public int getPayment_id() {
	return payment_id;
}


public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}


public int getService_request_id() {
	return service_request_id;
}


public void setService_request_id(int service_request_id) {
	this.service_request_id = service_request_id;
}


public Long getMobile() {
	return mobile;
}


public void setMobile(Long mobile) {
	this.mobile = mobile;
}


public Date getTransaction_date() {
	return transaction_date;
}


public void setTransaction_date(Date transaction_date) {
	this.transaction_date = transaction_date;
}


public double getPaid_amount() {
	return paid_amount;
}


public void setPaid_amount(double paid_amount) {
	this.paid_amount = paid_amount;
}


@Override
public String toString() {
	return "Payment [payment_id=" + payment_id + ", service_request_id=" + service_request_id + ", mobile=" + mobile
			+ ", transaction_date=" + transaction_date + ", paid_amount=" + paid_amount + "]";
}






}
