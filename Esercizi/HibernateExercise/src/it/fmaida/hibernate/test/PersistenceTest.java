package it.fmaida.hibernate.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import it.fmaida.hibernate.persistence.Item;
import it.fmaida.hibernate.persistence.ItemDAO;
import it.fmaida.hibernate.persistence.ItemDAOImpl;
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
	
	static List<User>usersList;
	static List<Item>itemsList;
	static List<Shop>shopsList;
	
	@BeforeClass
	public static void init() { 
		
		userDAO = new UserDAOImpl();
		itemDAO = new ItemDAOImpl();
		shopDAO = new ShopDAOImpl();
		
		itemDAO.createItem(new Item(1, "turtle beach task sentinel", "cuffie", 49.90f));
		itemDAO.createItem(new Item(1, "turtle beach 40p", "cuffie", 50.90f));
		itemDAO.createItem(new Item(1, "turtle beach 50p sentinel", "cuffie", 49.90f));
		itemDAO.createItem(new Item(1, "Tv samsung", "tv", 499.90f));
		itemDAO.createItem(new Item(1, "PS4", "console", 349.90f));
		itemDAO.createItem(new Item(1, "XboxOne", "ps3", 349.90f));
		
		
		shopDAO.create(new Shop(1, "vida chi ti pigli", "cosenza"));
		shopDAO.create(new Shop(2, "alti livelli", "cosenza"));
		shopDAO.create(new Shop(3, "Scarpelli Caffè", "cosenza"));
		shopDAO.create(new Shop(4, "Bar Brutto", "catanzaro"));
		shopDAO.create(new Shop(5, "non si puo vedere", "catanzaro"));
		
		for (int i = 0; i < 10; i++) {
			User u = new User(i,"username:"+i,"firstName:"+i,"lastName:"+i,"address:"+i,"password:"+i );
			userDAO.createUser(u);
		}
		
		usersList = userDAO.getUsers();
		itemsList = itemDAO.getAllItems();
		
		
	}
	
	
	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(10),userDAO.get("username:9").getId());
	}

	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(this.userDAO.get("francesco"));
	}

	@Test
	public void testGetUserById() {
	}

	@Test
	public void testNumberOfUsers() {
		assertEquals(10,userDAO.numberOfUsers());
	}

	@Test
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
	
	@Test
	public void shopCountInCosenza() {
		assertEquals(3, shopDAO.getShopsByCity("cosenza").size());
	}
	
	@Test
	public void shopModified() {
		Shop shopToEdit = shopDAO.getShop(4);
		String newName = "Madonna quanto e' brutto!";
		shopToEdit.setName(newName);
		shopDAO.update(shopToEdit);
		assertEquals(newName, shopDAO.getShop(4).getName());
	}
	
	
	
}
	

