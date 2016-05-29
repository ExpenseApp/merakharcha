package org.merakharcha.app.dao;

import java.util.List;

import org.merakharcha.app.model.User;

public interface UserDao {
	
	public int addUser(User user);
	public User getUserByUserId(int id);
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	
}
