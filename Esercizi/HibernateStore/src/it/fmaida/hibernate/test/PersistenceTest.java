package it.fmaida.hibernate.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import it.fmaida.hibernate.persistence.Item;
import it.fmaida.hibernate.persistence.ItemDAO;
import it.fmaida.hibernate.persistence.ItemDAOImpl;
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
	
	static List<User>usersList;
	static List<Item>itemsList;
	static List<Shop>shopsList;
	static List<Purchase>purchasesList;
	
	@BeforeClass
	public static void init() { 
		
		userDAO = new UserDAOImpl();
		itemDAO = new ItemDAOImpl();
		shopDAO = new ShopDAOImpl();
		purchaseDAO = new PurchaseDAOImpl();
		
		
		
		Item item1 = new Item(1, "turtle beach task sentinel", "cuffie", 49.90f);
		Item item2 = new Item(1, "turtle beach 40p", "cuffie", 50.90f);
		Item item3 = new Item(1, "turtle beach 50p sentinel", "cuffie", 49.90f);
		Item item4 = new Item(1, "Tv samsung", "tv", 499.90f);
		Item item5 = new Item(1, "PS4", "console", 349.90f);
		Item item6 = new Item(1, "XboxOne", "ps3", 349.90f);

		itemDAO.createItem(item1);
		itemDAO.createItem(item2);
		itemDAO.createItem(item3);
		itemDAO.createItem(item4);
		itemDAO.createItem(item5);
		itemDAO.createItem(item6);
		
		User user1 = new User(1,"Francesco","Francesco","Francesco","Francesco","password",new Date());
		User user2 = new User(1,"Aldo","Aldo","Aldo","Aldo","Aldo",new Date());
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
		
		ArrayList<Item> user1Items = new ArrayList<>();
		user1Items.add(item2);
		user1Items.add(item3);
		user1Items.add(item4);
		
		Purchase purchase1 = new Purchase(1, user1, user1Items, user1.getBirthDate());
		
		purchaseDAO.create(purchase1);
		
		
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
			//pare non prendere nulla....
			count += curr.getItems().size();
		}
		assertEquals(3,count);
	}
	
	@Test
	public void numberOfPurchases() {
		assertEquals(1,purchaseDAO.getAllPurchases().size());
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
	
	
	
}
	

