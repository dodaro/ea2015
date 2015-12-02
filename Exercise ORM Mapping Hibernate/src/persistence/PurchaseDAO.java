package persistence;

import java.util.List;
import java.util.Date;

public interface PurchaseDAO {
	public void create(Purchase purchase) throws Exception;

	public void delete(Purchase purchase) throws Exception;

	public Purchase get(Integer id);

	public int numberOfPurchases();

	public List<Purchase> getPurchases();
	
	public List<Product> getProductBoughtByUser(User user);
	
	public List<Purchase> getPurchasesInDate(Date date);
	
	public Date getDateWithGreaterNumberOfPurchases();
}
