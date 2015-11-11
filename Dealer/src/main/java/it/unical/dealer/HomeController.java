package it.unical.dealer;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.dealer.model.DealerMachine;
import it.unical.dealer.model.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	WebApplicationContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@ModelAttribute("productList")
	ArrayList<Product> loadProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		list.add((Product) context.getBean("p1"));
		list.add((Product) context.getBean("p2"));
		list.add((Product) context.getBean("p3"));
		list.add((Product) context.getBean("p4"));
		list.add((Product) context.getBean("p5"));
		list.add((Product) context.getBean("p6"));
		list.add((Product) context.getBean("p7"));
		list.add((Product) context.getBean("p8"));
		return list;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @ModelAttribute("dealerForm") DealerMachine machine) {
		logger.info("Welcome to the new Dealer Machine 2.0!!!.", locale);
		model.addAttribute("machine", new DealerMachine());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(HttpServletRequest request, @ModelAttribute("dealerForm") DealerMachine machine, Model model) {
			String str = machine.purchase();
			model.addAttribute("message", str);
		return "home";
	}
}
