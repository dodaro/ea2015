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
import it.fmaida.model.Color;
import it.fmaida.model.SimpleCar;
import it.fmaida.model.UserChoice;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReviewController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	WebApplicationContext context;

	/**
	 * I DON'T WANT TO HANDLE GET HERE -> REDIRECT TO HOME
	 */
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String color(Locale locale, Model model,HttpServletRequest request,@RequestParam String carmodel) {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public String handleReview(Locale locale, Model model,HttpServletRequest request,UserChoice userChoice) {
		
		UserChoice choiceFromSession = (UserChoice) request.getSession().getAttribute("userOrder");
		
		if ( choiceFromSession == null ) {
			return "redirect:/";
		}
		
		String color = userChoice.getColor();
		logger.info(color);
		
		int newTotalPrice = choiceFromSession.getTotalPrice();	
		
		AvailableColors colors = (AvailableColors) context.getBean("colorsList");
		Color currentColor = colors.findColorByName(color);
		if ( currentColor != null ) {
			newTotalPrice += currentColor.getPrice();
			choiceFromSession.setColor(color);
		}
		
		choiceFromSession.setTotalPrice(newTotalPrice);
		
		request.getSession().setAttribute("userOrder",choiceFromSession);
		model.addAttribute("userReview",choiceFromSession);
		logger.info(choiceFromSession.toString());
		
		return "review";
		
	}
	
	
}
