package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Maintainance;
import operations.models.Oil;
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
	public static void getAllservices(List<Service> serviceList) {
		String q1="select * from services";
		String oil="oil";
		String maintainance="maintainance";
		try {
			PreparedStatement pmt =con.prepareStatement(q1);
			ResultSet rs =pmt.executeQuery();
			while(rs.next()) {
				String type=rs.getString("type");
				if(type.equals(oil)) {
					Oil o= new Oil(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("oil_cost"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
					serviceList.add(o);
				}else if(type.equals(maintainance)) {
					Maintainance m =new Maintainance(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("labour_charges"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
					serviceList.add(m);
				}else {
					System.out.println("Worng Entry...!");
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

//------------------------------------------------------------------------------------------------
	
	public static void findThisService(List<Service> serviceList,int service_request_id) {
		
		String q2="select * from services where service_request_id=?";
		String oil="oil";
		String maintainance="maintainance";
		try {
			PreparedStatement pmt = con.prepareStatement(q2);
			pmt.setInt(1, service_request_id);
			ResultSet rs =pmt.executeQuery();
			while(rs.next()) {
				String type=rs.getString("type");
				if(type.equals(oil)) {
					Oil o= new Oil(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("oil_cost"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
					serviceList.add(o);
				}else if(type.equals(maintainance)) {
					Maintainance m =new Maintainance(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("labour_charges"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
					serviceList.add(m);
				}else {
					System.out.println("Worng Entry...!");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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


	
//---------------------------------------------------------------------------
	
	public int addThisService(int sid, String type, double oil_cost, double labour_charges, double total_cost, String remark, int srid) {
		int num=0;
		String q5="insert into services values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setInt(1, sid);
			pmt.setString(2,type);
			pmt.setDouble(3, oil_cost);
			pmt.setDouble(4, labour_charges);
			pmt.setDouble(5, total_cost);
			pmt.setString(6, remark);
			pmt.setInt(7, srid);
			num=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return num;
	}
	
	
}
