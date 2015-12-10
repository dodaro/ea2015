package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import it.unical.carseller.model.CarModel;
import it.unical.carseller.model.Color;
import it.unical.carseller.model.User;
import it.unical.carseller.model.dao.CarDao;
import it.unical.carseller.model.dao.UserDao;

@Controller
public class IndexController {

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SessionLocaleResolver localeResolver;
	
	public void initDB() {
		//init of the db (just for the lazy ones)
		CarDao carDao = (CarDao) context.getBean("carDao");
		
		//if the DB has been created. Clearly this is NOT the correct solution.
		if(carDao.getCarModel("SE")!=null)
			return;
		carDao.create(new CarModel("SE", 11000.0,"se.html"));
		carDao.create(new CarModel("SEAL", 12400.0,"seal.html"));
		carDao.create(new CarModel("SL", 15000.0,"sl.html"));
		carDao.create(new Color("blue", 100.0,"karlblue.png"));
		carDao.create(new Color("red", 200.0,"karlred.png"));
		carDao.create(new Color("green", 300.0,"karlgreen.png"));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("userForm", new User());		
		initDB();
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") User user, Model model, HttpServletRequest request) {
		UserDao userDao = (UserDao) context.getBean("userDao");
		if (!userDao.exists(user.getUsername()) || !(userDao.retrieve(user.getUsername()).getPassword().equals(user.getPassword()))) {			
			model.addAttribute("error", messageSource.getMessage("message.invalid", null, localeResolver.resolveLocale(request)));			
			return "index";
		}
		request.getSession().setAttribute("user", user.getUsername());		
		return "redirect:/home";
	}
}
