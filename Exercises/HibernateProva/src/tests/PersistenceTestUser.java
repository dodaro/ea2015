package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.User;
import persistence.UserDAO;
import persistence.UserDAOImpl;

public class PersistenceTestUser {

	static UserDAO userDao;
	static List<User> users;

	@BeforeClass
	static public void init() {
		userDao = new UserDAOImpl();
		users = new ArrayList<User>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 100; i++) {
			User u = new User(i, "username" + i, "password" + i);
			users.add(u);
			userDao.create(u);
		}
	}

	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(11), userDao.get("username10").getId());
	}

	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(userDao.get("username101"));
	}

	@Test
	public void testGetUserById() {
		assertEquals("username9", userDao.get(10).getUsername());
	}

	@Test
	public void testNumberOfUsers() {
		assertEquals(100, userDao.numberOfUsers());
	}

	@Test
	public void testNumberOfUsersAfterDeletion() {
		userDao.delete(users.get(0));
		assertEquals(99, userDao.numberOfUsers());
	}
}
