package persistence.product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.LongType;


public class ConcreteProductDAO implements ProductDAO{

	private static SessionFactory factory;
	
	public ConcreteProductDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public Product find(long id) {
		
		Session session = factory.openSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class)
				.uniqueResult();
		session.close();
		return product;
	}

	
	@Override
	public void create(Product product) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(product);		
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
	public void updateProduct(Product product) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(product);		
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
	public void delete(Product product) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(product);
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
	public long getStore(long productId) {
		
		Session session = factory.openSession();
		Long id = (Long) session.createSQLQuery("SELECT store FROM products where id = " + productId).addScalar("store", LongType.INSTANCE)
				.uniqueResult();
				
		session.close();
		return id;
	}

	@Override
	public List<Product> findAll() {
		
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
				
		session.close();
		return products;
	}

	
}
