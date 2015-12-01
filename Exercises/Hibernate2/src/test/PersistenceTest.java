package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistenceDTO.Product;
import persistenceDTO.Purchase;
import persistenceDTO.User;
import persistenceDAO.ProductDAOConc;
import persistenceDAO.PurchaseDAOConc;
import persistenceDAO.UserDAOConc;

public class PersistenceTest {

	static UserDAOConc userDao;
	static ProductDAOConc productsDao;
	static PurchaseDAOConc purchaseDao;
	
	static List<User> users;
	static List<Product> products;
	static List<Purchase> purchases;
	

	@BeforeClass
	static public void init() {
		userDao = new UserDAOConc();
		users = new ArrayList<User>();
		
		productsDao = new ProductDAOConc();
		products = new ArrayList<Product>();
		
		purchaseDao = new PurchaseDAOConc();
		purchases = new ArrayList<>();
		
		initDB();
	}

	static public void initDB() {
		
		//se faccio partire i=0 l'id(chiave primaria) si autoincrementa di 1.
		//se i=1 invece rispetta il valore.
		List<Purchase> purc=new ArrayList<Purchase>();
		List<Date> dates=new ArrayList<Date>();
		
		for (int i = 1; i < 30; i++) {
			User u = new User(i, "username" + i, "password" + i,"name"+i,"surname"+i,"address"+i,new Date(i*10),purc);
			userDao.create(u);
			
			Product p = new Product(i, "name" + i, (double)i+1,(double) i+2, i+3, "producer"+i,"category"+i,"description"+i,purc);
			productsDao.create(p);
			
			
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 1970+i);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, 25);
			dates.add(c.getTime());				
			
		}
		
		users=userDao.getUsers();
		products=productsDao.getProducts();
		/*HO AGGIORNATO LA LISTA DEGLI USER PRIMA DI INSERIRE I purchase:
		
		*in questo caso se uso users successivamente non avrò i purchase.
		*per cui o inizializzo la lista dopo aver dichiarato i purchase oppure uso un observer che notifichi l'aggiornamento di users e products
		dopo ogni purchase creato*/
		
		purchaseDao.create(new Purchase(1, dates.get(0), users.get(0), products.get(0)));
		purchaseDao.create(new Purchase(2, dates.get(2), users.get(1), products.get(0)));
		purchaseDao.create(new Purchase(3, dates.get(2), users.get(2), products.get(3)));
		purchaseDao.create(new Purchase(4, dates.get(0), users.get(0), products.get(3)));
		purchaseDao.create(new Purchase(5, dates.get(3), users.get(0), products.get(4)));
		purchaseDao.create(new Purchase(6, dates.get(2), users.get(1), products.get(0)));
		purchaseDao.create(new Purchase(7, dates.get(2), users.get(0), products.get(2)));
		
		
		//devo riaggiornare
		users=userDao.getUsers();
		products=productsDao.getProducts();
		
		//aggiungere un elemento ad una lista non comporta ovviamente l'aggiunta sulla colonna del database
		//users.get(0).getPurchase().add(new Purchase(1,new Date(1),users.get(0),products.get(0)));
	}

	@Test
	public void testGetPurchase() {
		assertEquals(new Integer(1), purchaseDao.get(1).getId());
	}
	
	@Test
	public void testGetPurchaseForUser() {
	assertEquals(new Integer(1), purchaseDao.getPurchasesForUser(users.get(0)).get(0).getId());
	}
	
	//7. Get all the purchase of a specific date.
	@Test
	public void testGetPurchaseForData() {
		
	Calendar c = new GregorianCalendar();
	c.set(Calendar.YEAR, 1971);
	c.set(Calendar.MONTH, Calendar.DECEMBER);
	c.set(Calendar.DAY_OF_MONTH, 25);
	Date d = c.getTime();

	assertEquals(2, purchaseDao.getPurchasesForDate(d).size());
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
	public void testProductForCategory(){
		assertEquals(new Integer(2), productsDao.getProductsForCategory("category2").get(0).getId());
	}
	
	
	//6. Get the list of all products bought by a user.
	@Test
	public void testBoughtByUser(){
		assertEquals(4,users.get(0).getPurchase().size());
		
	}
	
	//8. Get the date on which they were made the greatest number of purchases.
	@Test
	public void testGreatestDay(){
		assertEquals("1973-12-25",purchaseDao.getGreatestDate().toString());
	}
}