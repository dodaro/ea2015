package it.unical.carSeller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class ResultController {

	@Autowired
	WebApplicationContext context;
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(HttpServletRequest request){
		
		return "result";
	}
}
