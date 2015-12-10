package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class PersistenceTest {

	static UserDAO userDao;
	static ProductDAO productDao;
	static PurchaseDAO purchaseDao;
	static List<User> users;
	static List<Product> products;
	static List<Purchase> purchases;
	static String DATE_FORMAT = "dd/MM/yyyy";
    static SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);

	@BeforeClass
	static public void init() {
		userDao = new UserDAOImpl();
		productDao = new ProductDAOImpl();
		purchaseDao = new PurchaseDAOImpl();
		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		purchases = new ArrayList<Purchase>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 100; i++) {
			String y = String.format("%04d", 1980 + i%20); 
			String d = String.format("%02d", (i%28)+1);
			String m = String.format("%02d", (i%12)+1);
			String birthdate = (d + "/" + m + "/" + y);
			User u;
			try {
				u = new User(i, "username" + i, "password" + i, "nome" + i,
						"cognome" + i, df.parse(birthdate));
			users.add(u);
			userDao.create(u);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < 10; i++) {
			Product p = new Product(i, "prod" + i, 10.0 * i, "cat" + i%2);
			products.add(p);
			productDao.create(p);
		}

		for (int i = 0; i < 11; i++) {
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 2015);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, 25+(i%2));
			Date d = c.getTime();
			Purchase p = new Purchase(i, d, users.get(i % 2), products.get((i % 5) + 1));
			System.out.println(p);
			purchases.add(p);
			purchaseDao.create(p);
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
	public void testNumberOfProducts() {
		assertEquals(10, productDao.numberOfProducts());
	}
	
	@Test
	public void testPurchasedProductByUser() {
		assertEquals(0, userDao.getPurchasedProducts(users.get(3)).size());
	}
	
	@Test
	public void testPurchasedProductByUser0() {
		assertEquals(5, userDao.getPurchasedProducts(users.get(0)).size());
	}
	
	@Test
	public void testAllPurchasesInDate() {
		Date d;
		try {
			d = df.parse("25/12/2015");
		assertEquals(6, purchaseDao.numberOfPurchasesForDate(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testdayOfMaxPurchases() {
		Date d;
		try {
			d = df.parse("25/12/2015");
			assertEquals(d, purchaseDao.dayOfMaxPurchases());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
