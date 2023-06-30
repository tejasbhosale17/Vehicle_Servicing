package emp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DBUtil;
import emp.model.EmpSal;
import emp.model.Employee;
import emp.model.Employee_Dept;

public class EmployeeDao {
static Connection con;
	static {
		try {
			con=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int AddThisEmployee(Employee e) {
		String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(?,?,?,?,?,?,?)";
		int nea=0;
		try {
			PreparedStatement pmt=con.prepareStatement(sql);
			pmt.setInt(1, e.getEmpno());
			pmt.setString(2, e.getEmpname());
			pmt.setString(3, e.getJob());
			pmt.setInt(4, e.getMgr());
			pmt.setDate(5, e.getHireDate());
			pmt.setDouble(6, e.getSal());
			pmt.setInt(7, e.getDeptno());
			nea = pmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return nea;
	}
	public static int updateAllEmployee(String deptName) {
		String sql=" update emp set sal=(sal+(sal*0.1)) where deptno=(select deptno from dept where dname=?)";
		int neu=0;
		try {
			PreparedStatement pmt= con.prepareStatement(sql);
			pmt.setString(1, deptName);
			neu=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return neu;
		
	}
	public static void getAllEmployeeOnDate(Date hireDate, List<Employee_Dept> edList) {
		String sql="select empno,ename,job,mgr,hiredate,sal,dname from emp e inner join dept d on e.deptno=d.deptno where hiredate=?";
		try {
			PreparedStatement pmt=con.prepareStatement(sql);
			pmt.setDate(1, hireDate);
			ResultSet rs =pmt.executeQuery();
			while(rs.next()) {
				Employee_Dept ed=new Employee_Dept(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"), rs.getDate("hiredate"),rs.getDouble("sal"), rs.getString("dname"));
				edList.add(ed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void getDeptWithAvgSal( List<EmpSal> esList) {
		String sql="select dname,avg(sal) as avgsal,count(empno) as totalemp from dept d inner join emp e on d.deptno=e.deptno group by d.deptno";
		try {
			PreparedStatement pmt=con.prepareStatement(sql);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
				EmpSal es= new EmpSal(rs.getString("dname"),rs.getDouble("avgsal"),rs.getInt("totalemp"));
				esList.add(es);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
