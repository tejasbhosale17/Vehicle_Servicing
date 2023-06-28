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
	
	static{
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
	
	public static int updateThisMainatainance(Service  service) {
		String q4="update services set remark=CONCAT(?,',',remark), labour_charges=labour_charges+? ,total_cost=total_cost+? where service_id=?";
		int num=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q4);
			pmt.setString(1, service.getRemark());
			pmt.setDouble(2, ((Maintainance) service).getLabour_charges());
			pmt.setDouble(3, service.getTotal_cost());
			pmt.setInt(4, service.getService_id());
			num=pmt.executeUpdate();
			
			if(num>0) {
				System.out.println("Maintainance Updated Succesfully...");
			}else {
				System.out.println("Maintainance Update Unsuccesfull...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public static int updateThisOil(Service service) {
		String q4="update services set remark=CONCAT(?,',',remark), oil_cost=oil_cost+? ,total_cost=total_cost+? where service_id=?";
		int num=0;
		try {
			PreparedStatement pmt = con.prepareStatement(q4);
			pmt.setString(1, service.getRemark());
			pmt.setDouble(2, ((Oil) service).getOil_cost());
			pmt.setDouble(3, service.getTotal_cost() );
			pmt.setInt(4, service.getService_id());
			num=pmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	

	
//---------------------------------------------------------------------------
	
	public static void addThisServiceByMaintainance(Maintainance m,int service_request_id) {
		int num=0;
		double oil_cost=0;
		String q5="insert into services (type,oil_cost, labour_charges,total_cost, remark, service_request_id) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setString(1, m.getType());
			pmt.setDouble(2, oil_cost);
			pmt.setDouble(3, m.getLabour_charges());
			pmt.setDouble(4, m.getTotal_cost());
			pmt.setString(5, m.getRemark());
			pmt.setInt(6, service_request_id);
			num=pmt.executeUpdate();
//			Maintainance m = new Maintainance(sid,type,labour_charges,total_cost,remark,srid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return num;
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------
	public static int addThisServiceByOil(Oil o,int service_request_id) {
		int num=0;
		String q5="insert into services (type,oil_cost,labour_charges,total_cost,remark, service_request_id) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setString(1,o.getType());
			pmt.setDouble(2, o.getOil_cost());
			double labour_cost=0;
			pmt.setDouble(3, labour_cost);
			pmt.setDouble(4, o.getTotal_cost());
			pmt.setString(5, o.getRemark());
			pmt.setInt(6, service_request_id);
			num=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

//--------------------TOTAL LABOUR CHARGES-----------------------------
	
	public static double getLabourCharges(Service_requests sr) {
		String sql="select sum(labour_charges)as 'total_labour_charges' from services where service_request_id=?";
		double totalLabour_charges=0;
		try {
			PreparedStatement pmt= con.prepareStatement(sql);
			pmt.setInt(1, sr.getService_request_id());
			ResultSet rs=pmt.executeQuery(); 
			if(rs.next()) {
				totalLabour_charges=rs.getDouble("total_labour_charges");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalLabour_charges;
	}

	public static double getAllOilCost(Service_requests sr) {
		String sql="select sum(oil_cost)as 'total_oil_cost' from services where service_request_id=?";
		double totalOilCost=0;
		try {
			PreparedStatement pmt= con.prepareStatement(sql);
			pmt.setInt(1, sr.getService_request_id());
			ResultSet rs=pmt.executeQuery(); 
			if(rs.next()) {
				totalOilCost=rs.getDouble("total_oil_cost");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalOilCost;
	}

	public static double getTotalBillAmount(Service_requests sr) {
		String sql="select sum(total_cost)as 'total_bill_amount' from services where service_request_id=?";
		double totalBillAmount=0;
		try {
			PreparedStatement pmt= con.prepareStatement(sql);
			pmt.setInt(1, sr.getService_request_id());
			ResultSet rs=pmt.executeQuery(); 
			if(rs.next()) {
				totalBillAmount=rs.getDouble("total_bill_amount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalBillAmount;
	}

//	public void getRemarks(List<Service> serviceList,Service_requests sr) {
//		String sql="select * from service where service_request_id=?";
//		try {
//			PreparedStatement pmt=con.prepareStatement(sql);
//			pmt.setInt(1, sr.getService_request_id());
//			ResultSet rs=pmt.executeQuery();
//			while(rs.next()) {
//				String type=rs.getString("type");
//				if(type.equals(oil)) {
//					Oil o= new Oil(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("oil_cost"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
//					serviceList.add(o);
//				}else if(type.equals(maintainance)) {
//					Maintainance m =new Maintainance(rs.getInt("service_id"),rs.getString("type"),rs.getDouble("labour_charges"),rs.getDouble("total_cost"),rs.getString("remark"),rs.getInt("service_request_id"));
//					serviceList.add(m);
//				}else {
//					System.out.println("Worng Entry...!");
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
	
}
