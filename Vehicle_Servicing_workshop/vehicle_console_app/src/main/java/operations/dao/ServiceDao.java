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
import operations.models.Service_requests;

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
	
//-----------------------------------------------------------------------------------------------------
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
	
	public static int updateThisService(int sid,double oil_cost,double labour_charges) {
		String q4="update services set oil_cost=?, labour_charges=? ,totla_cost=? where service_id=?";
		int num=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q4);
			pmt.setDouble(1, oil_cost);
			pmt.setDouble(2, labour_charges);
			pmt.setDouble(3, oil_cost+labour_charges );
			pmt.setInt(4, sid);
			num=pmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}


	
//---------------------------------------------------------------------------
	
	public static void addThisServiceByMaintainance(Maintainance m) {
		int num=0;
		String q5="insert into services (service_id,type,labour_charges,total_cost,remark, service_request_id) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setInt(1, m.getService_id());
			pmt.setString(2,m.getType());
			pmt.setDouble(3, m.getLabour_charges());
			pmt.setDouble(4, m.getTotal_cost());
			pmt.setString(5, m.getRemark());
			pmt.setInt(6, m.getService_request_id());
			num=pmt.executeUpdate();
//			Maintainance m = new Maintainance(sid,type,labour_charges,total_cost,remark,srid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return num;
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------
	public int addThisServiceByOil(int sid, String type, double oil_cost, double total_cost, String remark, int srid) {
		int num=0;
		String q5="insert into services (service_id,type,oil_cost,total_cost,remark, service_request_id) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setInt(1, sid);
			pmt.setString(2,type);
			pmt.setDouble(3, oil_cost);
			pmt.setDouble(4, total_cost);
			pmt.setString(5, remark);
			pmt.setInt(6, srid);
			num=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	
}
