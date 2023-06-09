package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Service;

public class ServiceDao {


	static Connection con;
	
	public ServiceDao() throws SQLException{
		try {
			con=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//-------------------------------------------------------------------------	
	public void getAllservices(List<Service> serviceList) {
		String q1="select * from services";
		try {
			PreparedStatement pmt =con.prepareStatement(q1);
			ResultSet rs =pmt.executeQuery();
			while(rs.next()) {
				Service s= new Service(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("oil_cost"),rs.getDouble("labour_charges"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
				serviceList.add(s);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

//------------------------------------------------------------------------------------------------
	
	public static Service findThisService(int sid) {
		
		String q2="select * from services where service_id=?";
		try {
			PreparedStatement pmt = con.prepareStatement(q2);
			pmt.setInt(1, sid);
			ResultSet rs =pmt.executeQuery();
			if(rs.next()) {
				Service s = new Service(sid,rs.getString("type"),rs.getDouble("oil_cost"),rs.getDouble("labour_charges"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//------------------------------------------------------------------------------------------------
	
	public int deleteThisService(int sid) {
		String q3="delete from services where service_id=?";
		PreparedStatement pmt;
		int num=0;
		try {
			pmt = con.prepareStatement(q3);
			pmt.setInt(1, sid);
			num=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}


	
//-------------------------------------------------------------------------------------------------------
	
	public int updateThisService(int sid,double lc,double tc) {
		String q4="update services set labour_charges=? ,totla_cost=? where service_id=?";
		int num=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q4);
			pmt.setDouble(1, lc);
			pmt.setDouble(2, tc);
			pmt.setInt(3, sid);
			num=pmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
	}
}
