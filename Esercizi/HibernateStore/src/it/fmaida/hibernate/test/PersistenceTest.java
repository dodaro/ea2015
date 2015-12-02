package it.fmaida.hibernate.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import it.fmaida.hibernate.persistence.Item;
import it.fmaida.hibernate.persistence.ItemDAO;
import it.fmaida.hibernate.persistence.ItemDAOImpl;
import it.fmaida.hibernate.persistence.ItemPurchase;
import it.fmaida.hibernate.persistence.ItemPurchaseDAO;
import it.fmaida.hibernate.persistence.ItemPurchaseDAOImpl;
import it.fmaida.hibernate.persistence.Purchase;
import it.fmaida.hibernate.persistence.PurchaseDAO;
import it.fmaida.hibernate.persistence.PurchaseDAOImpl;
import it.fmaida.hibernate.persistence.Shop;
import it.fmaida.hibernate.persistence.ShopDAO;
import it.fmaida.hibernate.persistence.ShopDAOImpl;
import it.fmaida.hibernate.persistence.User;
import it.fmaida.hibernate.persistence.UserDAO;
import it.fmaida.hibernate.persistence.UserDAOImpl;

public class PersistenceTest {

	static UserDAO userDAO;
	static ItemDAO itemDAO;
	static ShopDAO shopDAO;
	static PurchaseDAO purchaseDAO;
	static ItemPurchaseDAO itemPurchaseDAO;
	static Date date;
	
	static List<User>usersList;
	static List<Item>itemsList;
	static List<Shop>shopsList;
	static List<Purchase>purchasesList;
	static List<ItemPurchase> itemPurchases;
	
	@BeforeClass
	public static void init() { 
		
		userDAO = new UserDAOImpl();
		itemDAO = new ItemDAOImpl();
		shopDAO = new ShopDAOImpl();
		purchaseDAO = new PurchaseDAOImpl();
		itemPurchaseDAO = new ItemPurchaseDAOImpl();
		
		
		Item item1 = new Item(1, "turtle beach task sentinel", "cuffie", 49.90f,null);
		Item item2 = new Item(1, "turtle beach 40p", "cuffie", 50.90f,null);
		Item item3 = new Item(1, "turtle beach 50p sentinel", "cuffie", 49.90f,null);
		Item item4 = new Item(1, "Tv samsung", "tv", 499.90f,null);
		Item item5 = new Item(1, "PS4", "console", 349.90f,null);
		Item item6 = new Item(1, "XboxOne", "ps3", 349.90f,null);

		itemDAO.createItem(item1);
		itemDAO.createItem(item2);
		itemDAO.createItem(item3);
		itemDAO.createItem(item4);
		itemDAO.createItem(item5);
		itemDAO.createItem(item6);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String yesterdayDateString = "01-12-2015";
		String todayDateString = "02-12-2015";
		Date yesterdayDate = null;
		Date todayDate = null;
		try {
			yesterdayDate = sdf.parse(yesterdayDateString);
			todayDate = sdf.parse(todayDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		User user1 = new User(1,"Francesco","Francesco","Francesco","Francesco","password",new Date(todayDate.getTime()));
		User user2 = new User(1,"Aldo","Aldo","Aldo","Aldo","Aldo",new Date(yesterdayDate.getTime()));
		User user3 = new User(1,"Alessandro","Alessandro","Alessandro","Alessandro","Alessandro",new Date());
		User user4 = new User(1,"Serafino","Serafino","Serafino","Serafino","Serafino",new Date());
		User user5 = new User(1,"Luigi","Luigi","Luigi","Luigi","Luigi",new Date());
		User user6 = new User(1,"Mostaf","Mostaf","Mostaf","Mostaf","Mostaf",new Date());

		userDAO.createUser(user1);
		userDAO.createUser(user2);
		userDAO.createUser(user3);
		userDAO.createUser(user4);
		userDAO.createUser(user5);
		userDAO.createUser(user6);
		
		//Creating purchases
		Purchase purchase1 = new Purchase(0, user1, null, user1.getBirthDate());
		Purchase purchase2 = new Purchase(0, user1, null, user1.getBirthDate());
		
		Purchase purchase3 = new Purchase(0,user2,null,user2.getBirthDate());
		
		//needed in testPurchasesInDate
		date = user1.getBirthDate();
		
		//creating two itemsPurchases per user1
		ArrayList<ItemPurchase> user1Purchases1 = new ArrayList<>();
		ArrayList<ItemPurchase> user1Purchases2 = new ArrayList<>();
		ArrayList<ItemPurchase> user2Purchases1 = new ArrayList<>();
		
		//create three items per first purchases
		ItemPurchase itemPurchase1 = new ItemPurchase(0, purchase1, item1);
		ItemPurchase itemPurchase2 = new ItemPurchase(0, purchase1, item2);
		ItemPurchase itemPurchase3 = new ItemPurchase(0, purchase1, item3);
		ItemPurchase itemPurchase4 = new ItemPurchase(0, purchase2, item3);
		ItemPurchase itemPurchase5 = new ItemPurchase(0, purchase3, item3);

		//add the items for user 1
		user1Purchases1.add(itemPurchase1);
		user1Purchases1.add(itemPurchase2);
		user1Purchases1.add(itemPurchase3);
		
		// add the same item for user 1 in itemPurchase2
		user1Purchases2.add(itemPurchase3);
		
		//add the items for user 2
		user2Purchases1.add(itemPurchase5);
		
		purchase1.setItemPurchases(user1Purchases1);
		purchase2.setItemPurchases(user1Purchases2);
		
		purchase3.setItemPurchases(user2Purchases1);
		
		purchaseDAO.create(purchase2);
		purchaseDAO.create(purchase1);
		
		purchaseDAO.create(purchase3);
				
		itemPurchaseDAO.create(itemPurchase1);
		itemPurchaseDAO.create(itemPurchase2);
		itemPurchaseDAO.create(itemPurchase3);
		itemPurchaseDAO.create(itemPurchase4);
		
		itemPurchaseDAO.create(itemPurchase5);
		
		
		
		
		
//		Purchase purchase1 = new Purchase(0,user1,user1Purchases,user1.getBirthDate());
		
//		purchaseDAO.create(purchase1);
		
		
//		shopDAO.create(new Shop(1, "vida chi ti pigli", "cosenza"));
//		shopDAO.create(new Shop(2, "alti livelli", "cosenza"));
//		shopDAO.create(new Shop(3, "Scarpelli Caffè", "cosenza"));
//		shopDAO.create(new Shop(4, "Bar Brutto", "catanzaro"));
//		shopDAO.create(new Shop(5, "non si puo vedere", "catanzaro"));
		
	
		
		usersList = userDAO.getUsers();
		itemsList = itemDAO.getAllItems();
	
		
			
	}
	
	
	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(1),userDAO.get("Francesco").getId());
	}
	
	@Test
	public void testItemsBougthByUser() {
		int count = 0;
		List<Purchase> purchases = userDAO.get("Francesco").getPurchases();
		for ( Purchase curr : purchases ) {
			count += curr.getItemPurchases().size();
		}
		assertEquals(4,count);
	}
	
	@Test
	public void numberOfPurchases() {
		assertEquals(3,purchaseDAO.getAllPurchases().size());
	}
	

	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(userDAO.get("giorgio"));
	}

	@Test
	public void testGetUserById() {
	}

	@Test
	public void testNumberOfUsers() {
		assertEquals(6,userDAO.numberOfUsers());
	}

	@Ignore @Test
	public void testNumberOfUsersAfterDeletion() {
		userDAO.delete(usersList.get(0));
		assertEquals(9, userDAO.numberOfUsers());
	}
	
	@Ignore @Test
	public void testShopAdd() {
		int currentShops = shopDAO.numberOfShops();
		shopDAO.create(new Shop(1, "negozio", "cosenza"));
		assertEquals(currentShops + 1, shopDAO.numberOfShops());
	}
	
	@Ignore @Test
	public void shopCountInCosenza() {
		assertEquals(3, shopDAO.getShopsByCity("cosenza").size());
	}
	
	@Ignore @Test
	public void shopModified() {
		Shop shopToEdit = shopDAO.getShop(4);
		String newName = "Madonna quanto e' brutto!";
		shopToEdit.setName(newName);
		shopDAO.update(shopToEdit);
		assertEquals(newName, shopDAO.getShop(4).getName());
	}
	
	@Test
	public void testProductsNumber() {
		int items = itemDAO.getAllItems().size();
		assertEquals(6, items);
	}
	
	@Test
	public void testPurchasesInDate() {
		int count = purchaseDAO.getPurchaseInDate(date).size();
		assertEquals(2, count);
	}
	
	@Test
	public void dayMaxPurchases() {
		Date d = purchaseDAO.dateMaxPurchases();
		assertEquals(date, d);
	}
	
	
	
}
	

