package it.unical.cartest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.cartest.model.Dealership;
import it.unical.cartest.model.Selection;

@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired ApplicationContext ac;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Dealership dealership = (Dealership) ac.getBean("Dealership");
		model.addAttribute("dealership", dealership.getCars().values());
		model.addAttribute("selection", (Selection) ac.getBean("Selection"));
		
		return "home";
	}
	
}
