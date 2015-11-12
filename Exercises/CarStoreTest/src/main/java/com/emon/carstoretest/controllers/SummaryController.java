package com.emon.carstoretest.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.emon.carstoretest.model.CarStore;

@Controller
public class SummaryController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String summary(Model model, HttpSession session) {
		CarStore carStore = (CarStore) context.getBean("CarStore");

		String carModel = (String) session.getAttribute("model");
		String carColor = (String) session.getAttribute("color");

		// We could also invalidate the session at this point, to let the user
		// make another purchase after this one.
	
		if (session.getAttribute("alreadyAClient") == null || carModel == null) {
			return "redirect:/";
		} else if (carColor == null) {
			return "redirect:color";
		}

		model.addAttribute("model", carModel);
		model.addAttribute("color", carColor);

		double totalPrice = carStore.getModelPrice(carModel) + carStore.getColorPrice(carColor);
		model.addAttribute("totalPrice", totalPrice);

		return "summary";
	}
}
