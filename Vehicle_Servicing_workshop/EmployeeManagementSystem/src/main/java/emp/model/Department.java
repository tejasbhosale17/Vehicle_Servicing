package emp.model;

public class Department {
int deptno;
String dname;
String location;


public Department() {
	super();
	// TODO Auto-generated constructor stub
}


public Department(int deptno, String dname, String location) {
	super();
	this.deptno = deptno;
	this.dname = dname;
	this.location = location;
}


public int getDeptno() {
	return deptno;
}


public void setDeptno(int deptno) {
	this.deptno = deptno;
}


public String getDname() {
	return dname;
}


public void setDname(String dname) {
	this.dname = dname;
}


public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}


@Override
public String toString() {
	return "Department [deptno=" + deptno + ", dname=" + dname + ", location=" + location + "]";
}




}
