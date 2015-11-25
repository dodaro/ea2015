package DAOInterfaces;

import java.util.List;

import persistence.Product;

public interface ProductDAOInterface
{
	public void create(Product product);

	public Product get(Integer id);

	public void update(Product product);

	public void delete(Product product);

	public int numberOfProducts();

	public List<Product> getProducts();
}