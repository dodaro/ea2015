package it.fmaida.hibernate.persistence;

import java.util.List;

public interface ItemDAO {

	public void createItem(Item item);
	
	public void delete(Item item);
	
	public void updateItem(Item item);
	
	public Item getItem(int id);
	
	public Item getItem(String name);
	
	public List<Item> getItemsByCategory(String category);
	
	public List<Item> getAllItems();
	
}
