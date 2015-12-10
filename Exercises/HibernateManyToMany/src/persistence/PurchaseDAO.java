package persistence;

import java.util.Date;

public interface PurchaseDAO {
	public void create(Purchase p);

	public Purchase get(Integer id);

	//public void update(Purchase p);

	public void delete(Purchase p);
	
	public int numberOfPurchasesForDate(Date d);
	
	public Date dayOfMaxPurchases();
}
