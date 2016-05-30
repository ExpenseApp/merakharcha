package org.merakharcha.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.merakharcha.app.dao.AbstractDao;
import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class UserDaoImpl extends AbstractDao implements UserDao{

	//Inner class (Implementation of RowMapper to Map User Model object with USER table in DB
	private static final class UserRowMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt(FIELD_USER_ID));
			user.setUserName(rs.getString(FIELD_USERNAME));
			user.setPassword(rs.getString(FIELD_PASSWORD));
			user.setEmail(rs.getString(FIELD_EMAIL));			
			return user;
		}
		
	}
	
	/***
	 * Adds the new User and returns the USER_ID of the user persisted in DB
	 */
	public int addUser(User user) {
		SqlParameterSource paramSource = getNewUserSQLParameterSource(user);
		this.getNamedParameterJdbcTemplate().update(NEW_USER_ADD, paramSource);
		List<User> users = (List<User>)this.getNamedParameterJdbcTemplate().query(FETCH_LAST_USER, new MapSqlParameterSource(), new UserRowMapper());
		return users.get(0).getUserId();
	}
	
	private SqlParameterSource getNewUserSQLParameterSource(User user){
		SqlParameterSource sqlParamSource = new MapSqlParameterSource(FIELD_USERNAME, user.getUserName()).
				  addValue(FIELD_PASSWORD, user.getPassword()).
				  addValue(FIELD_EMAIL, user.getEmail());
		return sqlParamSource;
	}

	/***
	 * Fetches the persisted User by USER_ID
	 */
	public User getUserByUserId(int id) {
		SqlParameterSource paramSource = new MapSqlParameterSource(FIELD_USER_ID,id);		
		List<User> user = (List<User>) this.getNamedParameterJdbcTemplate().query(FETCH_USER_BY_USER_ID, paramSource, new UserRowMapper());
		return user.get(0);		
	}
	
	/***
	 * Fetches the persisted User by USERNAME
	 */
	public User getUserByUserName(String userName) {
		SqlParameterSource paramSource = new MapSqlParameterSource(FIELD_USERNAME,userName);		
		User user = (User) this.getNamedParameterJdbcTemplate().query(FETCH_USER_BY_USERNAME, paramSource, new UserRowMapper());
		return user;
	}

	/***
	 * Fetches all persisted Users
	 */
	public List<User> getAllUsers() {
		List<User> users = (List<User>)this.getNamedParameterJdbcTemplate().query(FETCH_ALL_USERS, new MapSqlParameterSource(), new UserRowMapper());
		return users;
	}
	
	/**
	 * Update a user password specified by a USERNAME
	 */
	public boolean updateUser(User user) {
		boolean result = false;
		SqlParameterSource paramSource = getUpdateUserSQLParameterSource(user);
		this.getNamedParameterJdbcTemplate().update(USER_UPDATE_PASSWORD, paramSource);
		result = true;// If no runtime exception reach this point that means, the user is successfully updated
		return result;
	}
	
	private SqlParameterSource getUpdateUserSQLParameterSource(User user){
		SqlParameterSource sqlParamSource = new MapSqlParameterSource(FIELD_PASSWORD, user.getPassword())
																    .addValue(FIELD_USERNAME, user.getUserName());
		return sqlParamSource;
	}
	
	/**
	 * Delete a user specified by a USERNAME
	 */
	public boolean deleteUser(User user) {
		boolean result = false;
		SqlParameterSource paramSource = new MapSqlParameterSource(FIELD_USERNAME, user.getUserName());
		this.getNamedParameterJdbcTemplate().update(USER_DELETE, paramSource);
		result = true;// If no runtime exception reach this point that means, the user is successfully deleted
		return result;
	}

}
