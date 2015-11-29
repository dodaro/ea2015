package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.user.User;
import persistence.user.UserDAO;
import persistence.utils.DBHandler;
import persistence.product.ConcreteProductDAO;
import persistence.product.Product;
import persistence.product.ProductDAO;
import persistence.user.ConcreteUserDAO;;

public class PersistenceTestProduct {

	static ProductDAO productDao;
	static List<Product> products;

	@BeforeClass
	static public void init() {
		
		productDao = new ConcreteProductDAO();
		products = new ArrayList<Product>();
	
		
		initDB();
	}

	static public void initDB() {
		
		for (int i = 0; i < 100; i++) {
			
			Product product = new Product(i,"product" + i,10);
			products.add(product);
			DBHandler.create(product);
		}
	}

	@Test
	public void testFind() {
		assertEquals(products.get(9).getId(), productDao.find(10).getId());
	}
	
	@Test
	public void testGetProducts(){
		
		List<Product> productsTest = productDao.getProducts();
		for (int i = 0; i < productsTest.size(); i++) {
			
			assertEquals(productsTest.get(i).getId(), products.get(i).getId());
			assertEquals(productsTest.get(i).getName(), products.get(i).getName());
			assertEquals(productsTest.get(i).getPrice(), products.get(i).getPrice(),0.01);
		}
	}

}
