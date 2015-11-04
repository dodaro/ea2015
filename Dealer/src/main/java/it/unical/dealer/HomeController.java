package it.unical.dealer;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.dealer.model.DealerMachine;
import it.unical.dealer.model.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,@ModelAttribute("dealerForm") DealerMachine machine) {
		logger.info("Welcome to the new Dealer Machine 2.0!!!.", locale);
		model.addAttribute("machine", new DealerMachine());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(HttpServletRequest request, @ModelAttribute("dealerForm") DealerMachine machine, Model model) {
		System.out.println(machine.purchase());
		model.addAttribute("message",machine.purchase());
		return "home";
	}
}
