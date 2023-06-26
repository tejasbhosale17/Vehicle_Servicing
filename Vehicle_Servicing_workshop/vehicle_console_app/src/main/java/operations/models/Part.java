package operations.models;

public class Part {

	int part_id;
	String part_name;
	String description;
	double price;
	
	public Part(int pid, String pname, String description, double price) {
		super();
		this.part_id = pid;
		this.part_name = pname;
		this.description = description;
		this.price = price;
	}
	
	
	
	public Part(String part_name, double price) {
		super();
		this.part_name = part_name;
		this.price = price;
	}



	public Part() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return part_id;
	}
	public void setPid(int pid) {
		this.part_id = pid;
	}
	public String getPname() {
		return part_name;
	}
	public void setPname(String pname) {
		this.part_name = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Part [pid=" + part_id + ", pname=" + part_name + ", description=" + description + ", price=" + price + "]";
	} 
}
