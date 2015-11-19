package it.unical.carseller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.Car;
import it.unical.carseller.model.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	List<Car> carsList;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("StartGet Home");	
		carsList = new ArrayList<Car>();
		carsList.add(context.getBean("model1", Car.class));
		carsList.add(context.getBean("model2", Car.class));
		carsList.add(context.getBean("model3", Car.class));
		model.addAttribute("carsList", carsList);
		model.addAttribute("response", new Response());
		
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String resultForm(HttpServletRequest request, @ModelAttribute("response") Response res, Model model) {
		String carNameLocal = res.getModelChoosed();
		logger.info("inizioResult " + carNameLocal);
		for(Car c : carsList){
			if (c.getModel().equals(carNameLocal))
				res.setPriceChoosed(c.getPrice());
		}
		
		logger.info("Fine ResultModel: Local " + carNameLocal);
		logger.info("Fine ResultModel: session " + res.getModelChoosed());
		logger.info("Fine ResultModel: session " + res.getPriceChoosed());
		
		if (res.getModelChoosed() == null)
			return "redirect:/";
		
		request.getSession().setAttribute("userSession", res);
		
		return "redirect:color";
	}
	
}





