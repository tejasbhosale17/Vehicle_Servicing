package emp.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import emp.dao.EmployeeDao;
import emp.model.EmpSal;
import emp.model.Employee;
import emp.model.Employee_Dept;

public class EmployeeService {

	static Scanner scan = new Scanner(System.in);

	
	
	public static void addEmployees() {
		System.out.println("Enterempno, Empname,job,mgr,hiredate,sal,deptno");
		int empno=scan.nextInt();
		String empname=scan.next();
		String job=scan.next();
		int mgr=scan.nextInt();
		String dt=scan.next();
		Date hireDate = null;
		hireDate=Date.valueOf(dt);
		double sal=scan.nextDouble();
		int deptno=scan.nextInt();
		Employee e= new Employee(empno,empname,job,mgr,hireDate,sal,deptno);
		int isAdded=EmployeeDao.AddThisEmployee(e);
		if(isAdded>0) {
			System.out.println("Employee Added...");
		}else {
			System.out.println("Failed to Add Employee...");
		}
	}
	
	public static void updateAllEmployes() {
		System.out.println("Enter Department name:");
		String DeptName=scan.next();
		int neu=EmployeeDao.updateAllEmployee(DeptName);
		if(neu>0) {
			System.out.println(neu+" Employees Updated!!");
		}else {
			System.out.println("Employees Not Updated..");
		}
	}
	
	
	public static void getAllEmployeesOnDate() {
		System.out.println("Enter date:");
		String dt=scan.next();
		Date hireDate = null;
		hireDate=Date.valueOf(dt);
		List<Employee_Dept> edList= new ArrayList<>();
		EmployeeDao.getAllEmployeeOnDate(hireDate,edList);
		for(Employee_Dept ed:edList) {
			System.out.println(ed);
		}
	}
	
	public static void DeptWithAVGSal() {
		List<EmpSal> esList= new ArrayList<>();
		EmployeeDao.getDeptWithAvgSal(esList);
		for(EmpSal es:esList) {
			System.out.println(es);
		}
	}
	
	
}
