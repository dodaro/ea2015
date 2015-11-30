package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.user.User;
import persistence.user.UserDAO;
import persistence.product.ConcreteProductDAO;
import persistence.product.Product;
import persistence.product.ProductDAO;
import persistence.store.ConcreteStoreDAO;
import persistence.store.Store;
import persistence.store.StoreDAO;
import persistence.user.ConcreteUserDAO;;

public class PersistenceTest {

	static UserDAO userDao;
	static List<User> users;
	
	static ProductDAO productDao;
	static List<Product> products;
	
	static StoreDAO storeDao;
	static Store store;

	@BeforeClass
	static public void init() {
		userDao = new ConcreteUserDAO();
		users = new ArrayList<User>();
		
		productDao = new ConcreteProductDAO();
		products = new ArrayList<Product>();
		
		storeDao = new ConcreteStoreDAO();
		store = new Store();
		
		initDB();
	}

	static public void initDB() {
		
		store.setId(0);
		storeDao.create(store);
		
		for (int i = 0; i < 100; i++) {
			
			User u = new User("username" + i, "password" + i, "city" + i);
			users.add(u);
			userDao.create(u);
			
			Product product = new Product();
			product.setName("product" + i);
			product.setPrice(i);
			product.setStore(store.getId());
			productDao.create(product);
			products.add(product);
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
	
	/*
	 * TEST STORE
	 */
	
	@Test
	public void testGetProducts(){
		
		assertEquals(products.size(), storeDao.getProducts(store.getId()).size());
	}

}
