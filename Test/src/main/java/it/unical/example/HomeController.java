package it.unical.example;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.example.model.Choice;
import it.unical.example.model.Product;
import it.unical.example.model.Store;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ApplicationContext appContext;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {

		List<Product> products =  appContext.getBean("Store",Store.class).getProducts();
		model.addAttribute("products", products);
		model.addAttribute("Choice", new Choice());
		model.addAttribute("productSelected","");



		return "home";
	}

	@RequestMapping(value = "/firstPage", method = RequestMethod.POST)
	public String firstPage(HttpServletRequest request, Model model, Choice choice) {

		List<Product> products =  appContext.getBean("Store",Store.class).getProducts();

		model.addAttribute("products", products);
		model.addAttribute("Choice", new Choice());

		model.addAttribute("productSelected", choice.getChoice());
		model.addAttribute("priceSelected", choice.getPrice());

		return choice.getChoice();
	}

	@RequestMapping(value = "/firstPageColor", method = RequestMethod.POST)
	public String secondPage(HttpServletRequest request, Model model, Choice choice) {

		List<Product> products =  appContext.getBean("Store",Store.class).getColors();

		model.addAttribute("products", products);
		model.addAttribute("Choice", new Choice());

		model.addAttribute("productSelected", choice.getChoice());
		model.addAttribute("priceSelected", choice.getPrice());

		model.addAttribute("color", choice.getChoice());
		return choice.getChoice();

	}

	@RequestMapping(value = "/secondPage", method = RequestMethod.POST)
	public String secondPageColor(HttpServletRequest request, Model model, Choice choice) {

		if(choice.getChoice().equals(""))
			return "notfound";

		request.getSession().setAttribute("model", choice.getChoice());
		request.getSession().setAttribute("price", choice.getPrice());

		List<Product> products =  appContext.getBean("Store",Store.class).getColors();

		model.addAttribute("products", products);
		model.addAttribute("Choice", new Choice());

		model.addAttribute("productSelected", choice.getChoice());

		return "color";

	}

	@RequestMapping(value = "/summary", method = RequestMethod.POST)
	public String summary(HttpServletRequest request, Model model, Choice choice) {

		if(choice.getChoice().equals(""))
			return "notfound";
		
		model.addAttribute("type", request.getSession().getAttribute("model"));
		model.addAttribute("color", choice.getChoice());

		int price = (Integer)request.getSession().getAttribute("price");
		int total = price + (Integer) choice.getPrice();
		model.addAttribute("total", total);

		return "summary";
	}
}
