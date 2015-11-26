package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistenceDTO.Product;
import persistenceDTO.Store;
import persistenceDTO.User;
import persistenceDAO.ProductDAO;
import persistenceDAO.ProductDAOImpl;
import persistenceDAO.StoreDAO;
import persistenceDAO.StoreDAOImpl;
import persistenceDAO.UserDAO;
import persistenceDAO.UserDAOImpl;

public class PersistenceTest {

	static UserDAO userDao;
	static ProductDAO productsDao;
	static StoreDAO storesDao;
	static List<User> users;
	static List<Product> products;
	static List<Store> stores;

	@BeforeClass
	static public void init() {
		userDao = new UserDAOImpl();
		users = new ArrayList<User>();
		
		productsDao = new ProductDAOImpl();
		products = new ArrayList<Product>();
		
		storesDao = new StoreDAOImpl();
		stores = new ArrayList<Store>();
		
		initDB();
	}

	static public void initDB() {
		
		//se faccio partire i=0 l'id(chiave primaria) si autoincrementa di 1.
		//se i=1 invece rispetta il valore.
		for (int i = 1; i < 30; i++) {
			User u = new User(i, "username" + i, "password" + i,"name"+i,"surname"+i,"address"+i);
			users.add(u);
			userDao.create(u);
			
			Product p = new Product(i, "name" + i, (double)i+1,(double) i+2, i+3, "producer"+i,"category"+i);
			products.add(p);
			productsDao.create(p);
			
			Store s = new Store(i, "name" + i, "address" + i,"city"+i);
			stores.add(s);
			storesDao.create(s);
		}
	}

	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(20), userDao.get("username20").getId());
	}

	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(userDao.get("username101"));
	}

	@Test
	public void testGetUserById() {
		assertEquals("username5", userDao.get(5).getUsername());
		assertEquals("name6", productsDao.get(6).getName());
	}

	@Test
	public void testNumberOfUsers() {
		assertEquals(29, userDao.numberOfUsers());
	}

	@Test
	public void testNumberOfUsersAfterDeletion() {
		userDao.delete(users.get(0));
		assertEquals(28, userDao.numberOfUsers());
	}
	
	@Test
	public void testStoreMembership(){
		assertEquals(new Integer(4),productsDao.getStoreMembership(1));
	}
	
	@Test
	public void testStoreProduct(){
		assertEquals(new Integer(2),storesDao.getStoreProducts(5).get(0).getId());
	}
	
	@Test
	public void testProductForCategory(){
		assertEquals(new Integer(2), productsDao.getProductsForCategory("category2").get(0).getId());
	}
	
	@Test
	public void testStoreForCity(){
		assertEquals(new Integer(5), storesDao.getStoreForCity("city5").get(0).getId());
	}
}