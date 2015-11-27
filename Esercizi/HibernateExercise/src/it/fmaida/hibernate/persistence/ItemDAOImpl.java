package it.fmaida.hibernate.persistence;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ItemDAOImpl implements ItemDAO {

	private DBManager dbManager;
	
	public ItemDAOImpl() {
		this.dbManager = DBManager.getInstance();
	}
	
	@Override
	public void createItem(Item item) {
		this.dbManager.performOperation(item, DBManager.CREATE);
	}

	@Override
	public void delete(Item item) {
		this.dbManager.performOperation(item, DBManager.DELETE);
	}

	@Override
	public void updateItem(Item item) {
		this.dbManager.performOperation(item, DBManager.UPDATE);
	}

	@Override
	public Item getItem(int id) {
		Session session = dbManager.getSession();
		Item item = (Item) session.createSQLQuery("SELECT * FROM Items WHERE id = " + id).addEntity(Item.class).uniqueResult();
		session.close();
		return item;
	}

	@Override
	public Item getItem(String name) {
		Session session = dbManager.getSession();
		Item item = (Item) session.createSQLQuery("SELECT * FROM Items WHERE name = '" + name + "'" ).addEntity(Item.class).uniqueResult();
		session.close();
		return item;
	}

	@Override
	public List<Item> getItemsByCategory(String category) {
		Session session = dbManager.getSession();
		List<Item> items = session.createSQLQuery("SELECT * FROM Items WHERE category = '" + category + "'").addEntity(Item.class).list();
		session.close();
		return items;
	}

	@Override
	public List<Item> getAllItems() {
		Session session = dbManager.getSession();
		List<Item> items = session.createSQLQuery("SELECT * FROM Items").addEntity(Item.class).list();
		session.close();
		return items;
	}

}
