package com.alessandrocozza.springtest;

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

import com.alessandrocozza.model.ApplicationController;
import com.alessandrocozza.model.User;

@Controller
public class ColorController
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	@Autowired
	private WebApplicationContext context;
	
	private User old;
	
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model)
	{
		old = (User) request.getSession().getAttribute("userSession");
		if(old == null)
			return "redirect:/";
		logger.info("Car selected " + old.getCarSelected());	
		
		ApplicationController ac = (ApplicationController) context.getBean("ApplicationController");
		model.addAttribute("colorsList", ac.getColors());
		model.addAttribute("user", old);
		return "color";
	}
	
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String colorForm(HttpServletRequest request, @ModelAttribute("user") User user, Model model)
	{
		logger.info("Color selected " + user.getColorSelected());
		logger.info("Car selected " + old.getCarSelected());
		old.setColorSelected(user.getColorSelected());
		if (user.getColorSelected() == null)
		{
			return "redirect:/";
		}
		else
		{
			request.getSession().setAttribute("userSession", old);
			return "redirect:/result";
		}
	}
}
