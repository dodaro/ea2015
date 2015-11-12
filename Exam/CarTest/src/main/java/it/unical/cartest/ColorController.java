package it.unical.cartest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.cartest.model.ColorManager;
import it.unical.cartest.model.Dealership;
import it.unical.cartest.model.Purchase;
import it.unical.cartest.model.Selection;

@Controller
public class ColorController {
	
	
	@Autowired ApplicationContext ac;
	
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public String home() {
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public String home(Locale locale,@ModelAttribute("selection") Selection selection, Model model) {
		

		if(selection.getIdSelected() == 0) {
			return "redirect:/";
		}
		else {
			
			Purchase purchase = (Purchase) ac.getBean("Purchase");
			purchase.setCarSelected(selection.getIdSelected());
			
			ColorManager colorManager = (ColorManager) ac.getBean("ColorManager");
			model.addAttribute("colors", colorManager.getColors().values());
			model.addAttribute("selection", (Selection) ac.getBean("Selection"));
			
			return "color";
		}

	}
	
}
