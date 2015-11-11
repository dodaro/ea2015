package it.unical.dealer;

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
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @ModelAttribute("dealerForm") DealerMachine machine) {
		logger.info("Welcome to the new Dealer Machine 2.0!!!.", locale);
		DealerMachine mach = (DealerMachine) context.getBean("d");
		model.addAttribute("machine", mach);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(HttpServletRequest request, @ModelAttribute("dealerForm") DealerMachine machine, Model model) {
		String str = machine.purchase();
		model.addAttribute("message", str);
		DealerMachine mach = (DealerMachine) context.getBean("d");
		model.addAttribute("machine", mach);
		return "home";
	}
}
