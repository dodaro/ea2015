package it.unical.distributor;

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

import it.unical.distributor.model.Distributor;

@Controller
public class DistributorController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private WebApplicationContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/distributor", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome Distributor!");
		model.addAttribute("distributorAction", context.getBean("mydistributor"));
		model.addAttribute("mydistributor", context.getBean("mydistributor"));
		model.addAttribute("message", "No products selected");
		return "distributor";
	}

	@RequestMapping(value = "/distributor", method = RequestMethod.POST)
	public String buyOperation(
			@RequestParam(value = "product1", required = false) String product1,
			@RequestParam(value = "product2", required = false) String product2,
			@RequestParam(value = "product3", required = false) String product3,
			@RequestParam(value = "product4", required = false) String product4,
			@RequestParam(value = "credit", required = false) String credit,			
			@ModelAttribute("distributorAction") Distributor distributor,
			Model model) {
		model.addAttribute("distributorAction", context.getBean("mydistributor"));
		model.addAttribute("mydistributor", context.getBean("mydistributor"));
		
		if(credit == null || credit.equals("")){
			model.addAttribute("message", "No money inserted!");
			return "distributor";
		}
		
		if(product1.equals("") && product2.equals("") && product3.equals("") && product4.equals("") ){
			model.addAttribute("message", "No products selected!");
			return "distributor";
		}		
		
		logger.info("Parameters received " + product1 
			+ " " + product2  
			+ " " + product3
			+ " " + product4
			+ " " + credit);
		
		float total = 0.0f;
		float userCredit = Float.parseFloat(credit);
		
		if(product1 != null){
			total += Float.parseFloat(product1);
		}
		if(product2 != null){
			total += Float.parseFloat(product2);
		}
		if(product3 != null){
			total += Float.parseFloat(product3);
		}
		if(product4 != null){
			total += Float.parseFloat(product4);
		}
		
		if(userCredit < total){
			model.addAttribute("message", "You have to add "+(total-userCredit));			
		} else {
			model.addAttribute("message", "Enjoy your products");			
		}
		
		return "distributor";
	}

}