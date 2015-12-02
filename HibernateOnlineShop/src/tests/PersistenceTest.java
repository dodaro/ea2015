package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import DAOImplementations.ProductDAOImpl;
import DAOImplementations.PurchaseDAOImpl;
import DAOImplementations.UserDAOImpl;
import DAOIntefaces.ProductDAO;
import DAOIntefaces.PurchaseDAO;
import DAOIntefaces.UserDAO;
import persistence.Product;
import persistence.Purchase;
import persistence.User;

public class PersistenceTest
{
	static UserDAO userDAO;
	static ProductDAO productDAO;
	static PurchaseDAO purchaseDAO;
	static List<User> users;
	static List<Product> products;
	static List<Purchase> purchases;

	static List<Purchase> purchasedByUser99;

	@BeforeClass
	static public void init()
	{
		userDAO = new UserDAOImpl();
		productDAO = new ProductDAOImpl();
		purchaseDAO = new PurchaseDAOImpl();
		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		purchases = new ArrayList<Purchase>();

		purchasedByUser99 = new ArrayList<Purchase>();

		initDB();
	}

	static public void initDB()
	{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 25);
		Date date = c.getTime();
		for (int i = 1; i <= 100; i++)
		{
			User u = new User(i, "username" + i, "p" + i, "fn" + i, "ln" + i, date);
			users.add(u);
			userDAO.create(u);
			Product p = new Product(i, "n" + i, "d" + i, .0f + i);
			products.add(p);
			productDAO.create(p);
		}
		Purchase up = new Purchase(1, userDAO.get(5), products.get(1), date);
		purchases.add(up);
		purchaseDAO.create(up);
		up = new Purchase(2, userDAO.get(5), products.get(2), date);
		purchases.add(up);
		purchaseDAO.create(up);

		for (int i = 10; i <= 10; i++)
		{
			Purchase p = new Purchase(1, userDAO.get(99), products.get(i), date);
			purchasedByUser99.add(p);
			purchases.add(p);
			purchaseDAO.create(p);
		}
	}

	@Test
	public void testInsertUser()
	{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 1950);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date date = c.getTime();
		User grayfox = new User(101, "greyfox", "naomi", "frank", "jaegar", date);
		userDAO.create(grayfox);
		users.add(grayfox);
		assertEquals("greyfox", userDAO.get(101).getUsername());
	}

	@Test
	public void testUpdateUser()
	{
		User u = users.get(0);
		u.setPassword("snakeeater");
		userDAO.update(u);
		assertEquals("snakeeater", userDAO.get(1).getPassword());
	}

	@Test
	public void testDeleteUser()
	{
		User u = users.get(0);
		userDAO.delete(u);
		users.remove(0);
		assertNull(userDAO.get("username1"));
	}

	@Test
	public void testInsertProduct()
	{
		Product iPhone6S = new Product(101, "iphone6S", "Ultimo modello di iPhone", 789.00f);
		productDAO.create(iPhone6S);
		products.add(iPhone6S);
		assertEquals(new Float(789.00f), productDAO.get(101).getPrice());
	}

	@Test
	public void testUpdateProduct()
	{
		Product p = products.get(0);
		p.setPrice(99.99f);
		productDAO.update(p);
		assertEquals(new Float(99.99f), productDAO.get(1).getPrice());
	}

	@Test
	public void testDeleteProduct()
	{
		Product p = products.get(0);
		productDAO.delete(p);
		products.remove(0);
		assertNull(productDAO.get(1));
	}

	@Test
	public void testInsertPurchase()
	{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 25);
		Date date = c.getTime();
		Purchase up = new Purchase(purchases.size() + 1, users.get(1), products.get(1), date);
		purchaseDAO.create(up);
		purchases.add(up);
		assertEquals(new Integer(purchases.size() + 1), purchaseDAO.get(purchases.size() + 1).getId());
	}

	@Test
	public void testDeletePurchase()
	{
		Purchase up = purchases.get(0);
		purchaseDAO.delete(up);
		purchases.remove(0);
		assertNull(purchaseDAO.get(1));
	}

	@Test
	public void testGetTheListOfUsers()
	{
		List<User> usersList = userDAO.getUsers();
		assertEquals(usersList, users);
	}

	@Test
	public void testGetTheListOfProducts()
	{
		List<Product> productsList = productDAO.getProducts();
		assertEquals(productsList, products);
	}

	@Test
	public void testGetTheListOfProductsBoughtByAUser()
	{
		List<Purchase> purchased = purchaseDAO.getPurchases(userDAO.get(99));
		assertEquals(purchasedByUser99, purchased);
	}

	@Test
	public void testGetTheListOfProductsBoughtInADay()
	{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 25);
		Date date = c.getTime();
		List<Purchase> purchased = purchaseDAO.getPurchases(date);
		assertEquals(purchases, purchased);
	}

	@Test
	public void testGetDateWithGreatestNumberOfPurchase()
	{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 25);
		Date d = c.getTime();
		Date date = purchaseDAO.getDateWithGreatestNumberOfPurchase();
		assertEquals(date, d);
	}
}