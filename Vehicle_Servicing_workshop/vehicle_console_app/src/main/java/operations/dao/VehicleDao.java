package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Vehicle;

public class VehicleDao {

	static Connection con;
	
	public VehicleDao() throws SQLException{
		this.con=DBUtil.getConnection();
	}
	
	
	public void getAllVehicles(List<Vehicle> vehicleList) {
		String q1="select * from vehicle";
		try {
			PreparedStatement pmt= con.prepareStatement(q1);
			ResultSet rs= pmt.executeQuery();
			while(rs.next()) {
				Vehicle v =new Vehicle(rs.getInt("vehicle_id"), rs.getString("company"), rs.getString("model"));
				vehicleList.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//--------------------------------------------------------------------------------------

	public Vehicle getThatVehicle(int id) {
		String q2="select * from vehicle where vehicle_id=?";
		try {
			PreparedStatement pmt =con.prepareStatement(q2);
			pmt.setInt(1, id);
			ResultSet rs= pmt.executeQuery();
			if(rs.next()) {
				Vehicle v = new Vehicle(rs.getInt("vehicle_id"), rs.getString("company"),rs.getString("model"));
				return v;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
//------------------------------------------------------------------------------------------------
	

	public int removeThatVehicleUsingId(int vid) {
		String q3="delete from vehicle where vehicle_id=?";
		int nvr=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q3);
			pmt.setInt(1, vid);
			nvr=pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nvr;
	}
	
//----------------------------------------------------------------------------------------------------
//	public int removeThatVehicleUsingNumber(String vehicle_number) {
//		String q3="delete from vehicle where vehicle_number=?";
//		int nvr=0;
//		try {
//			PreparedStatement pmt =con.prepareStatement(q3);
//			pmt.setString(1, vehicle_number);
//			nvr=pmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return nvr;
//	}
//----------------------------------------------------------------------------------------------------
	

	public int changeThatVehicle(int id, String model) {
		String q4="update vehicle set model=? where vehicle_id=?";
		int nvu=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q4);
			pmt.setString(1, model);
			pmt.setInt(2, id);
			nvu=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nvu;
	}

//--------------------------------------------------------------------------------------------
	
	public int addThisVehicle(int id, String company, String model) {
		String q5="insert into vehicle values(?,?,?)";
		int nva=0;
		try {
			PreparedStatement pmt=con.prepareStatement(q5);
			pmt.setInt(1, id);
			pmt.setString(2, company);
			pmt.setString(3, model);
			nva=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nva;
	}

}
