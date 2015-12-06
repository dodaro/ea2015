package hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.persistence.data.Product;

public class ProductDAO extends AbstractDAO {

	public ProductDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public void create(Product product) {
		performOperation(product, Operation.CREATE);
	}

	public void update(Product product) {
		performOperation(product, Operation.UPDATE);
	}

	public void delete(Product product) {
		performOperation(product, Operation.DELETE);
	}

	public Product get(Integer id) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session
				.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class)
				.uniqueResult();
		session.close();
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products")
				.addEntity(Product.class).list();
		session.close();
		return products;
	}
}
