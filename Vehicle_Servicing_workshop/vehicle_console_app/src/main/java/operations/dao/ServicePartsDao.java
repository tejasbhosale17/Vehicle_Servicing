package operations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import operations.models.Service_Parts;

public class ServicePartsDao {
	private static Connection con;

	public ServicePartsDao() throws SQLException {
		this.con = DBUtil.getConnection();
	}

//	public List<Service_Parts> getAllServiceParts(List<Service_Parts> SPList) {
//		String q1="select * from service_parts";
//		try {
//			PreparedStatement pmt = con.prepareStatement(q1);
//			ResultSet rs =pmt.executeQuery();
//			while(rs.next()) {
//				Service_Parts sp =new Service_Parts(rs.getInt("service_id"),rs.getInt("part_id"),rs.getInt("quantity"));
//				SPList.add(sp);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return SPList;
//	}
}
