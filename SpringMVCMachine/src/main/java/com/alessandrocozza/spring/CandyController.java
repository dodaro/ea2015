package com.alessandrocozza.spring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	private Map<String, Candy> candyCache;

	@RequestMapping(value = "/candy", method = RequestMethod.GET)
	public String candy(Model model) 
	{
		logger.info("Welcome to the candy page");
		
		candyCache = new HashMap<String, Candy>();
		ApplicationController ac = ApplicationController.getInstance();
		HashSet<Candy> candies = new HashSet<Candy>();
		
		Candy goleador = new Candy("Goleador", 0.10f);
		candies.add(goleador);
		candyCache.put(goleador.getName(), goleador);
		candies.add(goleador);
		Candy lupoAlberto = new Candy("Lupo Alberto", 0.10f);
		candies.add(lupoAlberto);
		candyCache.put(lupoAlberto.getName(), lupoAlberto);
		candies.add(lupoAlberto);
		candies.add(new Candy("Morositas", 0.80f));
		Candy morositas = new Candy("Morositas", 0.80f);
		candies.add(morositas);
		candyCache.put(morositas.getName(), morositas);
		candies.add(morositas);
		
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
		String candiesTaked = "";
		for (Candy candy : user.getSelectedCandies())
		{
			tot += candy.getValue();
			candiesTaked += candy.getName() + " ";
		}
		float ris = user.getMoney() - tot;
		String message;
		if (ris >= 0) 
		{
			message = "Transaction closed.";
			if (tot != user.getMoney())
				message += " Take the money back: " + ris + "$" + "\n" + candiesTaked;
		} 
		else 
		{
			message = "Transaction failed. You don't have enough money. Pleas insert: " + Math.abs(ris) + "$" + "\n" + candiesTaked;
		}
		request.getSession().setAttribute("message", message);
		return "redirect:/result";
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception 
	{
		binder.registerCustomEditor(Set.class, "selectedCandies", new CustomCollectionEditor(Set.class) 
		{
			@Override
			protected Object convertElement(Object element) 
			{	
				if (element instanceof String) 
				{
					String name = "";
					if(element instanceof String) 
					{
						Candy candy = candyCache.get(element);		
						return candy;
					}
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}
}
