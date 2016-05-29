package org.merakharcha.app.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class UserDaoImpl extends UserDao{
  
	private DataSource dataSource;
	
	private NamedParameterJdbcTemplate template;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}
	

	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO USER(USERNAME, PASSWORD, EMAIL) VALUES(:USERNAME, :PASSWORD, :EMAIL)";	
		SqlParameterSource paramSource = new MapSqlParameterSource("USERNAME", user.getUserName()).
														  addValue("PASSWORD", user.getPassword()).
														  addValue("EMAIL", user.getEmail());
		this.template.update(sql, paramSource);
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
