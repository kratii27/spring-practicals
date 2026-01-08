package com.rays.ioc;

public class Payment {
	
	private double balance;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	


	public double makePayment(double amt) {
		balance = balance - amt;
		return balance;
	}
	

}
