package com.cathaybk.practice.nt00550339.b;

import java.util.function.IntBinaryOperator;

//繼承
public class Sales extends Employee {
	private int bouns;
	private int payment;

	public Sales(String name, String department, int salary, int bouns) {
		super(name, department, salary);
		this.bouns=bouns;
		this.payment=payment;
		}
	
		public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

		public void printInfo() {

			 
			int total = bouns/20 + getSalary();    //寫在方法裡 以整數計算 不會出現小數位

			System.out.println("薪資單");

			System.out.println("姓名:" + getName() + " " + "工作部門:" + getDepartment());

			System.out.println("月薪:" + getSalary());

			System.out.println("業績獎金:" + bouns *0.05);

			System.out.println("總計:" + total);

		}


		
	}
	
