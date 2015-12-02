package persistence;

import java.util.List;

public interface ProductDAO {
	public void create(Product product) throws Exception;
	
	public void update(Product product) throws Exception;

	public void delete(Product product) throws Exception;

	public Product get(Integer id);

	public Product get(String name);

	public int numberOfProducts();

	public List<Product> getProducts();
	
	public List<Product> getProductsWithPriceGreaterThan(Float price);

	public List<Product> getProductsWithPriceLessThan(Float price);
}
