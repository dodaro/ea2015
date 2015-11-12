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
import com.emon.carstoretest.model.ModelForm;

@Controller
public class HomeController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {

		if (session.getAttribute("alreadyAClient") == null) {
			session.setAttribute("alreadyAClient", true);
		} else {
			if (session.getAttribute("model") != null) {
				if (session.getAttribute("color") != null) {
					return "redirect:summary";
				}

				return "redirect:color";
			}
		}

		handleRequest(model);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String toColorChoice(Model model, HttpSession session, @ModelAttribute ModelForm form) {
		if (form.getModel() == null) {
			handleRequest(model);
			return "home";
		}

		session.setAttribute("model", form.getModel());

		return "redirect:color";
	}

	public void handleRequest(Model model) {
		CarStore carStore = (CarStore) context.getBean("CarStore");

		model.addAttribute("modelForm", new ModelForm());
		model.addAttribute("carStore", carStore);
	}
}
