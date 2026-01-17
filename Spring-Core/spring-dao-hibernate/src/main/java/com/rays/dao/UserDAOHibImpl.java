package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	public List search() {
		Session session = sf.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		List list = criteria.list();
		
		return list;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		Session session = sf.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		
		if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
			criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
		}
		if (dto.getLastName() != null && dto.getLastName().length() > 0) {
			criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
		}
		if (dto.getLogin() != null && dto.getLogin().length() > 0) {
			criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
		}
		
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		
		List list = criteria.list();
		return list;
	}

	public UserDTO findByPk(long pk) {
		Session session = sf.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, pk);
		return dto;
	}

	public UserDTO findByLogin(String login) {
		Session session = sf.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("login", login));
		List list = criteria.list();
		UserDTO dto = null;
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		
		Session session = sf.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		UserDTO dto = null;
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		
		List list = criteria.list();
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

}
