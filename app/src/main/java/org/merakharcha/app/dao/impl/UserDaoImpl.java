package org.merakharcha.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.merakharcha.app.dao.AbstractDao;
import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class UserDaoImpl extends AbstractDao implements UserDao{
	
	private static final class UserRowMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt(FIELD_USER_ID));
			user.setUserName(rs.getString(FIELD_USERNAME));
			user.setPassword(rs.getString(FIELD_PASSWORD));
			user.setEmail(rs.getString(FIELD_EMAIL));			
			return user;
		}
		
	}

	public int addUser(User user) {
		SqlParameterSource paramSource = getNewUserSQLParameterSource(user);
		this.getNamedParameterJdbcTemplate().update(NEW_USER_ADD, paramSource);
		List<User> users = (List<User>)this.getNamedParameterJdbcTemplate().query(FETCH_LAST_USER, new MapSqlParameterSource(), new UserRowMapper());
		return users.get(0).getUserId();
	}
	
	private SqlParameterSource getNewUserSQLParameterSource(User user){
		SqlParameterSource sqlParamSource = new MapSqlParameterSource(FIELD_USERNAME, user.getUserName()).
				  addValue(FIELD_PASSWORD, user.getPassword()).
				  addValue(FIELD_EMAIL, user.getEmail());
		return sqlParamSource;
	}

	public User getUserByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
