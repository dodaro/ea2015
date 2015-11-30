package persistence.product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import persistence.user.User;
import persistence.utils.DBHandler;


public class ConcreteProductDAO implements ProductDAO{

	
	public ConcreteProductDAO() {
	}
	
	@Override
	public Product find(long id) {
		
		Session session = DBHandler.getSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class)
				.uniqueResult();
		session.close();
		return product;
	}

	@Override
	public List<Product> getProducts() {
		
		Session session = DBHandler.getSession();
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
		session.close();
		return products;
	}
	
}
