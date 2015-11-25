package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import DAOImplementations.ClientDAOImplementation;
import DAOImplementations.ProductDAOImplementation;
import DAOImplementations.ShopDAOImplementation;
import DAOInterfaces.ClientDAOInterface;
import DAOInterfaces.ProductDAOInterface;
import DAOInterfaces.ShopDAOInterface;
import persistence.Client;
import persistence.Product;
import persistence.Shop;

public class PersistenceTest
{
	static ClientDAOInterface clientDAO;
	static List<Client> clients;
	static ProductDAOInterface productDAO;
	static List<Product> products;
	static ShopDAOInterface shopDAO;
	static List<Shop> shops;

	@BeforeClass
	static public void init()
	{
		clientDAO = new ClientDAOImplementation();
		clients = new ArrayList<Client>();
		productDAO = new ProductDAOImplementation();
		products = new ArrayList<Product>();
		shopDAO = new ShopDAOImplementation();
		shops = new ArrayList<Shop>();
		initDB();
	}

	static public void initDB()
	{
		for (int i = 1; i <= 100; i++)
		{
			Client c = new Client(i, "name"+i, "surname"+i, "birthLocation"+i);
			clients.add(c);
			clientDAO.create(c);
			Product p = new Product(i, "name"+i, "brand"+i, "category"+i, .0f + i);
			products.add(p);
			productDAO.create(p);
			Shop s = new Shop(i, "PIVA"+i, "name"+1, "location"+i);
			shops.add(s);
			shopDAO.create(s);
		}
	}

	@Test
	public void testGetClientById()
	{
		assertEquals(new Integer(11), clientDAO.get(11).getId());
	}

	@Test
	public void testGetClientByUnusedId()
	{
		assertNull(clientDAO.get(101));
	}

	@Test
	public void testNumberOfClients()
	{
		assertEquals(100, clientDAO.numberOfClients());
	}

	@Test
	public void testNumberOfClientsAfterDeletion()
	{
		clientDAO.delete(clients.get(0));
		assertEquals(99, clientDAO.numberOfClients());
	}
	
	@Test
	public void testProductPriceAfterUpdate()
	{
		Product p = productDAO.get(50);
		p.setPrice(100.0f);
		productDAO.update(p);
		assertEquals(new Float(100.0f), productDAO.get(50).getPrice());
	}
	
	@Test
	public void testGetShopById()
	{
		assertEquals(new Integer(11), shopDAO.get(11).getId());
	}
	
	@Test
	public void testGetShopByPartitaIVA() 
	{
		assertEquals(new Integer(8), shopDAO.get("PIVA8").getId());
	}
}
