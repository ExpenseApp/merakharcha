package org.merakharcha.app.api;

import java.util.List;

import org.merakharcha.app.model.User;

public interface IUserInterface {
	
	public int register(User user);
	
	public boolean login(User user);
	
	public List<User> fetchAllUsers(); 
	
	public User fetchUserByUserId(int userId);
	
	public User fetchUserByName(String userName);
	
}
