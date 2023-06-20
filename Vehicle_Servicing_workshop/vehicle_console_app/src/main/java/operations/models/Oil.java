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
