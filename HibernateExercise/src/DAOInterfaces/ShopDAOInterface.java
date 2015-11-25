package DAOInterfaces;

import java.util.List;

import persistence.Shop;

public interface ShopDAOInterface
{
	public void create(Shop shop);

	public Shop get(Integer id);
	
	public Shop get(String partitaIVA);

	public void update(Shop shop);

	public void delete(Shop shop);

	public int numberOfShops();

	public List<Shop> getShops();
}