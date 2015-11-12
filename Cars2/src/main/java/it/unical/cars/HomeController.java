package it.unical.cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.cars.model.Cars;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private WebApplicationContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome!");
		model.addAttribute("buy", context.getBean("coffeMachine"));
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String executeOperation(@ModelAttribute("buy") Cars cm, Model model) {
		Integer result = cm.computeChange();
		if(result < 0)
			model.addAttribute("result", "You need to add " + (-result) + " euro");
		else
			model.addAttribute("result", "Your change is " + result);
		return "home";
	}

}
