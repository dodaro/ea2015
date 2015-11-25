package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	private static SessionFactory factory;

	public ProductDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	//@Override
	public void create(Product product) throws Exception {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(product);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	//@Override
	public void update(Product product) throws Exception {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(product);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	//@Override
	public void delete(Product product) throws Exception {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(product);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}	

	//@Override
	public Product get(Integer id) {
		Session session = factory.openSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class)
				.uniqueResult();
		session.close();
		return product;
	}

	//@Override
	public Product get(String name) {
		Session session = factory.openSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where name = '" + name + "'")
				.addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}
	
	//@Override
	public int numberOfProducts() {
		Session session = factory.openSession();
		int size = session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	//@Override
	public List<Product> getProducts() {
		Session session = factory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
		session.close();
		return products;
	}
}
