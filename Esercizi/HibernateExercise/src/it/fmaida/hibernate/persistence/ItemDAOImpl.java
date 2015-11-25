package it.fmaida.hibernate.persistence;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ItemDAOImpl implements ItemDAO {

	private static SessionFactory sessionFactory;
	
	public ItemDAOImpl() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public void createItem(Item item) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Item item) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(item);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void updateItem(Item item) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(item);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}
	}

	@Override
	public Item getItem(int id) {
		Session session = sessionFactory.openSession();
		Item item = (Item) session.createSQLQuery("SELECT * FROM Items WHERE id = " + id).addEntity(Item.class).uniqueResult();
		session.close();
		return item;
	}

	@Override
	public Item getItem(String name) {
		Session session = sessionFactory.openSession();
		Item item = (Item) session.createSQLQuery("SELECT * FROM Items WHERE name = '" + name + "'" ).addEntity(Item.class).uniqueResult();
		session.close();
		return item;
	}

	@Override
	public List<Item> getItemsByCategory(String category) {
		Session session = sessionFactory.openSession();
		List<Item> items = session.createSQLQuery("SELECT * FROM Items WHERE category = '" + category + "'").addEntity(Item.class).list();
		session.close();
		return items;
	}

	@Override
	public List<Item> getAllItems() {
		Session session = sessionFactory.openSession();
		List<Item> items = session.createSQLQuery("SELECT * FROM Items").addEntity(Item.class).list();
		session.close();
		return items;
	}

}
