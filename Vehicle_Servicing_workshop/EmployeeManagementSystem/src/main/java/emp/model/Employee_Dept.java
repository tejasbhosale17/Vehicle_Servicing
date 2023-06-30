package emp.model;

import java.sql.Date;

public class Employee_Dept {
	int empno;
	String empname;
	String job;
	int mgr;
	Date hireDate;
	double sal;
	String dname;
	
	
	
	public Employee_Dept() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee_Dept(int empno, String empname, String job, int mgr, Date hireDate, double sal, String dname) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.dname = dname;
	}



	public int getEmpno() {
		return empno;
	}



	public void setEmpno(int empno) {
		this.empno = empno;
	}



	public String getEmpname() {
		return empname;
	}



	public void setEmpname(String empname) {
		this.empname = empname;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public int getMgr() {
		return mgr;
	}



	public void setMgr(int mgr) {
		this.mgr = mgr;
	}



	public Date getHireDate() {
		return hireDate;
	}



	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}



	public double getSal() {
		return sal;
	}



	public void setSal(double sal) {
		this.sal = sal;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	@Override
	public String toString() {
		return "Employee_Dept [empno=" + empno + ", empname=" + empname + ", job=" + job + ", mgr=" + mgr
				+ ", hireDate=" + hireDate + ", sal=" + sal + ", dname=" + dname + "]";
	}
	
	
	
	
}
