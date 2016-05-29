package org.merakharcha.app.dao;

import java.util.List;

import org.merakharcha.app.model.User;

public interface UserDao {
	public static final String TABLE_NAME = "USER";
	public static final String FIELD_USERNAME = "USERNAME";
	public static final String FIELD_PASSWORD = "PASSWORD";
	public static final String FIELD_EMAIL = "EMAIL";
	public static final String FIELD_USER_ID = "USER_ID";
	public static final String NEW_USER_ADD = "INSERT INTO "+TABLE_NAME+"("+FIELD_USERNAME+","+FIELD_PASSWORD+","+FIELD_EMAIL+") VALUES(:"+FIELD_USERNAME+", :"+FIELD_PASSWORD+", :"+FIELD_EMAIL+")";
	public static final String FETCH_LAST_USER = "SELECT * FROM "+TABLE_NAME+" ORDER BY "+FIELD_USER_ID+" DESC LIMIT 1";
	
	
	public int addUser(User user);
	public User getUserByUserId(int id);
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	
}
