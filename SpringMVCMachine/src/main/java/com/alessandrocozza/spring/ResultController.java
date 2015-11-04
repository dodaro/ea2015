package com.alessandrocozza.spring;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController 
{
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(HttpServletRequest request, Model model)
	{
		logger.info("Welcome to result!");

		String message = (String) request.getSession().getAttribute("message");
		model.addAttribute("message", message);
		return "result";
	}
}