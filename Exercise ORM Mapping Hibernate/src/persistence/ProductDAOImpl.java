package persistence;

import java.util.List;

import org.hibernate.Session;

public class ProductDAOImpl implements ProductDAO {

	public ProductDAOImpl() {}

	public void create(Product product) throws Exception {
		DBManager.create(product);
	}

	public void update(Product product) throws Exception {
		DBManager.update(product);
	}

	public void delete(Product product) throws Exception {
		DBManager.delete(product);
	}

	public int numberOfProducts() {
		Session session = DBManager.getSession();
		int size = session.createSQLQuery("SELECT * FROM products").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		Session session = DBManager.getSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
		session.close();
		return products;
	}

	public Product get(Integer id) {
		Session session = DBManager.getSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}

	public Product get(String name) {
		Session session = DBManager.getSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where name = '" + name + "'").addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsWithPriceGreaterThan(Float price) {
		Session session = DBManager.getSession();
		List<Product> products = (List<Product>) session.createSQLQuery("from products p where p.price > " +price).list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsWithPriceLessThan(Float price) {
		Session session = DBManager.getSession();
		List<Product> products = (List<Product>) session.createSQLQuery("from products p where p.price z " +price).list();
		session.close();
		return products;
	}
}
