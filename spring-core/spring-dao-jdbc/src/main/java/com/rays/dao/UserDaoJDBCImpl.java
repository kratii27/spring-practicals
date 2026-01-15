package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDaoJDBCImpl implements UserDAOint {

	private JdbcTemplate jdbcTemplate;
	private DataSource datasource = null;

	@Autowired
	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public void add(UserDTO dto) {

		String sql = "insert into st_user values(?, ?, ?, ?, ?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
	}

	public void delete(long id) {
		
		String sql = "delete from st_user where id = ?";

		int pk = jdbcTemplate.update(sql, id);
		
	}

	public void update(UserDTO dto) {
		
		String sql = "update st_user set firstName = ?, lastName = ?, login = ?, password = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		System.out.println("record updated successfully: " + i);
		
	}
	
	public List search(UserDTO dto) {
		
		String sql = "select * from st_user";
		List list = jdbcTemplate.query(sql, new UserMapper());
		return list;
	
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		
		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");
		
		if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
			sql.append(" and firstName like '" + dto.getFirstName() + "%'");
		}
		if (dto.getLastName() != null && dto.getLastName().length() > 0) {
			sql.append(" and lastName like '" + dto.getLastName() + "%'");
		}
		if (dto.getLogin() != null && dto.getLogin().length() > 0) {
			sql.append(" and login like '" + dto.getLogin() + "%'");
		}
		
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		
		List<UserDTO> list = jdbcTemplate.query(sql.toString() , new UserMapper());
		
		return list;
	}

	public UserDTO findByPk(long pk) {
		
		try {
			String sql = "select * from st_user where id = ?";

			Object[] params = { pk };
			
			UserDTO dto = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			
			return dto;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public UserDTO findByLogin(String login) {
		
		try {
			String sql = "select * from st_user where login = ?";

			Object[] params = { login };
			
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}



	public UserDTO authenticate(String login, String password) {
		
		try {
			
			String sql = "select id, firstName, lastName, login, password from st_user where login = ? and password = ?";

			Object[] params = { login, password };
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}



}
