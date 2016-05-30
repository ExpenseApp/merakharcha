package app;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.merakharcha.app.dao.UserDao;
import org.merakharcha.app.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoTest{
	
	private static ApplicationContext context = null;
	private static UserDao userDao = null;
	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("app-context.xml");
		userDao = context.getBean("userDao", UserDao.class);
	}
	
	@Test
	public void fetchAllUsers(){
		Assert.assertNotNull(userDao);		
	}
	
	@Test
	public void fetchUserById(){
		Assert.assertNotNull(userDao.getUserByUserId(1));
	}
	
	private User fetchPreFilledUserObject(){
		User testUser = new User();
		testUser.setUserName("TestUser-Name");
		testUser.setPassword("TestUser-password");
		testUser.setEmail("TestUser@email.com");
		return testUser;
	}
	
	@Test
	public void addUser(){
		User testUser = fetchPreFilledUserObject();
		Assert.assertNotNull(userDao.addUser(testUser));
	}
	
	@Test
	public void updateUserPassword(){
		User testUser = fetchPreFilledUserObject();
		testUser.setPassword("TestUser-Updated-password");
		Assert.assertEquals(true, userDao.updateUser(testUser));
	}
	
	@Test
	public void deleteUser(){
		User testUser = fetchPreFilledUserObject();
		Assert.assertEquals(true, userDao.deleteUser(testUser));
	}

}
