package it.unical.carSeller;

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

import it.unical.carSeller.model.Sell;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	WebApplicationContext context;

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @ModelAttribute("sellerForm") Sell sell) {
		model.addAttribute("sell",context.getBean("Sell"));
		return "home";
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public String home(Model model, HttpServletRequest request,@ModelAttribute("sellerForm") Sell sell){		
		System.out.println(String.valueOf(sell.getCar()));
		request.getSession().setAttribute("car", sell.getCar());	
		return "redirect:/color";
	}
	
}
