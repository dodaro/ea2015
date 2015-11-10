package it.unical.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.login.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Welcome to the login page");
		model.addAttribute("userForm", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, @ModelAttribute("userForm") User user, Model model) {
		logger.info("Login");
		logger.info("Username " + user.getUsername());
		// you have to do something smarter!
		if (user.getUsername().equals("fool") && user.getPassword().equals("fool")) {
			request.getSession().setAttribute("userSession", user.getUsername());
			return "redirect:/userHomePage";
		} else {
			return "redirect:/login";
		}
	}
}
