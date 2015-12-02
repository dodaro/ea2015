package DAOImplementations;

import java.util.List;

import org.hibernate.Session;

import DAOIntefaces.ProductDAO;
import persistence.DBHandler;
import persistence.Product;

public class ProductDAOImpl implements ProductDAO
{
	public ProductDAOImpl()
	{}

	@Override
	public void create(Product product)
	{
		DBHandler.create(product);
	}

	@Override
	public Product get(Integer id)
	{
		Session session = DBHandler.getSession();
		Product product = (Product) session.createSQLQuery("SELECT * FROM products where id_product = " + id).addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}

	@Override
	public void update(Product product)
	{
		DBHandler.update(product);
	}

	@Override
	public void delete(Product product)
	{
		DBHandler.delete(product);
	}

	@Override
	public int numberOfProducts()
	{
		Session session = DBHandler.getSession();
		int size = session.createSQLQuery("SELECT * FROM products").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts()
	{
		Session session = DBHandler.getSession();
		List<Product> products = (List<Product>) session.createSQLQuery("SELECT * FROM products").addEntity(Product.class).list();
		session.close();
		return products;
	}

}
