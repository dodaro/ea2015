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

public class ProductDAOImpl implements ProductDAO{
	
	private static SessionFactory factory;

	public ProductDAOImpl() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Product prod) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(prod);		
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
	public Product get(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class)
				.uniqueResult();
		session.close();
		return product;
	}

	@Override
	public void update(Product prod) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(prod);		
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
	public void delete(Product prod) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(prod);
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
	public int numberOfProducts() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		int size =(Integer) session.createSQLQuery("SELECT COUNT(*) FROM products").uniqueResult();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsForCategory(String category) {
		Session session = factory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products WHERE category = '"+ category+"'").addEntity(Product.class).list();
		session.close();
		return products;
		
	}


	@Override
	public Integer getStoreMembership(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		int producer =(Integer)session.createSQLQuery("SELECT idStore FROM products WHERE id ="+ id).uniqueResult();
		session.close();
		return producer;
	}
}
