package persistence;

import java.util.List;

public interface ProductDAO {

	public void create(Product product);

	public void update(Product product);

	public void delete(Product product);

	public List<Product> getProducts();
	
	public Product getProductById(int code);
}
