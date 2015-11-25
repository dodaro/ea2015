package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAOImpl implements ProductDAO {

	public ProductDAOImpl() {
	}

	@Override
	public void create(Product product) {
		Session session = Connect.getSessionFactory().openSession();
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

	@Override
	public void update(Product product) {
		Session session = Connect.getSessionFactory().openSession();
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

	@Override
	public void delete(Product product) {
		Session session = Connect.getSessionFactory().openSession();
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

	@Override
	public int numberOfProducts() {
		Session session = Connect.getSessionFactory().openSession();
		int size = session.createSQLQuery("SELECT * FROM products").list().size();
		session.close();
		return size;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Session session = Connect.getSessionFactory().openSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
		session.close();
		return products;
	}
	
	@Override
	public Product get(Integer id) {
		Session session = Connect.getSessionFactory().openSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id)
				.addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}

	@Override
	public Product get(String productname) {
		Session session = Connect.getSessionFactory().openSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where prodname = '" + productname + "'")
				.addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}
}
