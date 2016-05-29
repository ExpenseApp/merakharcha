package org.merakharcha.app.dao.impl;

import java.util.List;

import org.merakharcha.app.dao.AbstractDao;
import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class UserDaoImpl extends AbstractDao implements UserDao{

	public int addUser(User user) {
		String sql = "INSERT INTO USER(USERNAME, PASSWORD, EMAIL) VALUES(:USERNAME, :PASSWORD, :EMAIL)";	
		SqlParameterSource paramSource = getNewUserSQLParameterSource(user);
		this.getNamedParameterJdbcTemplate().update(sql, paramSource);
		return 0;
	}
	
	private SqlParameterSource getNewUserSQLParameterSource(User user){
		SqlParameterSource sqlParamSource = new MapSqlParameterSource("USERNAME", user.getUserName()).
				  addValue("PASSWORD", user.getPassword()).
				  addValue("EMAIL", user.getEmail());
		return sqlParamSource;
	}

	public User getUserByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
