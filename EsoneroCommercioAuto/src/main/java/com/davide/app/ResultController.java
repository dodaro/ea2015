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
public class ResultController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) {
		logger.info("Welcome color! The client locale is {}.", locale);
		
		CarSeller c=(CarSeller) context.getBean("seller");
		c.setIdSelect((Integer)request.getSession().getAttribute("id"));
		c.setColorSelect((Integer)request.getSession().getAttribute("color"));

		model.addAttribute("resultAction",c);
	
		
		return "result";
	}
	
	
}
