package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.user.User;
import persistence.user.UserDAO;
import persistence.utils.DBHandler;
import persistence.product.ConcreteProductDAO;
import persistence.product.Product;
import persistence.product.ProductDAO;
import persistence.user.ConcreteUserDAO;;

public class PersistenceTestUser {

	static UserDAO userDao;
	static List<User> users;

	@BeforeClass
	static public void init() {
		userDao = new ConcreteUserDAO();
		users = new ArrayList<User>();
		
	
		initDB();
	}

	static public void initDB() {
		
		for (int i = 0; i < 100; i++) {
			
			User u = new User("username" + i, "password" + i, "city" + i);
			users.add(u);
			DBHandler.create(u);
		}
	}

	/*
	 * TEST USER
	 */
	
	@Test
	public void testFind() {
		assertEquals(users.get(9).getId(), userDao.find(10).getId());
	}
	
	@Test
	public void testGetUsers(){
		
		List<User> usersTest = userDao.getUsers();
		for (int i = 0; i < usersTest.size(); i++) {
			
			assertEquals(usersTest.get(i).getId(), users.get(i).getId());
			assertEquals(usersTest.get(i).getName(), users.get(i).getName());
			assertEquals(usersTest.get(i).getPassword(), users.get(i).getPassword());
			assertEquals(usersTest.get(i).getCity(), users.get(i).getCity());
		}
	}
	
	@Test
	public void testGetUsername(){
		
		//error here, but not on the testGetPassword();
		assertEquals("username0", userDao.getUsername(1));
	}
	
	@Test
	public void testGetPassword(){
		
		assertEquals("password0", userDao.getPassword(1));
	}
	
	@Test
	public void testGetUsersFromCity(){
		
		String city = "city2";
		List<User> usersTest = userDao.getUserFromCity(city);
		
		int cont = 0;
		for (int i = 0; i < users.size(); i++) {
			
			if(users.get(i).getCity().equals(city))
				cont++;		
		}
		
		assertEquals(usersTest.size(), cont);
	}

}
