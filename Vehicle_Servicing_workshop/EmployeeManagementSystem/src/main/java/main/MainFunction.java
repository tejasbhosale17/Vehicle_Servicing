package main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import emp.service.EmployeeService;




public class MainFunction {
	
	enum EMainMenu{
		EXIT,ADDEMPLOYEE,UPDATEEMPLOYEE,LISTEMPLOYEE, LISTDEPT,DEFAULT
	}
	public static EMainMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Add Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.List Employee");
		System.out.println("4.List dept");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EMainMenu.values()[5] :EMainMenu.values()[choice]);
//		return EMainMenu.values()[choice];
	}
public static void main(String[] args) {
	System.out.println("Choose The Department");
	MainFunction m =new MainFunction();
	EMainMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=EMainMenu.EXIT) {
		switch (choice) {
		case ADDEMPLOYEE:
				EmployeeService.addEmployees();
				System.out.println("");
			break;

		case UPDATEEMPLOYEE:
			EmployeeService.updateAllEmployes();
				System.out.println("");
			break;

		case LISTEMPLOYEE:
			EmployeeService.getAllEmployeesOnDate();
				System.out.println("");
			break;
			
		case LISTDEPT:
			System.out.println("");
		break;
//			

		
		case DEFAULT:
			EmployeeService.DeptWithAVGSal();
			System.out.println("Wrong choice entered..:(");
			break;
}
	}
}
}
