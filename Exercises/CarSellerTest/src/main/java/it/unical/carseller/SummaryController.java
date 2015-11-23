package it.unical.carseller;

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
import it.unical.carseller.model.CarsChooser;
import it.unical.carseller.model.Color;
import it.unical.carseller.model.ColorsChooser;
import it.unical.carseller.model.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SummaryController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(SummaryController.class);
	
	
	@RequestMapping(value = "/summary", method = RequestMethod.POST)
	public String summaryFinal(@ModelAttribute("colorIndex") Response res, Model model) {
		logger.info("Start post Summary");
		CarsChooser cars = context.getBean("carsChooser", CarsChooser.class);
		ColorsChooser colors = context.getBean("colorsChooser", ColorsChooser.class);
		colors.setMyColor(res.getResponse());
		logger.info("Summary index car choosed " + cars.getMyCar());
		logger.info("Summary index color choosed " + colors.getMyColor());
		Car choosedCar = cars.getCarMap().get(cars.getMyCar());
		Color choosedColor = colors.getColorMap().get(colors.getMyColor());
		
		model.addAttribute("model", choosedCar.getModel());
		model.addAttribute("color", choosedColor.getName());
		model.addAttribute("price", (choosedCar.getPrice()+choosedColor.getPrice()));
		return "summary";
	}
	
	
}





