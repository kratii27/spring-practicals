package com.rays.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	SessionFactory sf = null;

	public long add(UserDTO dto) {
		Session session = sf.getCurrentSession();
		Long pk = (Long) session.save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		sf.getCurrentSession().update(dto);
	}


	public void delete(long id) {
		Session session = sf.getCurrentSession();
		UserDTO dto = findByPk(id);
		session.delete(dto);
	}

	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO findByPk(long pk) {
		Session session = sf.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, pk);
		return dto;
	}

	public UserDTO findByLogin(String login) {
		Session session = sf.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, login);
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
