package com.emon.carstoretest.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.emon.carstoretest.model.CarStore;
import com.emon.carstoretest.model.ColorForm;

@Controller
public class ColorController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String color(Model model, HttpSession session) {
		if (session.getAttribute("alreadyAClient") == null || session.getAttribute("model") == null) {
			return "redirect:/";
		} else {
			if (session.getAttribute("color") != null) {
				return "redirect:summary";
			}
		}

		handleRequest(model);

		return "color";
	}

	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String toSummary(Model model, HttpSession session, @ModelAttribute ColorForm form) {
		if (form.getColor() == null) {
			handleRequest(model);
			return "color";
		}

		session.setAttribute("color", form.getColor());

		return "redirect:summary";
	}

	public void handleRequest(Model model) {
		CarStore carStore = (CarStore) context.getBean("CarStore");

		model.addAttribute("colorForm", new ColorForm());
		model.addAttribute("carStore", carStore);
	}
}
