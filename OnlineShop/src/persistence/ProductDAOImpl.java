package persistence;

import java.util.List;

import org.hibernate.Session;

public class ProductDAOImpl implements ProductDAO {

	private final static String SELECT = "SELECT * FROM products";
	private final static String SELECT_byId = "SELECT * FROM products where code = ";

	
	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create(Product product) {
		SessionManager.create(product);

	}

	@Override
	public void update(Product product) {
		SessionManager.update(product);
	}

	@Override
	public void delete(Product product) {
		SessionManager.delete(product);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Session session = SessionManager.getSession();
		List<Product> products = (List<Product>) session.createSQLQuery(SELECT).addEntity(Product.class).list();
		session.close();
		return products;
	}

	@Override
	public Product getProductById(int code) {
		Session session = SessionManager.getSession();
		Product product = (Product) session.createSQLQuery(SELECT_byId + code).addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}
}
