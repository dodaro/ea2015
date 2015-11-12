package com.davide.app;

import java.util.Locale;

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

import com.davide.app.model.CarSeller;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ColorController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(ColorController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) {
		logger.info("Welcome color! The client locale is {}.", locale);
		
		CarSeller c=(CarSeller) context.getBean("seller");
		c.setIdSelect((Integer)request.getSession().getAttribute("id"));
		System.out.println("id:"+c.getIdSelect());
		model.addAttribute("colorAction",c);
	
		
		return "color";
	}
	
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String execute( HttpServletRequest request,Locale locale, Model model, @ModelAttribute("colorAction") CarSeller seller) {
		
		
		System.out.println("arrivata");
		System.out.println("id"+(Integer)(request.getSession().getAttribute("id")));
		System.out.println("color"+seller.getColorSelect());
		request.getSession().setAttribute("color", seller.getColorSelect());
		//System.out.println(seller.getCars().get(((Integer)(request.getSession().getAttribute("id")))-1).getName());
		
		//System.out.println(seller.getCars().get(((Integer)(request.getSession().getAttribute("id")))-1).getIdColor());
//		request.getSession().setAttribute("id", seller.getIdSelect());
//		CarSeller c=(CarSeller) context.getBean("seller");
//		c.setIdSelect(seller.getIdSelect());
//		model.addAttribute("colorAction", c);
		return "redirect:result";
	}
}
