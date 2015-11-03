package it.unical.vendingMachine;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.vendingMachine.model.VMachine;



@Controller
public class HomeController {
	

	private static ArrayList<String> tmpGoodies = new ArrayList<String>();
	private static HashMap<String, Double> tmpGoodiesPrice = new HashMap<String, Double>();
	
	
	
	public HomeController() {

		loadData();
	}
	
	
	private void loadData() {
		
		tmpGoodies.add("coffee");
		tmpGoodies.add("chocolate");
		tmpGoodies.add("tea");
		
		tmpGoodiesPrice.put("coffee", 0.5);
		tmpGoodiesPrice.put("chocolate", 1.0);
		tmpGoodiesPrice.put("tea", 1.2);
	}
	
	
	@RequestMapping(value = "/vmachine", method = RequestMethod.GET)
	public String initForm(Model model) {
		
		VMachine vMachine = new VMachine();
		
		model.addAttribute("machine", vMachine);
		model.addAttribute("items", tmpGoodies);
		
		return "vmachine";
	}
	
	
	@RequestMapping(value = "/vmachine", method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request, Model model,
			@ModelAttribute("machine") VMachine vMachine) {
		
		
		double tmpSpend = 0;
		for(String tmpItemName : vMachine.getGoodies()) {
			
			tmpSpend += tmpGoodiesPrice.get(tmpItemName); 
		}
		
		String message;
		if(tmpSpend > vMachine.getMoney()) {
			message = "Poor man you have to add " + (tmpSpend - vMachine.getMoney());
			request.getSession().setAttribute("message", message);
		}
		else {
			message = "This is your rest " + (vMachine.getMoney() - tmpSpend);
			request.getSession().setAttribute("message", message);
		}
		
		model.addAttribute("items", tmpGoodies);
		
		return "vmachine";
	}
	
	
}
