package persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.ProductDAO;
import persistence.dao.PurchaseDAO;
import persistence.dao.SinglePurchaseDAO;
import persistence.dao.UserDAO;
import persistence.data.Product;
import persistence.data.Purchase;
import persistence.data.SinglePurchase;
import persistence.data.User;

public class Main {

	static UserDAO userDAO;
	static PurchaseDAO purchaseDAO;
	static ProductDAO productDAO;
	static SinglePurchaseDAO singlePurchaseDAO;
	
	static List<User> users;
	static List<Purchase> purchases;
	static List<Product> products;
	static List<SinglePurchase> singlePurchases;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 	
	public static void init() {
		
		userDAO = new UserDAO();
		purchaseDAO = new PurchaseDAO();
		productDAO = new ProductDAO();
		singlePurchaseDAO = new SinglePurchaseDAO();
		
		users = new ArrayList<>();
		purchases = new ArrayList<>();
		products = new ArrayList<>();
		singlePurchases = new ArrayList<>();
		
		try {
			initDB();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void initDB() throws ParseException {
		
		for (int i = 0; i < 10; i++) {
			User u = new User("username" + i, "password" + i);
			users.add(u);
			userDAO.create(u);
		}
		
		for (int i = 0; i < 10; i++) {
			Product product = new Product("product" + i, 2*i);
			products.add(product);
			productDAO.create(product);
		}
		
		int day = 1;
		for (int i = 0; i < 10; i++) {
			Purchase purchase = new Purchase(sdf.parse(day +"/12/2015"), users.get(i));
			purchases.add(purchase);
			purchaseDAO.create(purchase);
			day++;
		}
		
		//other purchase for test last query
		Purchase purchase = new Purchase(sdf.parse("1/12/2015"), users.get(0));
		purchaseDAO.create(purchase);
		purchases.add(purchase);
		
		for (int i = 0; i < 10; i++) {
			SinglePurchase singlePurchase = new SinglePurchase(products.get(i), purchases.get(i));
			singlePurchases.add(singlePurchase);
			singlePurchaseDAO.create(singlePurchase);
		}
		
		
		
		//other single purchase for test last query
		SinglePurchase singlePurchase = new SinglePurchase(products.get(0), purchases.get(purchases.size()-1));
		singlePurchaseDAO.create(singlePurchase);
		singlePurchases.add(singlePurchase);
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		
		init();
		
		System.out.println("-----------START TEST-------------------");
		//System.out.println(userDAO.getAllUsers());
		//System.out.println(purchaseDAO.getAllPurchases());
		//System.out.println(userDAO.getUserPurchases(users.get(1)));
		//System.out.println(productDAO.getAllProducts());
		//System.out.println(singlePurchaseDAO.getAllSinglePurchase());
		System.out.println(userDAO.getUserPurchaseProducts(users.get(0)));
		//System.out.println(purchaseDAO.getAllPurchaseInDate(sdf.parse("1/12/2015")));
		//System.out.println(purchaseDAO.getNumberOfPurchaseInDate(sdf.parse("1/12/2015")));
		//System.out.println(purchaseDAO.getDateOfMaxPurchase());
		
		
	}
	
}
