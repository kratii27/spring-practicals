package com.rays.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;
	private String address;

	public String getName() {
		return name;
	}

	@Value("Krati")
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	@Value("Indore")
	public void setAddress(String address) {
		this.address = address;
	}

}
