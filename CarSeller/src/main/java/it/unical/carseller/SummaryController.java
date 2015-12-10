package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.CarModel;
import it.unical.carseller.model.Color;
import it.unical.carseller.model.dao.CarDao;

@Controller
public class SummaryController {
	@Autowired
	WebApplicationContext context;

	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		if(!SessionHandler.existsUser(request.getSession()))
			return "redirect:/"; 
		
		String carModelName = SessionHandler.getPurchase(request.getSession()).getCarModel().getName();
		String colorName = SessionHandler.getPurchase(request.getSession()).getColor().getName();
		
		CarDao carDao = (CarDao) context.getBean("carDao");
		CarModel carModel = carDao.getCarModel(carModelName);
		Color carColor = carDao.getColor(colorName);
		model.addAttribute("carModel", carModel);
		model.addAttribute("carColor", carColor);
	
		Double price = 0.0;		
		if(carModel != null)
			price += carModel.getPrice();
		if(carColor != null)
			price += carColor.getPrice();
		model.addAttribute("totalPrice",price);		
		return "summary";
	}
}
