package operations.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Payment;

public class PaymentDao {

	static Connection con;
	static {
		try {
			con=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllPayments(List<Payment> payList){
		String q1="select * from payments where tx_date=CURDATE()";
		try {
			PreparedStatement pmt=con.prepareStatement(q1);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
				Payment p =new Payment(rs.getInt("payment_id"),rs.getInt("service_request_id"),rs.getDate("tx_date"),rs.getDouble("paid_amount"));
				payList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addThisPayment(Payment p) {
		String q2="insert into payments (service_request_id,paid_amount) values(?,?)";
		try {
			PreparedStatement pmt =con.prepareStatement(q2);
			pmt.setInt(1,p.getService_request_id());
			pmt.setDouble(2, p.getPaid_amount());
			int npu=pmt.executeUpdate();
			if(npu>0) {
				System.out.println("Update Payment Succesfully..");
			}else {
				System.out.println("Update Payment Unsuccesfull...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public double TodaysBusiness() {
		String q3="select sum(paid_amount) as todays_business from payments where Date(tx_date)=CURDATE()";
		double todays_business=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q3);
			ResultSet rs =pmt.executeQuery();
			while(rs.next()) {
				todays_business=rs.getDouble("todays_business");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return todays_business;	
	}

	public double GivenDateBusiness(Date givenDate) {
		double givendate_business=0;
		String q4="select sum(paid_amount) as givenDate_business from payments where Date(tx_date)=?";
		try {
			PreparedStatement pmt =con.prepareStatement(q4);
			pmt.setDate(1, givenDate);
			ResultSet rs =pmt.executeQuery();
			while(rs.next()) {
				givendate_business=rs.getDouble("givenDate_business");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return givendate_business;
	}
	
	
}
