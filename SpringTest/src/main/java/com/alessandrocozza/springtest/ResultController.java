package com.alessandrocozza.springtest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.alessandrocozza.model.ApplicationController;
import com.alessandrocozza.model.Car;
import com.alessandrocozza.model.Color;
import com.alessandrocozza.model.User;

@Controller
public class ResultController
{
	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model)
	{
		User user = (User) request.getSession().getAttribute("userSession");
		if (user == null)
			return "redirect:/";
		if (user.getCarSelected() == null)
			return "redirect:/";
		if (user.getColorSelected() == null)
		{
			model.addAttribute("user", user);
			return "redirect:/color";
		}
		model.addAttribute("user", user);	
		
		ApplicationController ac = (ApplicationController) context.getBean("ApplicationController");
		float carValue = 0;
		for (Car car : ac.getCars())
		{
			if(car.getModel().equals(user.getCarSelected()))
			{
				carValue = car.getValue();
				break;
			}
		} 
		float colorValue = 0;
		for (Color color : ac.getColors())
		{
			if(color.getName().equals(user.getColorSelected()))
			{
				colorValue = color.getValue();
				break;
			}
		} 
		model.addAttribute("carValue", carValue);
		model.addAttribute("colorValue", colorValue);
		model.addAttribute("total", carValue + colorValue);
		
		return "result";
	}
}
