package it.fmaida.vendingmachine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import it.fmaida.vendingmachine.model.Item;
import it.fmaida.vendingmachine.model.UserOrder;
import it.fmaida.vendingmachine.model.VendingMachine;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomePageController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
	
	@Autowired
	private WebApplicationContext context;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/vendingmachine", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome VendingMachine!");
		VendingMachine machine= (VendingMachine) context.getBean("vendingmachine");
		
	
	
		UserOrder userOrder = new UserOrder();
		model.addAttribute("userOrderForm",userOrder);
		model.addAttribute("vendingMachineItems",machine);
		return "vendingmachine";
	}
	
	@RequestMapping(value = "/vendingmachine", method = RequestMethod.POST)
	public String getPayment(@ModelAttribute("userOrderForm") UserOrder userOrder,
							@RequestParam(value = "amount", required = false) Integer amount,Model model) {
		
		//Mi ha fatto bestemmiare un pomeriggio sano!!!
		model.addAttribute("vendingMachineItems",context.getBean("vendingmachine"));
		
	
		
		if ( amount == null || amount <= 0 ) {
			model.addAttribute("message","Importo non valido!");
			return "vendingmachine";
		}
		
		int totalSum = 0;
		
		if ( userOrder.getSelectedItems() == null ) {
			model.addAttribute("message","Nessuna scelta effettuata!");
			return "vendingmachine";
		}
		
		for ( Integer integer : userOrder.getSelectedItems() ) {
			totalSum += integer;
		}
		
		if ( amount > totalSum ) {
			model.addAttribute("message","Il suo resto è di " + (amount - totalSum) + " Euro! Grazie e arrivederci!");
		} else if ( amount < totalSum ) {
			model.addAttribute("message","Deve inserire ancora " + (totalSum - amount) + " Euro! Grazie.");
		} else if ( amount == totalSum ) {
			model.addAttribute("message","Grazie e arrivederci!");
		}
	
		return "vendingmachine";
	}
	
}
