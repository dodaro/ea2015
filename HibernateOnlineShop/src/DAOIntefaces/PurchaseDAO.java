package DAOIntefaces;

import java.util.Date;
import java.util.List;

import persistence.Purchase;
import persistence.User;

public interface PurchaseDAO
{
	public void create(Purchase purchase);

	public Purchase get(Integer id);

	public void delete(Purchase purchase);

	public int numberOfPurchases();

	public List<Purchase> getPurchases(User user);
	
	public List<Purchase> getPurchases(Date date);
	
	public Date getDateWithGreatestNumberOfPurchase();
}