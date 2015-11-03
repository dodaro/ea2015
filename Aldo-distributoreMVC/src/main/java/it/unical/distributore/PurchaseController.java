package it.unical.distributore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.distributore.model.Calculator;
import it.unical.distributore.model.Distributore;
import it.unical.distributore.model.Purchase;



@Controller
public class PurchaseController {

	@Autowired
	private ApplicationContext appContext;
	private Distributore distributore;

	private String message = "";
	
	
	/**
	 * Initializes model values and return the corresponding jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initPage(HttpServletRequest request, Model model) {

		distributore = appContext.getBean("Distributore",Distributore.class);
		model.addAttribute("Distributore", distributore); 

		model.addAttribute("Purchase", new Purchase());
		model.addAttribute("message",message);

		request.getSession().setAttribute("coins", 0);
		
		return "home";
	}

	/*
	 * computes the import and sets the corresponding message
	 */
	@RequestMapping(value="/buy", method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request, Model model, Purchase purchase,
			BindingResult result) {
		
		//model parameter are re-added to display correctly the same jsp
		distributore = appContext.getBean("Distributore",Distributore.class);
		model.addAttribute("Distributore", distributore); 
		model.addAttribute("Purchase", purchase);

		//coins insert by the user are added to the previous import
		int coins = (Integer) request.getSession().getAttribute("coins");
		coins += purchase.getCoins();
		request.getSession().setAttribute("coins", coins);
		
		
		//I like this unuseful stuff
		Calculator calc = appContext.getBean("Calculator", Calculator.class);
		for (Integer product : purchase.getSelected()) {

			calc.add(distributore.getProducts().get(product).getPrice());
		}

		double total = calc.sum() - coins;

		if(total < 0){
			message = "Non dà resto!";
			reset(request.getSession(), purchase);
			
		}
		else if(total == 0){
			message = "Ecco i suoi prodotti";
			reset(request.getSession(), purchase);
		}
		else
			message = "Inserire ancora " + total;
		
		
		model.addAttribute("message",message);
		
		return "home";
	}
	
	private void reset(HttpSession session, Purchase purchase){
		
		session.setAttribute("coins", 0);
		purchase.setSelected(new int[10]);
		
	}

}
