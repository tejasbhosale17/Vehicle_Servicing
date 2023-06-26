package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Customer;

public class CustomerDao {

	private static Connection con;

	public CustomerDao() throws SQLException {
		this.con = DBUtil.getConnection();
	}
	
//-------------------------------------------------------------------------------	
	public static void getAllCustomers(List<Customer> customerList) {
		String q1="select * from customer";
		try {
			PreparedStatement pmt=con.prepareStatement(q1);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
				Customer c= new Customer(rs.getInt("customer_id"),rs.getString("customer_name"),rs.getLong("mobile"),rs.getString("email"),rs.getString("address"));
				customerList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//----------------------------------------------------------------------------------------------------------
	
	public static Customer getThatCustomer(Long mobile) {
		String q2="select * from customer where mobile=?";
		try {
			PreparedStatement pmt =con.prepareStatement(q2);
			pmt.setLong(1, mobile);
			ResultSet rs = pmt.executeQuery();
			if(rs.next()) {
				Customer c= new Customer(rs.getInt("customer_id"),rs.getString("customer_name"),mobile,rs.getString("email"),rs.getString("address"));
				return c;
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//-------------------------------------------------------------------------------
	
	public int removeThatCustomer(int id) {
		String q3="delete from customer where customer_id=?";
		int ncr=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q3);
			pmt.setInt(1, id);
			ncr=pmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ncr;
	}
	//-------------------------------------------------------------------------------

	public int updateThisCustomer(int id, long mobileno, String addr) {
		String q4="update customer set mobile=?, address=? where customer_id=?";
		int ncu=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q4);
			pmt.setInt(3, id);
			pmt.setLong(1, mobileno);
			pmt.setString(2, addr);
			ncu=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ncu;
	}	
	//-------------------------------------------------------------------------------
	
	public int addThisCustomer(int id, String name, long mobile, String email, String addr) {
		String q5="insert into customer values(?,?,?,?,?)";
		int nca=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setInt(1, id);
			pmt.setString(2, name);
			pmt.setLong(3, mobile);
			pmt.setString(4, email);
			pmt.setString(5, addr);
			nca=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nca;
	}
	
	
	public void close() throws SQLException {
		this.con.close();
	}

//-----------------------------------------------------------------------------------
	public static int getThisCustomerId(Long mobile) {
		String q2="select * from customer where mobile=?";
		int cid=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q2);
			pmt.setLong(1, mobile);
			ResultSet rs = pmt.executeQuery();
			if(rs.next()) {
				cid=rs.getInt("customer_id");
				Customer c= new Customer(cid,rs.getString("customer_name"),mobile,rs.getString("email"),rs.getString("address"));
				return cid;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cid;
	}


	



}
