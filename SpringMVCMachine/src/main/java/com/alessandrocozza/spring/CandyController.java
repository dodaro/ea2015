package com.alessandrocozza.spring;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alessandrocozza.model.ApplicationController;
import com.alessandrocozza.model.Candy;
import com.alessandrocozza.model.User;

@Controller
public class CandyController 
{
	private static final Logger logger = LoggerFactory.getLogger(CandyController.class);

	@RequestMapping(value = "/candy", method = RequestMethod.GET)
	public String candy(Model model) 
	{
		logger.info("Welcome to the candy page");
		
		ApplicationController ac = ApplicationController.getInstance();
		HashSet<Candy> candies = new HashSet<Candy>();
		candies.add(new Candy("Goleador", 0.10f));
		candies.add(new Candy("Lupo Alberto", 0.10f));
		candies.add(new Candy("Morositas", 0.80f));
		candies.add(new Candy("Rotella di liquirizia", 0.20f));
		candies.add(new Candy("Alpenliebe", 1.20f));
		ac.setCandies(candies);
		
		model.addAttribute("user", new User());
		model.addAttribute("candiesList", ac.getCandies());
		
		return "candy";
	}

	@RequestMapping(value = "/candy", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, @ModelAttribute("user") User user, Model model) 
	{
		logger.info("Money " + user.getMoney());
		
		float tot = 0;
		for (float candy : user.getSelectedCandies())
		{
			tot += candy;
		}
		float ris = user.getMoney() - tot;
		String message;
		if (ris >= 0) 
		{
			message = "Transaction closed.";
			if (tot != user.getMoney())
				message += " Take the money back: " + ris + "$";
		} 
		else 
		{
			message = "Transaction failed. You don't have enough money. Pleas insert: " + Math.abs(ris) + "$";
		}
		request.getSession().setAttribute("message", message);
		return "redirect:/result";
	}
}
