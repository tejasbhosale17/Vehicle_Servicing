package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Part;

public class PartDao {
	private static Connection con;

	public PartDao() throws SQLException {
		this.con = DBUtil.getConnection();
	}
//-----------------------------------------------------------------------------------
	
	public void getAppParts(List<Part> partList) {
		String q1="select * from parts";
		try {
			PreparedStatement pmt = con.prepareStatement(q1);
			ResultSet rs = pmt.executeQuery();
			while(rs.next()) {
				Part p = new Part(rs.getInt("part_id"),rs.getString("part_name"),rs.getString("description"),rs.getDouble("price"));
				partList.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
//-----------------------------------------------------------------------------------

	public Part findThisPart(int id) {
		String q2="select * from parts where part_id=?";
		try {
			PreparedStatement pmt= con.prepareStatement(q2);
			pmt.setInt(1, id);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				Part p =new Part(id,rs.getString("part_name"),rs.getString("description"),rs.getDouble("price"));
				return p;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//-----------------------------------------------------------------------------------

	public int removeThisPart(int id) {
		String q3="delete from parts where part_id=?";
		int npr=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q3);
			pmt.setInt(1, id);
			npr=pmt.executeUpdate();
//			if(npr>0) {
//				return npr;
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return npr;
	}



	//-----------------------------------------------------------------------------------
	public int updateThisPart(int id, double price) {
		String q4="update parts set price=? where part_id=?";
		int npu=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q4);
			pmt.setInt(2, id);
			pmt.setDouble(1, price);
			npu=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return npu;
	}
	//-----------------------------------------------------------------------------------

	public int addThisPart(int id, String name, String descrip, double price) {
		String q5="insert into parts values(?,?,?,?)";
		int npa= 0;
		try {
			PreparedStatement pmt = con.prepareStatement(q5);
			pmt.setInt(1, id);
			pmt.setString(2, name);
			pmt.setString(3, descrip);
			pmt.setDouble(4, price);
			npa=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return npa;
	}

	
	
	

}
