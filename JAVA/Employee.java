package com.cathaybk.practice.nt00550339.b;

import javax.print.attribute.standard.PrinterInfo;

//屬性
public class Employee {
	private String name;
	private String department;
	private int salary;

//建構子
	public Employee(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	
	public void printInfo() {
		System.out.println("姓名:" + name + "工作部門" + department + "月薪" + salary);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	 
		
	}
	
