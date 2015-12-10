package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.Car;
import it.unical.carseller.model.Color;
import it.unical.carseller.model.dao.CarDao;

@Controller
public class ColorController {
	
	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		if (!SessionHandler.existsUser(request.getSession()))
			return "redirect:/";
		model.addAttribute("selectColor", context.getBean("color"));
		CarDao carDao = (CarDao) context.getBean("carDao");
		model.addAttribute("allColors",carDao.getAllColors());
		return "color";
	}

	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String executeOperation(@ModelAttribute("selectColor") Color color, Model model, HttpServletRequest request) {
		if(!SessionHandler.existsUser(request.getSession()))
			return "redirect:/";
		Car purchase = SessionHandler.getPurchase(request.getSession());
		purchase.setColor(color);
		return "redirect:/summary";
	}	
}
