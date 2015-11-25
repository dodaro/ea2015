package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.*;

public class PersistenceTest {

	static UserDAO userDAO;
	static ShopDAO shopDAO;
	static ProductDAO productDAO;

	static List<User> users;
	static List<Shop> shops;
	static List<Product> products;

	@BeforeClass
	static public void init() {
		userDAO = new UserDAO();
		users = new ArrayList<User>();
		shopDAO = new ShopDAO();
		shops = new ArrayList<Shop>();
		productDAO = new ProductDAO();
		products = new ArrayList<Product>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 50; i++) {
			User u = new User(i, "username" + i, "password" + i, i + "name", i + "surname", "email" + i + ".com");
			users.add(u);
			userDAO.create(u);
		}
		for (int j = 0; j < 10; j++) {
			Shop s = new Shop(j, "username" + j, "password" + j, "shop" + j, j + "email.com",
					"address" + j);
			shops.add(s);
			shopDAO.create(s);
		}
		boolean current = true;
		for (int k = 0; k < 100; k++) {
			if ((k % 3) == 1) {
				current = !current;
			}
			Product p = new Product(1000 + k, "product"+k, "category" + k, "description product" + k, k,
					"manufacturer" + (k % 20), current);
			products.add(p);
			productDAO.create(p);
			current = true;
		}
	}
	
	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(11), ((User)userDAO.getByUsername("username10")).getId());
	}

	@Test
	public void testGetShopByUsername() {
		assertEquals(new Integer(9), ((Shop)shopDAO.getByUsername("username8")).getId());
	}
	
	@Test
	public void testGetProductByName() {
		assertEquals(new Integer(1030), ((Product)productDAO.getByUsername("product30")).getCode());
	}
	
	
	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(userDAO.getByUsername("userName"));
	}
	
	@Test
	public void testGetShopById() {
		assertEquals("shop7", ((Shop)shopDAO.getById(8)).getName());
	}
	
	@Test
	public void testGetProductByCode() {
		assertEquals("product1",((Product) productDAO.getById(1001)).getName());
	}
	
	
	@Test
	public void testNumberOfUsers() {
		assertEquals(50, userDAO.numberOfTuple());
	}
	
	@Test
	public void testNumberOfAvailableProduct() {
		assertEquals(100, productDAO.getAvailableNumber());
	}
	
	@Test
	public void testNumberOfShopsAfterDeletion() {
		shopDAO.delete(shops.get(1));
		assertEquals(9, shopDAO.numberOfTuple());
	}
}
