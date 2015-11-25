package persistence.store;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StringType;

import persistence.product.ConcreteProductDAO;
import persistence.product.Product;
import persistence.product.ProductDAO;


public class ConcreteStoreDAO implements StoreDAO{

	private static SessionFactory factory;
	
	public ConcreteStoreDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public Store find(long id) {
		
		Session session = factory.openSession();
		Store store = (Store) session.createSQLQuery("SELECT * FROM stores where id = " + id).addEntity(Store.class)
				.uniqueResult();
		session.close();
		return store;
	}

	
	@Override
	public void create(Store store) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(store);		
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}	
	}

	@Override
	public void update(Store store) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(store);		
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Store store) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(store);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Product> getProducts(long storeId) {
		
		List<Product> toReturn = new ArrayList<>();
		
		//Returns 0 products, maybe due to the new DAO
		ProductDAO dao = new ConcreteProductDAO();
		List<Product> products = dao.findAll();
		
		for (Product product : products) {
			
			if(dao.getStore(product.getId()) == storeId)
				toReturn.add(product);
		}
		
		return toReturn;
	}

	
}
