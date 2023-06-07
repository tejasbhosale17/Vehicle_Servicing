package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Customer_vehicles;

public class CustomerVehicleDao {
static Connection con;
	
	public CustomerVehicleDao() throws SQLException{
		this.con=DBUtil.getConnection();
	}
	
	
	public void getAllVehicles(List<Customer_vehicles> CVList) {
		String q1="select * from customer_vehicles";
		try {
			PreparedStatement pmt= con.prepareStatement(q1);
			ResultSet rs= pmt.executeQuery();
			while(rs.next()) {
				Customer_vehicles v =new Customer_vehicles(rs.getString("vehicle_number"), rs.getInt("customer_id"), rs.getInt("vehicle_id"));
				CVList.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
