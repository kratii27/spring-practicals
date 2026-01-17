package com.rays.ioc;

public class Inventory {
	
	private int stock;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	

	public Inventory(int stock) {
		this.stock = stock;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public int sold(int qty) {
		
		stock = stock - qty;
		
		return stock;
	}

}
