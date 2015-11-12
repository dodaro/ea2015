package com.aloisius.springShop;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.aloisius.springShop.model.Helper;
import com.aloisius.springShop.model.Product;
import com.aloisius.springShop.model.ProductsList;
import com.aloisius.springShop.model.User;

@Controller
public class EaProductSelectController {
	private static final Logger logger = LoggerFactory.getLogger(EaProductSelectController.class);

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return doGet(request, model);
	}

	@RequestMapping(value = "/eaProductSelect", method = RequestMethod.GET)
	public String homeFullName(HttpServletRequest request, Model model) {
		return doGet(request, model);
	}

	private String doGet(HttpServletRequest request, Model model) {
		logger.info("Product select get");

		if(Helper.checkUserSession(request, model)){
			Helper.setUserSession(request, model);
		}

		ProductsList list = (ProductsList) context.getBean("productsList");		
		list.setProducts(Helper.getLoadedProducts());		
		model.addAttribute("productsList", list);

		return "eaProductSelect";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String productSelect(
			HttpServletRequest request,
			@RequestParam(value = "nameProduct", required = true) String nameProduct,
			Model model) {
		logger.info("Product select post");

		Product product = Helper.getProductByName(nameProduct);
		model.addAttribute("selectedProduct", product);	

		User user = Helper.getUserLogged(request, model);
		user.setProductSelected(new Product(product));
		
		Helper.setUserSession(request, model, user);

		return "redirect:eaColorSelect";
	}	
}
