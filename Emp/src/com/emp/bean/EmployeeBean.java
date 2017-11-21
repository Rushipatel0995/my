package com.emp.bean;

public class EmployeeBean {
	
	int empid;
	String ename;
	int salary;
	int dept;
	String designation;
	public EmployeeBean() {
		super();
	}
	public EmployeeBean(String ename, int salary, int dept, String designation) {
		super();
		this.ename = ename;
		this.salary = salary;
		this.dept = dept;
		this.designation = designation;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "EmployeeBean [empid=" + empid + ", ename=" + ename
				+ ", salary=" + salary + ", dept=" + dept + ", designation="
				+ designation + "]";
	}
	
	
	

}
