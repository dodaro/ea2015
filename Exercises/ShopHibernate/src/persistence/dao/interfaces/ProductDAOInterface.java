package persistence.dao.interfaces;

import java.util.List;

import persistence.data.Product;


public interface ProductDAOInterface {

	public void create(Product product);
	public void update(Product product);
	public void delete(Product product);
	
	public List<Product> getAllProducts();
	
}
