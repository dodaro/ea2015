package persistence.store;

import java.util.List;

import persistence.product.Product;


public interface StoreDAO {

	//read
	public Store find(long id);
	public List<Product> getProducts(long storeId);
	
	//creation
	public void create(Store store);
	
	//update
	public void update(Store store);
	
	//delete
	public void delete(Store user);
	
	
}
