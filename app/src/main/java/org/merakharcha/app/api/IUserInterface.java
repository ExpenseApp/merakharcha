package org.merakharcha.app.api;

import org.merakharcha.app.model.User;

public interface IUserInterface {
	
	public User register(User user);
	
	public boolean login(User user);
	
}
