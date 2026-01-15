package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {
	
	public long add(UserDTO dto);
	
	public void delete(long id);
	
	public void update(UserDTO dto);
	
	public List search(UserDTO dto);
	
	public List search(UserDTO dto,int pageNo, int pageSize);
	
	public UserDTO findByPk(long pk);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO authenticate(String login, String password);

}
