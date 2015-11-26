package persistenceDAO;

import java.util.List;

import persistenceDTO.Product;
import persistenceDTO.Store;

public interface StoreDAO {
	
	public void create(Store st);

	public Store get(Integer id);

	public void update(Store st);

	public void delete(Store st);

	public int numberOfStores();

	public List<Store> getStores();
	
	public List<Store> getStoreForCity(String city);
	
	public List<Product> getStoreProducts(Integer idStore);
	

}
