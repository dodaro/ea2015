package it.unical.carseller.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import it.unical.carseller.model.User;
import it.unical.carseller.model.dao.UserDao;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:**/WEB-INF/spring/root-context.xml"})
public class UserTest{

	@Autowired
	private ApplicationContext context;	
	
	@Before
	public void init() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		for (int i = 0; i < 10; i++) {
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 1982);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, 25);
			Date d = c.getTime();
			User u = new User("username" + i, "password" + i, "email"+i+"@gmail.com", 18, d);
			userDao.create(u);
		}		
	}
	
	@After
	public void delete() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setUsername("username"+i);
			userDao.delete(u);
		}
	}
	
	@Test
	public void testNumberOfUsers() {
		UserDao userDao = (UserDao) context.getBean("userDao");			
		assertEquals(new Long(10), userDao.numberOfUsers());
	}
	
	@Test
	public void testGetUserByUsername() {
		UserDao userDao = (UserDao) context.getBean("userDao");			
		assertEquals("password1", userDao.retrieve("username1").getPassword());
	}

	@Test
	public void testGetUserByUnusedUsername() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		assertNull(userDao.retrieve("username101"));		
	}
}
