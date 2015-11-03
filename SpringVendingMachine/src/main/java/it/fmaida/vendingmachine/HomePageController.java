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
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("vendingMachineForm",machine);
		
		return "vendingmachine";
	}
	
	@RequestMapping(value = "/vendingmachine", method = RequestMethod.POST)
	public String getPayment(
			@RequestParam(value = "Coffee", required = false) Integer coffeeItem,
			@RequestParam(value = "Water", required = false) Integer waterItem,
			@RequestParam(value = "Tea", required = false) Integer teaItem,
			@RequestParam(value = "Juice", required = false) Integer juiceItem,
			@RequestParam(value = "Vodka", required = false) Integer vodkaItem,
			@RequestParam(value = "Beer", required = false) Integer beerItem,
			@RequestParam(value = "amount", required = false) Integer amount,
			@ModelAttribute("vendingMachineForm") VendingMachine vendingMachine,Model model) {
		
		
			
		if ( amount == null ) {
			model.addAttribute("message","Non hai inserito l'importo!");
			return "vendingmachine";
		}
		
		if ( coffeeItem == null && waterItem == null && teaItem == null & juiceItem == null && vodkaItem == null && beerItem == null ) {
			model.addAttribute("message","Nessun prodotto selezionato.");
			return "vendingmachine";
		}
		
		int totalAmountToPay = 0;
		
		if ( coffeeItem != null ) {
			totalAmountToPay += coffeeItem.intValue();
		}
		if ( waterItem != null ) {
			totalAmountToPay += waterItem.intValue();
		}
		if ( teaItem != null ) {
			totalAmountToPay += teaItem.intValue();
		}
		if ( juiceItem != null ) {
			totalAmountToPay += juiceItem.intValue();
		}
		if ( vodkaItem != null ) {
			totalAmountToPay += vodkaItem.intValue();
		}
		if ( beerItem != null ) {
			totalAmountToPay += beerItem.intValue();
		}
		
		
		model.addAttribute("message",""+totalAmountToPay);
		
		if ( totalAmountToPay > amount.intValue()  ) {
			model.addAttribute("message","Prego inserire " + ( totalAmountToPay - amount.intValue() ) + " Euro");
		} else if ( totalAmountToPay < amount.intValue() ) {
			model.addAttribute("message","Il resto è di " + (amount.intValue() - totalAmountToPay ) + " Euro, Arrivederci e grazie!");
		} else {
			model.addAttribute("message","Arrivederci e grazie!");
		}
		
		
		
		
//		if (calc != null && calc.length() == 1)
//			model.addAttribute("result", calculator.execute(calc.charAt(0)));
		
		
	
		return "vendingmachine";
	}
	
}
