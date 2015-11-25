package it.unical.carSeller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.carSeller.model.Sell;

@Controller
public class ColorController {

	@Autowired
	WebApplicationContext context;
	
	
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String color(Locale locale,@ModelAttribute("colorForm") Sell sell, Model model,HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("car"));
		return "color";
	}
	
	@RequestMapping(value="/color",method = RequestMethod.POST)
	public String color(Model model, HttpServletRequest request,@ModelAttribute("colorForm") Sell sell){
		model.addAttribute("sell",sell);
		System.out.println(request.getAttribute("car"));
		request.getSession().setAttribute("color", sell.getColor());	
		return "redirect:result";
	}
}
