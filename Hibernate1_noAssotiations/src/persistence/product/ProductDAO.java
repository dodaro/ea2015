package persistence.product;

import java.util.List;

public interface ProductDAO {

	//read
	public Product find(long id);
	public long getStore(long storeId);
	public List<Product> findAll();
	
	//creation
	public void create(Product product);
	
	//update
	public void updateProduct(Product product);
	
	//delete
	public void delete(Product user);
	
	
}
