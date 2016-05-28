package org.merakharcha.app.api.impl;

import org.merakharcha.app.api.IUserInterface;
import org.merakharcha.app.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserInterfaceImpl implements IUserInterface {

	public User register(User user) {
		return user;
	}

	public boolean login(User user) {
		if(user.getUserName().equals("vt") && user.getPassword().equals("vt")){
			return true;
		}else{
			return false;
		}		
	}

}
