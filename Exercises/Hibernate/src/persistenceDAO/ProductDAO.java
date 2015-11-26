package persistenceDAO;

import java.util.List;

import persistenceDTO.Product;

public interface ProductDAO {
	
	public void create(Product prod);

	public Product get(Integer id);
	
	public Integer getStoreMembership(Integer id);

	public void update(Product prod);

	public void delete(Product prod);

	public int numberOfProducts();

	public List<Product> getProducts();
	
	public List<Product> getProductsForCategory(String category);

}
