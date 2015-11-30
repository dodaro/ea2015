package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.belongs.Belongs;
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
	static List<Belongs> belongsList = new ArrayList<>();
	
	static Date date;
	
	@BeforeClass
	static public void init() {
		
		initDB();
	}

	static public void initDB() {
		
		/*creation of the products*/
		Product telefono = new Product(0,"Telefono",100);
		Product camion = new Product(0,"Camion",100);
		
		/*creation of the users*/
		User user = new User("username", "00abf2563.", "Roma");
		
		Purchase purchase = new Purchase(user);
		
		Belongs belongs = new Belongs(purchase,telefono);
		Belongs belongs2 = new Belongs(purchase,camion);
		
		DBHandler.create(user);
		DBHandler.create(telefono);
		DBHandler.create(camion);
		DBHandler.create(purchase);
		DBHandler.create(belongs);
		DBHandler.create(belongs2);
		
		purchases.add(purchase);
		users.add(user);
		products.add(telefono);
		products.add(camion);
		belongsList.add(belongs);
		belongsList.add(belongs2);
		
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
