package it.fmaida.carseller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import it.fmaida.model.AvailableColors;
import it.fmaida.model.CarInterface;
import it.fmaida.model.CarsList;
import it.fmaida.model.SimpleCar;
import it.fmaida.model.UserChoice;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ColorController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	WebApplicationContext context;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String color(Locale locale, Model model,HttpServletRequest request,UserChoice userChoice) {
		if ( userChoice == null || userChoice.getCar().length() <= 0 ) {
			return "redirect:/";
		}
		
		
		CarsList carsList = (CarsList) context.getBean("carsList");
		CarInterface carSelected =  carsList.findCarByName(userChoice.getCar());
		if ( carSelected == null ) {
			return "redirect:/";
		}
		
	
		int totalPrice = carSelected.getPrice();
		
		userChoice.setTotalPrice(userChoice.getTotalPrice() + totalPrice );
		
		logger.info(userChoice.toString());
		
		model.addAttribute("userOrder",userChoice);
		AvailableColors colors = (AvailableColors) context.getBean("colorsList");
		model.addAttribute("colors",colors.getColors());
		
		request.getSession().setAttribute("userOrder",userChoice);
		
		return "/color";
	}
	
}
