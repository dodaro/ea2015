package persistenceDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import persistenceDTO.Product;
import persistenceDTO.Store;
import persistenceDTO.User;

public class StoreDAOImpl implements StoreDAO {

	private static SessionFactory factory;

	public StoreDAOImpl() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public void create(Store st) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(st);		
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
	public Store get(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Store store = (Store) session.createSQLQuery("SELECT * FROM stores where id = " + id).addEntity(Store.class)
				.uniqueResult();
		session.close();
		return store;
	}

	@Override
	public void update(Store st) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(st);		
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
	public void delete(Store st) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(st);
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
	public int numberOfStores() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		int size =(Integer) session.createSQLQuery("SELECT COUNT(*) FROM stores").uniqueResult();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> getStores() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Store> stores = (List<Store>) session.createSQLQuery("SELECT * FROM stores").addEntity(Store.class).list();
		session.close();
		return stores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> getStoreForCity(String city) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Store> stores = (List<Store>) session.createSQLQuery("SELECT * FROM stores WHERE city = '"+city+"'").addEntity(Store.class).list();
		session.close();
		return stores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getStoreProducts(Integer idStore) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products WHERE idStore = "+ idStore).addEntity(Product.class).list();
		session.close();
		return products;
	}

}
