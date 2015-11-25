package com.aloisius.springShop.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.ui.Model;

public class Helper {
	private static Helper instance = null;
	private SAXBuilder saxBuilder = null;
	private ArrayList<Product> loadedProducts = null;
	private ArrayList<ProductColor> loadedProductsColor = null;

	private static String pathToDbProducts = "./src/main/webapp/resources/db_products.xml";
	private static String pathToDbProductsColor = "./src/main/webapp/resources/db_productsColor.xml";
	Document productsDocument = null;
	Document productsColorDocument = null;
	Document usersDocument = null;

	private Helper () {
		saxBuilder = new SAXBuilder();
		
		try {
			productsDocument = saxBuilder.build(pathToDbProducts);
			productsColorDocument = saxBuilder.build(pathToDbProductsColor);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Helper getInstance(){
		if(instance == null){
			instance = new Helper();
		}
		return instance;
	}

	public static ArrayList<Product> getLoadedProducts(){
		if(getInstance().loadedProducts == null){
			getInstance().loadedProducts = loadProducts();
		}
		return getInstance().loadedProducts;
	}

	public static ArrayList<Product> loadProducts(){
		ArrayList<Product> productsList = new ArrayList<Product>();

		Element rootElement = Helper.getInstance().productsDocument.getRootElement();

		List<Element> children = rootElement.getChildren();
		Iterator<Element> iterator = children.iterator();
		while(iterator.hasNext()){
			Element next = iterator.next();

			productsList.add(new Product(
					next.getChildText("name"),
//					next.getChildText("imagePath"),
					next.getChildText("description"),
					Float.parseFloat(next.getChildText("price"))
					));
		}

		return productsList;
	}
	
	public static ArrayList<ProductColor> getLoadedProductsColor(){
		if(getInstance().loadedProductsColor == null){
			getInstance().loadedProductsColor = loadProductsColor();
		}
		return getInstance().loadedProductsColor;
	}
	
	public static ArrayList<ProductColor> loadProductsColor(){
		ArrayList<ProductColor> productsColorList = new ArrayList<ProductColor>();

		Element rootElement = Helper.getInstance().productsColorDocument.getRootElement();

		List<Element> children = rootElement.getChildren();
		Iterator<Element> iterator = children.iterator();
		while(iterator.hasNext()){
			Element next = iterator.next();

			productsColorList.add(new ProductColor(
					next.getChildText("name"),
					next.getChildText("imagePath"),
					Float.parseFloat(next.getChildText("price"))
					));
		}

		return productsColorList;
	}
	
	public static Product getProductByName(String name){
		ArrayList<Product> products = getLoadedProducts();

		Iterator<Product> iterator = products.iterator();
		while(iterator.hasNext()){
			Product next = iterator.next();
			if(name.contains(next.getName())){
				return next;
			}
		}

		return null;
	}
	
	public static ProductColor getProducColorByName(String name){
		ArrayList<ProductColor> productsColor = getLoadedProductsColor();

		Iterator<ProductColor> iterator = productsColor.iterator();
		while(iterator.hasNext()){
			ProductColor next = iterator.next();
			if(name.contains(next.getName())){
				return next;
			}
		}

		return null;
	}
	
	
	public static boolean checkUserSession(HttpServletRequest request, Model model){
		return request.getSession().getAttribute("userSession") == null;
	}
	
	public static void setUserSession(HttpServletRequest request, Model model){
		User newUser = new User("Nome del utente");
		model.addAttribute("userSession", newUser);
		request.getSession().setAttribute("userSession", newUser);
	}
	
	public static void setUserSession(HttpServletRequest request, Model model, User user){
		model.addAttribute("userSession", user);
		request.getSession().setAttribute("userSession", user);
	}
	
	public static User getUserLogged(HttpServletRequest request, Model model){
		if(checkUserSession(request, model)){
			setUserSession(request, model);
		}
		return (User) request.getSession().getAttribute("userSession");
	}

	public static void main(String[] args){
		System.out.println("Test: product list");
		ProductsList productsList = new ProductsList();
		productsList.setProducts(Helper.loadProducts());
		Iterator<Product> iterator = productsList.getProducts().iterator();
		while(iterator.hasNext()){
			Product next = iterator.next();
			System.out.println("Product:\t"+next.getName());
		}
		
		System.out.println("Test: color list");
		ProductsColorList colorList = new ProductsColorList();
		colorList.setProductsColor(Helper.loadProductsColor());
		Iterator<ProductColor> iteratorColor = colorList.getProductsColor().iterator();
		while(iteratorColor.hasNext()){
			ProductColor next = iteratorColor.next();
			System.out.println("Color:\t"+next.getName());
			System.out.println("Image:\t"+next.getImagePath());
			System.out.println("price:\t"+next.getPrice());
		}
	}
}
