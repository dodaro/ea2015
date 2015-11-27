package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Product;
import persistence.ProductDAO;
import persistence.Shop;
import persistence.ShopDAO;
import persistence.User;
import persistence.UserDAO;

public class PersistenceTest {

	static UserDAO userDao;
	static List<User> users;
	static ProductDAO productDao;
	static List<Product> products;
	static ShopDAO shopDao;
	static List<Shop> shops;

	@BeforeClass
	static public void init() throws Exception {
		userDao = new UserDAO();
		users = new ArrayList<User>();
		
		productDao = new ProductDAO();
		products = new ArrayList<Product>();
		
		shopDao = new ShopDAO();
		shops = new ArrayList<Shop>();
		
		initDB();
	}

	static public void initDB() throws Exception {
		for (int i = 0; i < 100; i++) {
			User u = new User(i, "username" + i, "password" + i);
			users.add(u);
			userDao.create(u);
			
			Product p = new Product(i, "name" + i, i);
			products.add(p);
			productDao.create(p);
			
			Shop s = new Shop(i, "name" + i, "Address" + i);
			shops.add(s);
			shopDao.create(s);
		}
	}

	/* User Test */
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
	public void testNumberOfUsersAfterDeletion() throws Exception {
		userDao.delete(users.get(0));
		assertEquals(99, userDao.numberOfUsers());
	}
	
	/* Product Test */
	@Test
	public void testGetProductByName() {
		assertEquals(new Integer(11), productDao.get("name10").getId());
	}

	@Test
	public void testGetProductByUnusedUsername() {
		assertNull(productDao.get("name101"));
	}

	@Test
	public void testGetProductById() {
		assertEquals("name9", productDao.get(10).getName());
	}

	@Test
	public void testNumberOfProducts() {
		assertEquals(100, productDao.numberOfProducts());
	}

	@Test
	public void testNumberOfProductsAfterDeletion() throws Exception {
		productDao.delete(products.get(0));
		assertEquals(99, productDao.numberOfProducts());
	}
	
	/* Shop Test */
	@Test
	public void testGetShopByName() {
		assertEquals(new Integer(11), shopDao.get("name10").getId());
	}

	@Test
	public void testGetShopByUnusedName() {
		assertNull(shopDao.get("name101"));
	}

	@Test
	public void testGetShopById() {
		assertEquals("name9", shopDao.get(10).getName());
	}

	@Test
	public void testNumberOfShops() {
		assertEquals(100, shopDao.numberOfShops());
	}

	@Test
	public void testNumberOfShopsAfterDeletion() throws Exception {
		shopDao.delete(shops.get(0));
		assertEquals(99, shopDao.numberOfShops());
	}
}