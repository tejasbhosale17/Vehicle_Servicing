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

	//---------------------------------------------------------------------
	
	
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
//--------------------------------------------------------------------------------------
	public Customer_vehicles searchThisVehicle(String vnumber) {
		String q6="select * from customer_vehicles where  vehicle_number = ?";
		try {
			PreparedStatement pmt= con.prepareStatement(q6);
			pmt.setString(1, vnumber);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				System.out.println("Customer's Vehicle Exists");
				Customer_vehicles cv =new Customer_vehicles(rs.getString("vehicle_number"),rs.getInt("customer_id"),rs.getInt("vehicle_id"));
				return cv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//-----------------------------------------------------------------------------------------------
	public int addCustomerVehicle(String vehicle_number, int customer_id, int vehicle_id) {
		String q7="insert into customer_vehicles values(?,?,?)";
		int isAdded=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q7);
			pmt.setString(1, vehicle_number);
			pmt.setInt(2, customer_id);
			pmt.setInt(3, vehicle_id);
			isAdded=pmt.executeUpdate();
			isAdded=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isAdded;
	}
//----------------------------------------------------------------------------------
	public static int ListVehicleOfCustomer(int customer_id) {
		String q6="select * from customer_vehicles where  customer_id = ?";
		int isHere=0;
		try {
			PreparedStatement pmt= con.prepareStatement(q6);
			pmt.setInt(1, customer_id);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				System.out.println("List of Vehicles of This Customer");
				Customer_vehicles cv =new Customer_vehicles(rs.getString("vehicle_number"),rs.getInt("customer_id"),rs.getInt("vehicle_id"));
				System.out.println(cv);
				isHere=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isHere;
	}

}
