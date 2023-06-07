package operations.models;

public class Customer {
	int customer_id;
	String customer_name;
	Long mobile;
	String email;
	String address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, Long mobile, String email, String addr) {
		super();
		this.customer_id = id;
		this.customer_name = name;
		this.mobile = mobile;
		this.email = email;
		this.addr = addr;
	}
	public int getId() {
		return customer_id;
	}
	public void setId(int id) {
		this.customer_id = id;
	}
	public String getName() {
		return customer_name;
	}
	public void setName(String name) {
		this.customer_name = name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	String addr;
	@Override
	public String toString() {
		return "Customer [id=" + customer_id + ", name=" + customer_name + ", mobile=" + mobile + ", email=" + email + ", addr=" + addr
				+ "]";
	}
	
}
