package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Customer_Vehicle_Details;
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
		String q8="select * from customer_vehicles where  customer_id = ?";
//		String q9="select * from customer_vehicles cv inner join vehicle v on cv.vehicle_id=v.vehicle_id where customer_id=?";
		int isHere=0;
		try {
			PreparedStatement pmt= con.prepareStatement(q8);
			pmt.setInt(1, customer_id);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
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
//----------------------------------------------------------------------------------
	
	public static void ListVehicleDetails(List<Customer_Vehicle_Details> CVDList,int customer_id) {
		String q9="select * from customer_vehicles cv inner join vehicle v on cv.vehicle_id=v.vehicle_id where customer_id=?";
		int isHere=0;
		try {
			PreparedStatement pmt= con.prepareStatement(q9);
			pmt.setInt(1, customer_id);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
				Customer_Vehicle_Details cvd =new Customer_Vehicle_Details(rs.getString("vehicle_number"),rs.getInt("customer_id"),rs.getInt("vehicle_id"),rs.getString("company"),rs.getString("model"));
				System.out.println(cvd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//------------------------------------------------------------------------------------
	public int removeThisVehicle(String vehicle_number) {
		String q9="delete from customer_vehicles where vehicle_number=?";
		int idDeleted=0;
		try {
			PreparedStatement pmt=con.prepareStatement(q9);
			pmt.setString(1,vehicle_number);
			idDeleted=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idDeleted;
	}

	//-----------------------------------------------------------------------------------
	public static void thisMyVehicle(int customer_id,int vid) {
		String q6="select * from customer_vehicles where customer_id=? and vehicle_id = ?";
		try {
			PreparedStatement pmt= con.prepareStatement(q6);
			pmt.setInt(1, customer_id);
			pmt.setInt(2, vid);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				System.out.println("Customer's Vehicle Exists");
				Customer_vehicles cv =new Customer_vehicles(rs.getString("vehicle_number"),rs.getInt("customer_id"),rs.getInt("vehicle_id"));
				System.out.println(cv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
