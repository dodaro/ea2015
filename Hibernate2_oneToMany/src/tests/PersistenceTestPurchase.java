package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.product.ConcreteProductDAO;
import persistence.product.Product;
import persistence.purchase.ConcretePurchaseDAO;
import persistence.purchase.Purchase;
import persistence.purchase.PurchaseDAO;
import persistence.user.User;
import persistence.utils.DBHandler;;

public class PersistenceTestPurchase {

	static List<Purchase> purchases = new ArrayList<>();
	static List<User> users = new ArrayList<>();
	static List<Product> products = new ArrayList<>();
	
	static Date date;
	
	@BeforeClass
	static public void init() {
		
		initDB();
	}

	static public void initDB() {
		
		/*creation of the products*/
		Product product = new Product(0,"Motorola",100);
		
		/*creation of the users*/
		User user = new User("username", "00abf2563.", "Roma");
		users.add(user);
		
		/*init of the list of products*/
		products.add(product);
		
		/*creation of the purchase*/
		Purchase purchase = new Purchase(user, products);
		purchases.add(purchase);
		
		product.setPurchase(purchase);
		purchase.setUser(user);
		
		DBHandler.create(user);
		DBHandler.create(purchase);
		DBHandler.create(product);
		
		
		/* saves the date of the purchase */
		date = purchase.getDate();
	}
	
	@Test
	public void testGetProductBoughtByUser(){
		
		PurchaseDAO dao = new ConcretePurchaseDAO();
		List<Product> res = dao.getProductsOfUser(users.get(0));
		
		assertTrue(!res.isEmpty());
		int i = 0;
		for (Product product : res) {
			
			assertEquals(products.get(i++).getId(), product.getId());
		}
	}
	
	@Test
	public void testGetPurchaseByDate(){
		
		PurchaseDAO dao = new ConcretePurchaseDAO();
		List<Purchase> res = dao.getPurchaseByDate(date);
		
		assertTrue(!res.isEmpty());
		
		int i = 0;
		for (Purchase purchase : res) {
			
			assertEquals(purchases.get(i++).getId(), purchase.getId());
		}

	}
	
	@Test
	public void testDateHighestNumOfSales(){
		
		PurchaseDAO dao = new ConcretePurchaseDAO();
		Date res = dao.getDateMaxNumSales();
		
		assertEquals(date,res);
	}

	/*
	@Test
	public void deletePurchase(){
		
		PurchaseDAO dao = new ConcretePurchaseDAO();
		
		int sizeBefore = dao.getPurchases().size();
		DBHandler.delete(purchases.get(0));
		int sizeAfter = dao.getPurchases().size();
		
		assertEquals(sizeAfter, sizeBefore - 1);
		
	}*/
}
