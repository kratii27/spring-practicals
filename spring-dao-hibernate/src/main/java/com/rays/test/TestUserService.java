package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		test.testAdd();
//		test.testDelete();
//		test.testUpdate();
//		test.testSearch();
//		test.testFindByPk();
//		test.testFindByLogin();
//		test.testAutheticate();

	}



	private void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("arya");
		dto.setLastName("Trivedi");
		dto.setLogin("ariii@gmail.com");
		dto.setPassword("pass@1234");
		service.add(dto);
		System.out.println("data inserted successfully");
	}

	private void testUpdate() {

		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("priti");
		dto.setLastName("Trivedi");
		dto.setLogin("pri@gmail.com");
		dto.setPassword("pass@1234");
		service.update(dto);

		System.out.println("data updated successfully");
	}
	
	private void testFindByPk() {

		UserDTO dto = service.findByPk(1L);

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Id doesn't exists");
		}

	}
	
	private void testDelete() {
		service.delete(3);
		System.out.println("data deleted successfully");
	}
}