package it.unical.cartest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.cartest.model.Bill;
import it.unical.cartest.model.ColorManager;
import it.unical.cartest.model.Dealership;
import it.unical.cartest.model.Purchase;
import it.unical.cartest.model.Selection;

@Controller
public class ResultController {
	
	
	@Autowired ApplicationContext ac;
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String home() {
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String home(Locale locale, @ModelAttribute("selection") Selection selection, Model model) {
		
		
		if(selection.getIdSelected() == 0) {
			return "redirect:/";
		}
		else {
			
		
			Purchase purchase = (Purchase) ac.getBean("Purchase");
			purchase.setColorSelected(selection.getIdSelected());
			
			Dealership dealership = (Dealership) ac.getBean("Dealership");
			ColorManager colorManager = (ColorManager) ac.getBean("ColorManager");
			
			int idModel = purchase.getCarSelected();
			int idColor = purchase.getColorSelected();
			
			Bill bill = (Bill) ac.getBean("Bill");
	
			bill.setCarName(dealership.getCars().get(idModel).getName());
			bill.setColor(colorManager.getColors().get(idColor).getColor());
			
			float tot = dealership.getCars().get(idModel).getPrice();
			tot += colorManager.getColors().get(idColor).getPrice();
	
			bill.setAmount(tot);
			
			model.addAttribute("bill", bill);
			
			return "result";
			
		}
	}
	
}
