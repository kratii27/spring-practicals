package com.rays.collection;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");
		MyBean myBean = context.getBean("myBean", MyBean.class);
		myBean.displayData();
		
	}

}
