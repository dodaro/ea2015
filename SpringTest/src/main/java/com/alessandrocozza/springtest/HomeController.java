package com.alessandrocozza.springtest;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.alessandrocozza.model.ApplicationController;
import com.alessandrocozza.model.User;

@Controller
public class HomeController{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		logger.info("Home page");
		
		ApplicationController ac = (ApplicationController) context.getBean("ApplicationController");
		model.addAttribute("carsList", ac.getCars());
		model.addAttribute("user", new User());
		
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String userForm(HttpServletRequest request, @ModelAttribute("user") User user, Model model)
	{
		logger.info("Car selected " + user.getCarSelected());
		if (user.getCarSelected() == null)
		{
			return "redirect:/";
		}
		else
		{
			request.getSession().setAttribute("userSession", user);
			return "redirect:/color";
		}
	}
}
