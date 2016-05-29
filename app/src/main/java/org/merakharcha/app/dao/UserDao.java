package org.merakharcha.app.dao;

import java.util.List;

import org.merakharcha.app.model.User;

public abstract class UserDao {
	
	public abstract int addUser(User user);
	public abstract User getUserByUserId(int id);
	public abstract List<User> getAllUsers();
	public abstract boolean updateUser(User user);
	public abstract boolean deleteUser(User user);
	
}
