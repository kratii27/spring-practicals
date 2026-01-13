package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceByConstructor {
	
	private UserDaoInt userDao;
	
	
	@Autowired
	public UserServiceByConstructor(UserDaoInt userDao) {
		this.userDao = userDao;
	}

	
	public void testAdd() {
		userDao.add();
	}
	
}
