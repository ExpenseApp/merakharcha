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
	public static final String USER_UPDATE_PASSWORD = "UPDATE "+TABLE_NAME+" SET "+FIELD_PASSWORD+"= :"+FIELD_PASSWORD+" WHERE "+FIELD_USERNAME+"= :"+FIELD_USERNAME;
	public static final String USER_DELETE = "DELETE FROM "+TABLE_NAME+" WHERE "+FIELD_USERNAME+"= :"+FIELD_USERNAME;
	public static final String FETCH_LAST_USER = "SELECT * FROM "+TABLE_NAME+" ORDER BY "+FIELD_USER_ID+" DESC LIMIT 1";
	public static final String FETCH_ALL_USERS = "SELECT * FROM "+TABLE_NAME;
	public static final String FETCH_USER_BY_USER_ID = "SELECT * FROM "+TABLE_NAME+" where "+FIELD_USER_ID+" = :"+FIELD_USER_ID;
	public static final String FETCH_USER_BY_USERNAME = "SELECT * FROM "+TABLE_NAME+" where "+FIELD_USERNAME+" = :"+FIELD_USERNAME;
	
	public int addUser(User user);
	public User getUserByUserId(int id);
	public User getUserByUserName(String userName);
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	
}
