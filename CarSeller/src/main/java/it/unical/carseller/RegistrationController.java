package it.unical.carseller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carseller.model.User;
import it.unical.carseller.model.dao.UserDao;

@Controller
public class RegistrationController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	//Order of BindingResult matters (it must be just after ModelAttribute)
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String executeOperation(@Valid @ModelAttribute("userForm") User user, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "registration";
		}
		
		UserDao userDao = (UserDao) context.getBean("userDao");
		if (userDao.exists(user.getUsername())) {
			model.addAttribute("error", "Username is already used");
			return "registration";
		} else {
			userDao.create(user);
			return "redirect:/";
		}
	}
}
