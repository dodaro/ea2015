package persistence.product;

import java.util.List;


public interface ProductDAO {

	//read
	public Product find(long id);
	public List<Product> getProducts();
}
