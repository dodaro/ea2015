package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShopDAOImpl implements ShopDAO {

	public ShopDAOImpl() {
	}

	@Override
	public void create(Shop shop) {
		Session session = Connect.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(shop);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void update(Shop shop) {
		Session session = Connect.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(shop);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Shop shop) {
		Session session = Connect.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(shop);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public int numberOfShops() {
		Session session = Connect.getSessionFactory().openSession();
		int size = session.createSQLQuery("SELECT * FROM shops").list().size();
		session.close();
		return size;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShops() {
		Session session = Connect.getSessionFactory().openSession();
		List<Shop> shops = (List<Shop>) session.createSQLQuery("SELECT * FROM shops").addEntity(Shop.class).list();
		session.close();
		return shops;
	}
	
	@Override
	public Shop get(Integer id) {
		Session session = Connect.getSessionFactory().openSession();
		Shop shop = (Shop) session.createSQLQuery("SELECT * FROM shops where id = " + id)
				.addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}

	@Override
	public Shop get(String shopname) {
		Session session = Connect.getSessionFactory().openSession();
		Shop shop = (Shop) session.createSQLQuery("SELECT * FROM shops where shopname = '" + shopname + "'")
				.addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}
}
