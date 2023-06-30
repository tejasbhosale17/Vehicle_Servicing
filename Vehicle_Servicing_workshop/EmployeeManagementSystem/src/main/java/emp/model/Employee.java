package emp.model;

import java.sql.Date;

public class Employee {
	int empno;
	String empname;
	String job;
	int mgr;
	Date hireDate;
	double sal;
	int deptno;
	
	


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int empno, String empname, String job, int mgr, Date hireDate, double sal, int deptno) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.deptno = deptno;
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



	public int getDeptno() {
		return deptno;
	}



	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}



	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sal=" + sal + ", deptno=" + deptno + "]";
	}
	
	
}
