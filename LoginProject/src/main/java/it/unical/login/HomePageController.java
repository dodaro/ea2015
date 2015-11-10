package it.unical.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomePageController {

	private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/userHomePage", method = RequestMethod.GET)
	public String other(HttpServletRequest request, Model model) {
		logger.info("Welcome home!");

		String userSes = (String) request.getSession().getAttribute("userSession");
		if (userSes == null)
			return "redirect:login";
		model.addAttribute("user", userSes);
		return "userHomePage";
	}

}