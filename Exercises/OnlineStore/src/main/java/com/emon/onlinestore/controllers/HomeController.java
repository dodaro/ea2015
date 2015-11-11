package com.emon.onlinestore.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.emon.onlinestore.model.Cart;
import com.emon.onlinestore.model.OnlineStore;

@Controller
public class HomeController {

	private static final String CART_PARAM = "cart";
	@Autowired
	WebApplicationContext context;

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		OnlineStore store = (OnlineStore) context.getBean("OnlineStore");
		Cart cart = (Cart) session.getAttribute(CART_PARAM);
		
		if (cart != null) {
			model.addAttribute(CART_PARAM, cart);
		} else {
			cart = new Cart();
			session.setAttribute(CART_PARAM, cart);
			model.addAttribute(CART_PARAM, cart);
		}

		model.addAttribute("items", store.getItems());
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(HttpSession session, @RequestParam("itemId") int itemId,
			@RequestParam("quantity") int quantity) {
		OnlineStore store = (OnlineStore) context.getBean("OnlineStore");
		Cart cart = (Cart) session.getAttribute(CART_PARAM);

		if (cart == null) {
			cart = new Cart();
			session.setAttribute(CART_PARAM, cart);
		}

		/* Params should be validated. */
		cart.addItem(store.getItemById(itemId), quantity);
		System.out.println(cart.getItems());
		return "{\"success\": true, \"itemId\": " + itemId + ", \"quantity\": " + quantity + "}";
	}
}