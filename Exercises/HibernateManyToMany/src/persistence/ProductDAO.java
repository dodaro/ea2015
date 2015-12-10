package persistence;

import java.util.List;

public interface ProductDAO {
	public void create(Product product);

	public Product get(Integer id);

	public Product get(String productname);

	public void update(Product product);

	public void delete(Product product);

	public int numberOfProducts();

	public List<Product> getProducts();
}
