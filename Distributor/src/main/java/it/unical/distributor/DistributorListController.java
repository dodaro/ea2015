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
public class DistributorListController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private WebApplicationContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/distributorList", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome Distributor!");
		model.addAttribute("distributorListAction", context.getBean("listdistributor"));
		model.addAttribute("listdistributor", context.getBean("listdistributor"));
		model.addAttribute("message", "No products selected");
		return "distributorList";
	}

	@RequestMapping(value = "/distributorList", method = RequestMethod.POST)
	public String buyOperation(
			@RequestParam(value = "product", required = false) String[] priceProducts,
			@RequestParam(value = "credit", required = false) String credit,			
			@ModelAttribute("distributorListAction") Distributor distributor,
			Model model) {
		model.addAttribute("distributorListAction", context.getBean("listdistributor"));
		model.addAttribute("listdistributor", context.getBean("listdistributor"));

		if(credit == null || credit.equals("")){
			model.addAttribute("message", "No money inserted!");
			return "distributorList";
		}
		
		logger.info("Products selected: "+priceProducts.length);
		
		if(priceProducts.length==0){
			model.addAttribute("message", "No products selected!");
			return "distributorList";
		}
		
		StringBuilder allPricesString = new StringBuilder("All prices:");

		for (String singlePrice : priceProducts) {
			allPricesString.append(" "+singlePrice);
		}

		logger.info(allPricesString.toString());

		float total = 0.0f;
		float userCredit = Float.parseFloat(credit);

		for (String singlePrice : priceProducts) {
			total += Float.parseFloat(singlePrice);
		}


		if(userCredit < total){
			model.addAttribute("message", "You have to add "+(total-userCredit));			
		} else {
			model.addAttribute("message", "Enjoy your products");			
		}

		return "distributorList";
	}

}