package persistence;

import java.util.List;

public interface ShopDAO {
	public void create(Shop shop);

	public Shop get(Integer id);

	public Shop get(String shopname);

	public void update(Shop shop);

	public void delete(Shop shop);

	public int numberOfShops();

	public List<Shop> getShops();
}
