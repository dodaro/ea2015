package tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import persistence.dao.ProductDAO;
import persistence.dao.PurchaseDAO;
import persistence.dao.SinglePurchaseDAO;
import persistence.dao.UserDAO;
import persistence.data.Product;
import persistence.data.Purchase;
import persistence.data.SinglePurchase;
import persistence.data.User;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersistenceTest {

	
	static UserDAO userDAO;
	static PurchaseDAO purchaseDAO;
	static ProductDAO productDAO;
	static SinglePurchaseDAO singlePurchaseDAO;
	
	static List<User> users;
	static List<Purchase> purchases;
	static List<Product> products;
	static List<SinglePurchase> singlePurchases;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@BeforeClass
	static public void init() {
		
		userDAO = new UserDAO();
		purchaseDAO = new PurchaseDAO();
		productDAO = new ProductDAO();
		singlePurchaseDAO = new SinglePurchaseDAO();
		
		users = new ArrayList<>();
		purchases = new ArrayList<>();
		products = new ArrayList<>();
		singlePurchases = new ArrayList<>();
		
		try {
			initDB();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static public void initDB() throws ParseException {

		for (int i = 0; i < 2; i++) {
			User u = new User("username" + i, "password" + i);
			users.add(u);
			userDAO.create(u);
		}
		
		for (int i = 0; i < 2; i++) {
			Product product = new Product("product" + i, 2*i);
			products.add(product);
			productDAO.create(product);
		}
		
		int day = 1;
		for (int i = 0; i < 2; i++) {
			Purchase purchase = new Purchase(sdf.parse(day +"/12/2015"), users.get(i));
			purchases.add(purchase);
			purchaseDAO.create(purchase);
			day++;
		}
		
		//other purchase for test last query
		Purchase pr = new Purchase(sdf.parse("1/12/2015"), users.get(0));
		purchases.add(pr);
		purchaseDAO.create(pr);
		
		for (int i = 0; i < 2; i++) {
			SinglePurchase singlePurchase = new SinglePurchase(products.get(i), purchases.get(i));
			singlePurchases.add(singlePurchase);
			singlePurchaseDAO.create(singlePurchase);
		}
		
		
		//other single purchase for test last query
		SinglePurchase singlePurchase = new SinglePurchase(products.get(0), purchases.get(purchases.size()-1));
		singlePurchases.add(singlePurchase);
		singlePurchaseDAO.create(singlePurchase);
	}
	
	
	
	@Test
	public void t1_getProductsList() {
		
		assertEquals(products, productDAO.getAllProducts());
	}
	
	@Test
	public void t2_getUsersList() {
		
		assertEquals(users, userDAO.getAllUsers());
	}
	
	@Test
	public void t3_getPurchasesOfUser() {
		
		List<Product> p = new ArrayList<>(Arrays.asList(products.get(0)));
		assertEquals(p, new ArrayList<>(userDAO.getUserPurchaseProducts(users.get(0))));
	}
	
	@Test
	public void t4_getPurchaseInDate() {
		
		
		List<Purchase> p = new ArrayList<>(Arrays.asList(purchases.get(0), purchases.get(2)));
		try {
			assertEquals(p, purchaseDAO.getAllPurchaseInDate(sdf.parse("1/12/2015")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void t5_getDateWithMaxPurchases() {
		
		try {
			assertEquals(sdf.parse("1/12/2015"), purchaseDAO.getDateOfMaxPurchase());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void t6_insertUser() {
		User usr = new User("asd", "pass");
		userDAO.create(usr);
		
		assertEquals(usr, userDAO.get("asd"));
	}
	
	
	@Test
	public void t7_updateUser() {
	
		User usr = userDAO.get("username0");
		usr.setPassword("aaa");
		userDAO.update(usr);
	
		assertEquals(usr, userDAO.get("username0"));
	}

	
	
	@Test
	public void t8_deleteUser() {

		User usr = new User("sss", "sss");
		userDAO.create(usr);
		userDAO.delete(userDAO.get("sss"));
		
		assertNull(userDAO.get("sss"));
	}
	
	
	/*
	@Test
	public void insertProduct() {
	}
	
	@Test
	public void updateProduct() {
	}
	
	@Test
	public void deleteProduct() {
	}
	
	@Test
	public void InsertPurchase() {
	}
	
	@Test
	public void deletePurchase() {
	}
	
*/
	
}
