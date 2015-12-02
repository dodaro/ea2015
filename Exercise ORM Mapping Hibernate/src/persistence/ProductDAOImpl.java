package persistence;

import java.util.List;

import org.hibernate.Query;
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
		//		Session session = DBManager.getSession();
		//		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id = " + id).addEntity(Product.class).uniqueResult();
		//		session.close();		
		Session session = DBManager.getSession();
		String queryString = "from products where id = :id_product";
		Query query = session.createQuery(queryString);
		query.setParameter("id_product", id);
		Product product = (Product) query.uniqueResult();
		session.close();		
		return product;
	}

	public Product get(String name) {
		//		Session session = DBManager.getSession();
		//		Product product = (Product) session.createSQLQuery("SELECT * FROM products where name = '" + name + "'").addEntity(Product.class).uniqueResult();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from products where name = :name_product";
		Query query = session.createQuery(queryString);
		query.setParameter("name_product", name);
		Product product = (Product) query.uniqueResult();
		session.close();
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsWithPriceGreaterThan(Float price) {
		//		Session session = DBManager.getSession();
		//		List<Product> products = (List<Product>) session.createSQLQuery("from products p where p.price > " +price).list();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from products p where p.price > :price_product";
		Query query = session.createQuery(queryString);
		query.setParameter("price_product", price);
		List<Product> products = (List<Product>) query.list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsWithPriceLessThan(Float price) {
		//		Session session = DBManager.getSession();
		//		List<Product> products = (List<Product>) session.createSQLQuery("from products p where p.price < " +price).list();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from products p where p.price < :price_product";
		Query query = session.createQuery(queryString);
		query.setParameter("price_product", price);
		List<Product> products = (List<Product>) query.list();
		session.close();
		return products;
	}
}
