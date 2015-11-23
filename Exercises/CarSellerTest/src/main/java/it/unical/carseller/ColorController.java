package it.unical.carseller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.CarsChooser;
import it.unical.carseller.model.ColorsChooser;
import it.unical.carseller.model.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ColorController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(ColorController.class);
	
	
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String colorControllerGet(Model model) {
		logger.info("StartGet Color");	
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String colorControllerPost(@ModelAttribute("carIndex") Response res, Model model) {	
		logger.info("Start Post Color");
		CarsChooser cars = context.getBean("carsChooser", CarsChooser.class);
		ColorsChooser colors = context.getBean("colorsChooser", ColorsChooser.class);
		cars.setMyCar(res.getResponse());
		model.addAttribute("colors", colors);
		model.addAttribute("colorIndex", context.getBean("response", Response.class));
		return "color";
	}
	
}





