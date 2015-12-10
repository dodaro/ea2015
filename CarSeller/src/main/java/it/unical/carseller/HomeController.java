package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.CarModel;
import it.unical.carseller.model.dao.CarDao;

@Controller
public class HomeController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		if (!SessionHandler.existsUser(request.getSession()))
			return "redirect:/";
		model.addAttribute("selectModel", context.getBean("model"));
		CarDao carDao = (CarDao) context.getBean("carDao");
		model.addAttribute("allCarModels", carDao.getAllCarModels());
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String executeOperation(@ModelAttribute("selectModel") CarModel carModel, Model model,
			HttpServletRequest request) {
		if (!SessionHandler.existsUser(request.getSession()))
			return "redirect:/";
		SessionHandler.getPurchase(request.getSession()).setCarModel(carModel);
		return "redirect:/color";
	}
}
