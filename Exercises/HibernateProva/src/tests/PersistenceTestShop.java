package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Shop;
import persistence.ShopDAO;
import persistence.ShopDAOImpl;

public class PersistenceTestShop {

	static ShopDAO shopDao;
	static List<Shop> shops;

	@BeforeClass
	static public void init() {
		shopDao = new ShopDAOImpl();
		shops = new ArrayList<Shop>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 10; i++) {
			Shop s = new Shop(i, "myshop" + i, "Non so Street" + i, 
					"New Rende", "AllShop");
			shops.add(s);
			shopDao.create(s);
		}
	}

	@Test
	public void testGetShopByName() {
		assertEquals(new Integer(10), shopDao.get("myshop9").getId());
	}

	@Test
	public void testGetShopByUnusedName() {
		assertNull(shopDao.get("Sidis"));
	}

	@Test
	public void testGetShopById() {
		assertEquals("myshop9", shopDao.get(10).getShopname());
	}

	@Test
	public void testNumberOfShops() {
		assertEquals(10, shopDao.numberOfShops());
	}

	@Test
	public void testNumberOfShopsAfterDeletion() {
		shopDao.delete(shops.get(0));
		assertEquals(9, shopDao.numberOfShops());
	}
}
