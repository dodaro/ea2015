package com.emon.vendingmachine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emon.vendingmachine.model.FormProduct;
import com.emon.vendingmachine.model.PurchaseForm;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("purchaseForm", new PurchaseForm());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String purchase(Model model, @ModelAttribute("purchaseForm") PurchaseForm form) {
		double amount = form.getAmount();
		double dueAmount = 0;
		
		for (FormProduct product : form.getProducts()) {
			if (product.isSelected()) {
				dueAmount += product.getPrice();
			}
		}
		
		StringBuilder message = new StringBuilder();

		if (amount >= dueAmount) {
			message.append("Your change is ");
			message.append(String.format("%.2f", amount - dueAmount));
		} else {
			message.append("You need to add ");
			message.append(String.format("%.2f", dueAmount - amount));
		}
		
		message.append(" &euro;.");
		
		model.addAttribute("message", message.toString());
		
		if (amount >= dueAmount) {
			model.addAttribute("purchaseForm", new PurchaseForm());
		} else {
			model.addAttribute("purchaseForm", form);
		}
		
		return "home";
	}
}
