package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ShopDAO implements ClassDAO {

	private static final String SELECTBYID = "SELECT * FROM shops where id = ";
	private static final String SELECTBYUSRNAME = "SELECT * FROM shops where username = '";
	private static final String SELECTCOUNT = "SELECT COUNT(*) FROM shops";
	private static final String SELECT = "SELECT * FROM shops";
	private static SessionFactory factory;

	public ShopDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Object shop) {
		if (shop instanceof Shop) {
			Session session = factory.openSession();
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

	}

	@Override
	public Object getById(Integer id) {
		Session session = factory.openSession();
		Shop shop = (Shop) session.createSQLQuery(SELECTBYID + id).addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}

	@Override
	public Object getByUsername(String username) {
		Session session = factory.openSession();
		Shop shop = (Shop) session.createSQLQuery(SELECTBYUSRNAME + username + "'").addEntity(Shop.class)
				.uniqueResult();
		session.close();
		return shop;
	}

	@Override
	public void update(Object shop) {
		if (shop instanceof Shop) {
			Session session = factory.openSession();
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

	}

	@Override
	public void delete(Object shop) {
		if (shop instanceof Shop) {
			Session session = factory.openSession();
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

	}

	@Override
	public int numberOfTuple() {
		Session session = factory.openSession();
		// Criteria criteria= session.createCriteria(Shop.class);
		// criteria.setProjection(Projections.rowCount());
		// int size = (int) criteria.uniqueResult();
		int size = session.createSQLQuery(SELECT).list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<Shop> getTuples() {
		Session session = factory.openSession();
		List<Shop> shop = (List<Shop>) session.createSQLQuery(SELECT).addEntity(Shop.class).list();
		session.close();
		return shop;
	}

}
