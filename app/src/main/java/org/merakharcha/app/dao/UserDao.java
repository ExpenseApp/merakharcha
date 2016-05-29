package org.merakharcha.app.dao;

import java.util.List;

import org.merakharcha.app.model.User;

public interface UserDao {
	
	public static final String FIELD_USERNAME = "USERNAME";
	public static final String FIELD_PASSWORD = "PASSWORD";
	public static final String FIELD_EMAIL = "EMAIL";
	public static final String NEW_USER_ADD = "INSERT INTO USER("+FIELD_USERNAME+","+FIELD_PASSWORD+","+FIELD_EMAIL+") VALUES(:"+FIELD_USERNAME+", :"+FIELD_PASSWORD+", :"+FIELD_EMAIL+")";
	
	
	public int addUser(User user);
	public User getUserByUserId(int id);
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	
}
