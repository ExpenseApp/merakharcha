package org.merakharcha.app.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;

public class UserDaoImpl extends UserDao{

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO USER VALUES(:USERNAME, :PASSWORD, :EMAIL)";	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USERNAME", user.getUserName());
		map.put("PASSWORD", user.getPassword());
		map.put("EMAIL", user.getEmail());
		int userId = this.getSimpleJdbcTemplate().queryForObject(sql, Integer.class, map);
		return 0;
	}

	@Override
	public User getUserByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
