package com.cathaybk.practice.nt00550339.b;

public class Supervisor extends Employee{
	private int payment;
	
	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		this.payment=payment;
		
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public void printInfo() {

        System.out.println("薪資單");

        System.out.println("姓名:"+ getName() +" "+"工作部門:"+ getDepartment());

		System.out.println("月薪:"+ getSalary());

		System.out.println("總計:"+ getSalary());
	
	}
}