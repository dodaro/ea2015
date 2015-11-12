package com.aloisius.springShop;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloisius.springShop.model.Helper;

@Controller
public class EaProductReviewController {
	private static final Logger logger = LoggerFactory.getLogger(EaProductReviewController.class);

	@RequestMapping(value = "/eaProductReview", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		logger.info("Color select get");

		// Controlla se un utente è loggato, per impedire il salto diretto a questa pagina
		if(Helper.checkUserSession(request, model)){
			return "redirect:eaProductSelect";
		}

		return "eaProductReview";
	}

}
