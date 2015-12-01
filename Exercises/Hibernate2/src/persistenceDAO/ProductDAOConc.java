package persistenceDAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import persistenceDTO.Product;
import persistenceDTO.Purchase;

public class ProductDAOConc extends AbstractDAO{
	
	public ProductDAOConc() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	public void createProduct(Product prod) {
		create(prod);
		//observer invoke
	}

	public void updateProduct(Product prod) {
		update(prod);
		//observer invoke

	}

	public void deleteProduct(Product prod) {
		delete(prod);
		//observer invoke

	}
	
	public Product get(Integer id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		String queryString = "from Product where id = :id_product";
		Query query = session.createQuery(queryString);
		query.setParameter("id_product", id);
		Product product = (Product) query.uniqueResult();
		if (product != null) {
			for (Purchase p : product.getPurchase()) {
					 Hibernate.initialize(p);
			 	}
			}
		
		session.close();
		return product;
	}

	public int numberOfProducts() {
		// TODO Auto-generated method stub
		Session session = getSession();
		String queryString = "from Product";
		Query query = session.createQuery(queryString);
		int size = query.list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		String queryString = "from Product";
		Query query = session.createQuery(queryString);
		List<Product> products = (List<Product>) query.list();
		if(products!=null){
			for (Product p : products) {
				p.getPurchase().size();
			}
		}
		
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsForCategory(String category) {
		Session session = getSession();
		
		String queryString = "from Product where category = :category_product";
		Query query = session.createQuery(queryString);
		query.setParameter("category_product", category);
		List<Product> products = (List<Product>) query.list();
		if(products!=null){
			for (Product p : products) {
				p.getPurchase().size();
			}
		}
		
		session.close();
		return products;
		
	}
}
