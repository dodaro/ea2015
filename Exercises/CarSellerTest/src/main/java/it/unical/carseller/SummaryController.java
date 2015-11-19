package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.carseller.model.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SummaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(SummaryController.class);
	
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String summaryFinal(HttpServletRequest request, Model model) {
		logger.info("Start Summary");	
		Response resLocal = (Response)request.getSession().getAttribute("userSession");
		model.addAttribute("model", resLocal.getModelChoosed());
		model.addAttribute("color", resLocal.getColorChoosed());
		model.addAttribute("price", resLocal.getPriceChoosed());
		return "summary";
	}
	
	
}





