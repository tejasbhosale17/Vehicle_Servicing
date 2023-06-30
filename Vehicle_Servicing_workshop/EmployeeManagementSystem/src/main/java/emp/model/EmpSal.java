package emp.model;

public class EmpSal {
String dname;
double avgsal;
int totalemp;
public EmpSal(String dname, double avgsal, int totalemp) {
	super();
	this.dname = dname;
	this.avgsal = avgsal;
	this.totalemp = totalemp;
}
public EmpSal() {
	super();
	// TODO Auto-generated constructor stub
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public double getAvgsal() {
	return avgsal;
}
public void setAvgsal(double avgsal) {
	this.avgsal = avgsal;
}
public int getTotalemp() {
	return totalemp;
}
public void setTotalemp(int totalemp) {
	this.totalemp = totalemp;
}
@Override
public String toString() {
	return "EmpSal [dname=" + dname + ", avgsal=" + avgsal + ", totalemp=" + totalemp + "]";
}

}
