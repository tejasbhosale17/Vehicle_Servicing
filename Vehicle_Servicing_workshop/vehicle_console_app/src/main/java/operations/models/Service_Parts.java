package operations.models;

public class Service_Parts {
 int service_id;
 int part_id;
 int quantity;
 
 
 
public Service_Parts() {
	super();
	// TODO Auto-generated constructor stub
}



public Service_Parts(int service_id, int part_id, int quantity) {
	super();
	this.service_id = service_id;
	this.part_id = part_id;
	this.quantity = quantity;
}



public int getService_id() {
	return service_id;
}



public void setService_id(int service_id) {
	this.service_id = service_id;
}



public int getPart_id() {
	return part_id;
}



public void setPart_id(int part_id) {
	this.part_id = part_id;
}



public int getQuantity() {
	return quantity;
}



public void setQuantity(int quantity) {
	this.quantity = quantity;
}



@Override
public String toString() {
	return "Service_Parts [service_id=" + service_id + ", part_id=" + part_id + ", quantity=" + quantity + "]";
}
 
 
 
}
