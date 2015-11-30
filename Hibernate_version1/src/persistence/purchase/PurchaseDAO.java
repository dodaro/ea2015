package persistence.purchase;

import java.util.Date;
import java.util.List;

import persistence.product.Product;
import persistence.user.User;


public interface PurchaseDAO {

	//read
	public Purchase find(long id);
	public List<Purchase> getPurchases();
	public List<Product> getProductsOfUser(User user);
	public List<Purchase> getPurchaseByDate(Date date);
	public Date getDateMaxNumSales();
}
