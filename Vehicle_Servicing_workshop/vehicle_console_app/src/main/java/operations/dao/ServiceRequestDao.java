package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbUtil.DBUtil;
import operations.models.Service_requests;

public class ServiceRequestDao {

	private static Connection con;
	Scanner scan  =new Scanner(System.in);
	
	public ServiceRequestDao() throws SQLException{
		try {
			con=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void listAllServiceRequests(List<Service_requests> srlist) {
		// TODO Auto-generated method stub
		String q1="select * from service_requests";
		try {
			PreparedStatement pmt  = con.prepareStatement(q1);
			ResultSet rs = pmt.executeQuery();
			while(rs.next()) {
				Service_requests sr= new Service_requests(rs.getInt("service_request_id"),rs.getString("vehicle_number"),rs.getDate("request_date"),rs.getDouble("bill_amount"));
				srlist.add(sr);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//---------------------------------------------------------------------------------------------
	public Service_requests findThisServiceRequest(int srid) {
		String q2="select * from service_requests where service_request_id=?";
		try {
			PreparedStatement pmt =con.prepareStatement(q2);
			pmt.setInt(1, srid);
			ResultSet rs= pmt.executeQuery();
			if(rs.next()) {
				Service_requests sr= new Service_requests(srid,rs.getString("vehicle_number"),rs.getDate("request_date"),rs.getDouble("bill_amount"));
				return sr;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//---------------------------------------------------------------------------------------------
	public void findServiceRequestByVehicleNumber(List<Service_requests> srlist,String Vehicle_number) {
		
		String q2="select * from service_requests where vehicle_number=?";
		try {
			PreparedStatement pmt =con.prepareStatement(q2);
			pmt.setString(1, Vehicle_number);
			ResultSet rs= pmt.executeQuery();
			while(rs.next()) {
				Service_requests sr= new Service_requests(rs.getInt("service_request_id"),Vehicle_number,rs.getDate("request_date"),rs.getDouble("bill_amount"));
				srlist.add(sr);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


//-------------------------------------------------------------------------------------------------------
	public int updateThisServiceRequest(int service_request_id,double bill_amount) {
		String q3="update service_requests set bill_amount=? where service_request_id=?";
		int updated=0;
		try {
			PreparedStatement pmt= con.prepareStatement(q3);
			
			pmt.setInt(2, service_request_id);
			pmt.setDouble(1, bill_amount );
			updated=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updated;
	}


//-----------------------------------------------------------------------------------------------------------
	public int deleteThisServiceRequest(int service_request_id) {
		String q4="delete from service_requests where service_request_id=?";
		int deleted=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q4);
			pmt.setInt(1, service_request_id);
			deleted=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleted;
	}


//---------------------------------------------------------------------------------------------------------------
	public int addThisServiceRequest(int service_request_id, String vehicle_number) {
		String q5="insert into service_requests (service_request_id,vehicle_number) values(?,?);";
		int isInserted=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q5);
			pmt.setInt(1, service_request_id);
			pmt.setString(2, vehicle_number);
			isInserted=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isInserted;
	}



	public int pushingThisServiceRequest(int service_request_id, String vehicle_number) {
		String q10="insert into service_requests (service_request_id,vehicle_number) values(?,?)";
		int isInserted=0;
		try {
			PreparedStatement pmt= con.prepareStatement(q10);
			pmt.setInt(1, service_request_id);
			pmt.setString(2, vehicle_number);
			isInserted=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInserted;
	}
}
