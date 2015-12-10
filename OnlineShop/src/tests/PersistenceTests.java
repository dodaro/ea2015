package tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Product;
import persistence.ProductDAO;
import persistence.ProductDAOImpl;
import persistence.Purchase;
import persistence.PurchaseDAO;
import persistence.PurchaseDAOImpl;
import persistence.User;
import persistence.UserDAO;
import persistence.UserDAOImpl;

public class PersistenceTests {

	static UserDAO userDAO;
	static ProductDAO productDAO;
	static PurchaseDAO purchaseDAO;

	static List<User> users;
	static List<Product> products;
	static List<Purchase> purchases;

	@BeforeClass
	static public void init() {
		userDAO = new UserDAOImpl();
		productDAO = new ProductDAOImpl();
		purchaseDAO = new PurchaseDAOImpl();
		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		purchases = new ArrayList<Purchase>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 10; i++) {
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 1990 + i);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, 3 + i);
			Date d = (Date) c.getTime();
			User u = new User("username" + i, "password" + i, "name" + i, "surname" + i, d);
			userDAO.create(u);
			users.add(u);
		}

		for (int j = 0; j < 30; j++) {
			Product p = new Product(j, "product" + j, "description" + j, j + 1);
			productDAO.create(p);
			products.add(p);
		}

		for (int k = 0; k < 50; k++) {
			int us = k % 10;
			int prod = k % 30;
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 2015);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			if (k % 2 == 0)
				c.set(Calendar.DAY_OF_MONTH, 3);// 25 k=0,2,4,6,8,10....
			else if (k % 3 == 0)
				c.set(Calendar.DAY_OF_MONTH, 2);// 8 k=3,9,15,21,27,33,39,45
			else
				c.set(Calendar.DAY_OF_MONTH, 1);// 17 k=1,5,7,11,13,17,19...
			Date d = (Date) c.getTime();
			Purchase pr = new Purchase(k, users.get(us), products.get(prod), d);
			purchases.add(pr);
			purchaseDAO.create(pr);
		}
	}

	@Test
	public void testdeleteANDcreateUser() {
		User u = new User("usr2", "password", "firstName", "lastName", new Date(0));
		userDAO.create(u);
		assertEquals(new Integer(11), (Integer) userDAO.getUsers().size());
		userDAO.delete(u);
		assertEquals(new Integer(10), (Integer) userDAO.getUsers().size());
	}

	@Test
	public void testupdateUser() {
		User u = users.get(0);
		u.setFirstName("newf");
		userDAO.update(u);
		assertEquals("newf", userDAO.getUserByUsername(u.getUsername()).getFirstName());

	}

	@Test
	public void testcreateAndDeleteProduct() {
		Product p = new Product(55, "name", "description", 11);
		productDAO.create(p);
		assertEquals(new Integer(31), (Integer) productDAO.getProducts().size());
		productDAO.delete(p);
		assertEquals(new Integer(30), (Integer) productDAO.getProducts().size());
	}

	@Test
	public void testgetProducts() {

		assertEquals(new Integer(30), (Integer) productDAO.getProducts().size());
	}

	@Test
	public void testupdateProduct() {
		products.get(0).setName("newN");
		int code = products.get(0).getId();
		productDAO.update(products.get(0));
		assertEquals("newN", productDAO.getProductById(code).getName());
	}

	@Test
	public void testcreateAndDeletePurchase() {
		Purchase p = new Purchase(100, users.get(0), products.get(0), new Date(100));
		purchaseDAO.create(p);
		assertEquals(new Integer(51), (Integer) purchaseDAO.getPurchase().size());
		purchaseDAO.delete(p);
		assertEquals(new Integer(50), (Integer) purchaseDAO.getPurchase().size());
	}

	@Test
	public void testgetUsers() {

		assertEquals(new Integer(10), (Integer) userDAO.getUsers().size());
	}

	@Test
	public void testProductBoughtByUser() {
		User user = users.get(0);
		
		assertEquals(new Integer(5), (Integer) userDAO.getBoughtByUser(user.getUsername()).size());
	}

	@Test
	public void testPurchaseInADate() {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 3);
		Date d = c.getTime();
		assertEquals(new Integer(25), (Integer)purchaseDAO.getPurchasesByDate(d).size());
	}

	@Test
	public void testBestDayPurchase() {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 3);
		Date d = c.getTime();
		
		assertEquals(d.getDay(), ((Date) purchaseDAO.getBestDay()).getDay());
	}

}
