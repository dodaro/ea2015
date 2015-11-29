package persistence.dao;

import java.util.List;

import org.hibernate.Session;

import persistence.dao.interfaces.ProductDAOInterface;
import persistence.data.Product;
import persistence.handler.DBHandler;

public class ProductDAO implements ProductDAOInterface {

	@Override
	public void create(Product product) {
		DBHandler.create(product);
	}

	@Override
	public void update(Product product) {
		DBHandler.update(product);
	}

	@Override
	public void delete(Product product) {
		DBHandler.delete(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {

		Session session = DBHandler.getSession();
		List<Product> products = (List<Product>) session.createQuery("from Product").list();
		session.close();
		
		return products;
	}

}
