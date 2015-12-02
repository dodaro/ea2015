package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
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

	static UserDAO userDAO;
	static int userNumber = 10;
	static ProductDAO productDAO;
	static int productNumber = 100;
	static PurchaseDAO purchaseDAO;	
	static int purchaseNumber = 100;
	static List<User> users;
	static List<Product> products;
	static List<Purchase> purchases;
	static boolean dbInitialized = false;

	@BeforeClass
	static public void init() throws Exception {
		userDAO = new UserDAOImpl();
		productDAO = new ProductDAOImpl();
		purchaseDAO = new PurchaseDAOImpl();
		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		purchases = new ArrayList<Purchase>();
		initDB();
	}

	static public void initDB() throws Exception {
		if(dbInitialized)
			return;

		dbInitialized = true;

		for (int i = 0; i < userNumber; i++) {
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 2000);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, 1);
			Date d = c.getTime();
			User u = new User(i, "username"+i, "password"+i, "firstname"+i, "lastname"+i, d);
			users.add(u);
			userDAO.create(u);
		}

		for (int i = 0; i < productNumber; i++) {
			Product p = new Product(i,  "name"+i, "description"+i, 1.0f+i*1.0f);
			products.add(p);
			productDAO.create(p);
		}

		for (int i = 0; i < purchaseNumber; i++) {
			int userId = i/userNumber;

			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 2015);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, userId);
			Date d = c.getTime();

			Purchase p = new Purchase(i, userDAO.get(userId), productDAO.get(i), d);
			purchases.add(p);
			purchaseDAO.create(p);
		}
	}

	// 1. Insert/Update/Delete a user.
	@Test
	public void testInsertUser() throws Exception{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2000);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date d = c.getTime();
		User u = new User(userNumber, "username"+userNumber, "password"+userNumber, "firstname"+userNumber, "lastname"+userNumber, d);
		users.add(u);
		userDAO.create(u);
		userNumber++;
	}

	@Test
	public void testUpdateUser() throws Exception{
		User u = userDAO.get(userNumber-1);
		if(u!=null){
			u.setFirstName("updatedFirstName");
			userDAO.update(u);
		}
	}

	@Test
	public void testDeleteUser() throws Exception{
		User u = userDAO.get(userNumber-1);
		if(u!=null){
			userDAO.delete(u);
			userNumber--;		
		}
	}

	//	2. Insert/Update/Delete a product.
	@Test
	public void testInsertProduct() throws Exception{
		Product p = new Product(productNumber, "name"+productNumber, "description"+productNumber, 1.0f+productNumber*1.0f);
		products.add(p);
		productDAO.create(p);
		productNumber++;
	}

	@Test
	public void testUpdateProduct() throws Exception{
		Product p = productDAO.get(productNumber-1);
		if(p!=null){
			p.setPrice(100.0f);
			productDAO.update(p);	
		}
	}

	@Test
	public void testDeleteProduct() throws Exception{
		Product p = productDAO.get(productNumber-1);
		if(p!=null){
			productDAO.delete(p);
			productNumber--;
		}
	}

	// 3. Insert/Delete a purchase.
	@Test
	public void testInsertPurchase() throws Exception{
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, 25);
		Date d = c.getTime();
		Purchase p = new Purchase(purchaseNumber, userDAO.get(0), productDAO.get(0), d);
		purchases.add(p);
		purchaseDAO.create(p);
		purchaseNumber++;
	}

	@Test
	public void testDeletePurchase() throws Exception{
		Purchase p = purchaseDAO.get(purchaseNumber-1);
		if(p!=null){
			purchaseDAO.delete(p);
			purchaseNumber--;
		}
	}

	//	4. Get the list of all products in the database.
	@Test
	public void testGetListOfProcuctInDB() {
		assertEquals(0, productDAO.getProducts().size());
	}

	//	5. Get the list of all users in the database.
	@Test
	public void testGetListOfUserInDB() {
		assertEquals(users.size(), userDAO.getUsers().size());		
	}

	//	6. Get the list of all products bought by a user.
	@Test
	public void testGetListOfProductsBoughtByUser() {
		List<Product> p = new ArrayList<Product>(Arrays.asList(products.get(0)));
		assertEquals(p, new ArrayList<Product>(purchaseDAO.getProductBoughtByUser(users.get(0))));		
	}

	//	7. Get all the purchase of a specific date.
	@Test
	public void testGetListOfPurchaseInDate() {
		int userId = users.get(0).getId()/userNumber;
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, userId);
		Date d = c.getTime();
		
		List<Purchase> purchasesInDate = purchaseDAO.getPurchasesInDate(d);
		assertEquals(productNumber/userNumber, purchasesInDate.size());
	}

	//	8. Get the date on which they were made the greatest number of purchases.
	@Test
	public void testGetDateWithGreaterNumberOfPurchase() {
		int userId = users.get(users.size()-1).getId()/userNumber;
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DAY_OF_MONTH, userId);
		Date d = c.getTime();

		assertEquals(d, purchaseDAO.getDateWithGreaterNumberOfPurchases());
	}
}
