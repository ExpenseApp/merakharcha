package org.merakharcha.app.api.impl;


import org.merakharcha.app.api.IUserInterface;
import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInterfaceImpl implements IUserInterface {
	
	@Autowired
	private UserDao userDao;	

	public int register(User user) {
		return userDao.addUser(user);
	}

	public boolean login(User user) {
		if(user.getUserName().equals("vt") && user.getPassword().equals("vt")){
			return true;
		}else{
			return false;
		}		
	}

}
