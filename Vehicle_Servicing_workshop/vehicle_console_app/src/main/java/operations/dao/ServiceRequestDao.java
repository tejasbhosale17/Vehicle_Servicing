package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Service_requests;

public class ServiceRequestDao {

	private static Connection con;
	
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
}
