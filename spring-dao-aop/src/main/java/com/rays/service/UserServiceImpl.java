package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;


	public long add(UserDTO dto) {
		
//		UserDTO existDto = findByLogin(dto.getLogin());
//		if (existDto != null) {
//			throw new RuntimeException("login id already exists");
//		}
		long pk = dao.add(dto);
		return pk;
	}

	
	public void update(UserDTO dto) {

		UserDTO existDto = findByLogin(dto.getLogin());
		if (existDto != null && existDto.getId() != dto.getId()) {
			throw new RuntimeException("duPLIcatE recorD");
		}
		dao.update(dto);
	}

	
	public void delete(long id) {
		dao.delete(id);
	}

	
	public List search() {
		return dao.search();
	}

	
	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	
	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);
	}

	
	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	
	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}

}
