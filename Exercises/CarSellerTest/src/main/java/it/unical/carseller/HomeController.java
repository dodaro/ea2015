package it.unical.carseller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.CarsChooser;
import it.unical.carseller.model.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("StartGet Home");	
		CarsChooser cars = context.getBean("carsChooser", CarsChooser.class);
		model.addAttribute("carIndex", context.getBean("response", Response.class));
		model.addAttribute("cars", cars);
		
		return "home";
	}
	
}





