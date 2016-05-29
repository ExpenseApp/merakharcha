package org.merakharcha.app.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

public class UserDaoImpl extends UserDao{
  
	private DataSource dataSource;
	
	private SimpleJdbcTemplate template;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}
	

	public SimpleJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO USER VALUES(:USERNAME, :PASSWORD, :EMAIL)";	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USERNAME", user.getUserName());
		map.put("PASSWORD", user.getPassword());
		map.put("EMAIL", user.getEmail());
		int userId = this.template.queryForObject(sql, Integer.class, map);
		System.out.println("fetched userId "+userId);
		return 0;
	}

	@Override
	public User getUserByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
