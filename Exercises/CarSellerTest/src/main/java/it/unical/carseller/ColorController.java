package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.carseller.model.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ColorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ColorController.class);
	
	
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String colorControllerGet(Model model) {
		logger.info("StartGet Color");	
	
		model.addAttribute("userResponse", new Response());
		return "color";
	}
	
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String colorControllerPost(HttpServletRequest request, @ModelAttribute("userResponse") Response res, Model model) {
		Response resLocal = (Response)request.getSession().getAttribute("userSession");
		
		logger.info("Color Model: " + resLocal.getModelChoosed());
		logger.info("Color Price: " + resLocal.getPriceChoosed());
		resLocal.setColorChoosed(res.getColorChoosed()); 
		resLocal.setFinalPrice();
		logger.info("Color Final Price: " + resLocal.getPriceChoosed());
		
		return "redirect:summary";
	}
	
	
	
}





