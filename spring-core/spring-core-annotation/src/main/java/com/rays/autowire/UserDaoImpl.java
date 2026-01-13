package com.rays.autowire;

import org.springframework.stereotype.Repository;

@Repository("userDao") // @Repository annotation is use for create DAO(CRUD) layer and also create bean
public class UserDaoImpl implements UserDaoInt {

	public void add() {
		
		System.out.println("in add method!!");
		
	}

}
