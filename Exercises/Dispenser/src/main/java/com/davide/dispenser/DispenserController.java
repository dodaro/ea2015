package com.davide.dispenser;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.davide.dispenser.model.Dispenser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DispenserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private WebApplicationContext context;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@RequestMapping(value = "/dispenser", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Ti ho portato qui!", locale);
		model.addAttribute("dispenserAction", context.getBean("dispenser"));

		return "dispenser";
	}
	
	@RequestMapping(value = "/dispenser", method = RequestMethod.POST)
	public String executeOperation(@RequestParam double money, @ModelAttribute("dispenserAction") Dispenser dispenser,
			Model model) {
		
		Dispenser newDisp=(Dispenser) context.getBean("dispenser");
		
		logger.info("ID: "+dispenser.getIdSelect());
		logger.info("Missing: "+dispenser.getMissing());
		logger.info("Inseriti: "+money);
		logger.info("Resto: "+dispenser.getRemainder());
		
		newDisp.setIdSelect(dispenser.getIdSelect());
		newDisp.setMissing(dispenser.getMissing());
		newDisp.insert(money);
		
		newDisp.supplies();
		
		if(newDisp.isStateSelection()){
			model.addAttribute("remainder",newDisp.getRemainder());
			return "bridge";			
		}
		
		model.addAttribute("dispenserAction", newDisp);
		model.addAttribute("missing",newDisp.getMissing());
		model.addAttribute("inserted", newDisp.getMoneyOnMachine());
		
		
		return "dispenser";
	}
	
}
