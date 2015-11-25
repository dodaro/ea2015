package it.fmaida.hibernate.persistence;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ShopDAOImpl implements ShopDAO {

	private static SessionFactory sessionFactory;
	
	public ShopDAOImpl() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public void create(Shop shop) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(shop);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Shop shop) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(shop);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Shop shop) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(shop);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Shop getShop(int id) {
		Session session = sessionFactory.openSession();
		Shop shop = (Shop) session.createSQLQuery("SELECT * FROM shops where id = '" + id + "'" ).addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}


	@Override
	public List<Shop> getShopsByCity(String city) {
		Session session = sessionFactory.openSession();
		List<Shop> shops = session.createSQLQuery("SELECT * FROM shops where city = '" + city + "'").addEntity(Shop.class).list();
		session.close();
		return shops;
	}

	@Override
	public List<Shop> getShops() {
		Session session = sessionFactory.openSession();
		List<Shop> shops = session.createSQLQuery("SELECT * FROM shops").addEntity(Shop.class).list();
		session.close();
		return shops;
	}

	@Override
	public int numberOfShops() {
		Session session = sessionFactory.openSession();
		BigInteger n = (BigInteger) session.createSQLQuery("SELECT count(*) FROM shops").uniqueResult();
		session.close();
		return n.intValue();
	}

}
