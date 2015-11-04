package it.unical.vendingMachine;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.vendingMachine.model.Good;
import it.unical.vendingMachine.model.VMachine;



@Controller
public class HomeController {
	

	private static ArrayList<Good> tmpGoodies = new ArrayList<Good>();
	
	
	public HomeController() {

		loadData();
	}
	
	
	private void loadData() {
		
		
		Good coffe = new Good("coffee", 0.5);
		Good chocolate = new Good("chocolate", 1.0);
		Good tea = new Good("tea", 1.2);
		
		tmpGoodies.add(coffe);
		tmpGoodies.add(chocolate);
		tmpGoodies.add(tea);
		
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
		for(Double tmpBill : vMachine.getPurchase()) {
			
			tmpSpend += tmpBill; 
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
