package com.rays.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOint;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	
	@Autowired
	private UserDAOint dao;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(UserDTO dto) {
		dao.add(dto);
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		
		dao.delete(id);
		
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
		
	}


	
	public List search(UserDTO dto, int pageNo, int pageSize) {
		List list = dao.search(dto, pageNo, pageSize);
		return list;
	}




	public List search(UserDTO dto) {
		List list = dao.search(dto);
		return list;
	}


	public UserDTO findByPk(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}


	public UserDTO findByLogin(String login) {
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}


	public UserDTO authenticate(String login, String password) {
		UserDTO dto = dao.authenticate(login, password);
		return dto;
	}

}
