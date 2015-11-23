package it.unical.vendingEa2015;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import it.unical.vendingEa2015.model.Vmachine;


@Controller
public class VendingMachineController2 {

	private static final Logger logger = LoggerFactory.getLogger(VendingMachineController2.class);
	private Vmachine vmachine;
	
	@Autowired
	private WebApplicationContext context;
	
	@RequestMapping(value = "/vmachine", method = RequestMethod.GET)
	public String getForm(Model model) {
		this.vmachine = context.getBean("vmachineBean", Vmachine.class);
		logger.info("Vending!");
		logger.info("getform " + vmachine.toString());
		
		model.addAttribute("vmachineAction", this.vmachine);
		return "vmachine";
	}
	
	@RequestMapping(value = "/vmachine", method = RequestMethod.POST)
	public String resultForm(@RequestParam String change, @ModelAttribute("vmachineAction") Vmachine vmachine, Model model) {
		logger.info("inizioResult " + vmachine.toString());	
		
		if (change != null && change.contentEquals("Change") && vmachine.getMoney() != 0){
			model.addAttribute("messageOut", "Your change is: " + (vmachine.getMoney()) + "€");
			this.vmachine.setMoney(0);
			model.addAttribute("vmachineAction", this.vmachine);
			
			return "vmachine";
		}
		double credit = vmachine.getMoney()-vmachine.getPurchased();
		
		if (vmachine.getMoney() == 0) {
			model.addAttribute("messageOut", "Zero credit!!!");		
		}
		else if (credit < 0){
			model.addAttribute("messageOut", "This is not enough. Please insert "+ (Math.abs(credit))+ "€ more.");
			this.vmachine.setMoney(vmachine.getMoney());
			}
		else {
			model.addAttribute("messageOut", "You bought a product. Thank you! \n Remaining credit: " + (credit) + "€");
			this.vmachine.setMoney(credit);
		}	
		logger.info("fineResult " + this.vmachine.toString());
		
		model.addAttribute("vmachineAction", this.vmachine);
		return "vmachine";
	}

}
