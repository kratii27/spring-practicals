package com.rays.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestUserService {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
//		UserServiceByType userService = context.getBean(UserServiceByType.class);
//		UserServiceByName userService = context.getBean(UserServiceByName.class);
		UserServiceByConstructor userService = context.getBean(UserServiceByConstructor.class);
//		UserServiceBySetter userService = context.getBean(UserServiceBySetter.class);

		userService.testAdd();
	}

}
