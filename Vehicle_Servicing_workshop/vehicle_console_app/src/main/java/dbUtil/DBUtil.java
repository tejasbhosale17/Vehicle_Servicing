package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sunbeam_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "tejas170299";

static {
	try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public static Connection getConnection() throws SQLException {
	
	return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	
}
}
