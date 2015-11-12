package com.aloisius.springShop;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.aloisius.springShop.model.Helper;
import com.aloisius.springShop.model.ProductColor;
import com.aloisius.springShop.model.ProductsColorList;
import com.aloisius.springShop.model.User;

@Controller
public class EaColorSelectController {
	private static final Logger logger = LoggerFactory.getLogger(EaColorSelectController.class);

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/eaColorSelect", method = RequestMethod.GET)
	public String colorSeletPage(HttpServletRequest request, Model model) {
		logger.info("Color select get");
				
		// Controlla se un utente è loggato, per impedire il salto diretto a questa pagina
		if(Helper.checkUserSession(request, model)){
			return "redirect:eaProductSelect";
		}

		ProductsColorList list = (ProductsColorList) context.getBean("productsColorList");		
		list.setProductsColor(Helper.getLoadedProductsColor());		
		model.addAttribute("productsColorList", list);

		return "eaColorSelect";
	}

	@RequestMapping(value = "/eaColorSelect", method = RequestMethod.POST)
	public String productColorSelect(
			HttpServletRequest request,
			@RequestParam(value = "nameProductColor", required = true) String nameProduct,
			Model model) {
		logger.info("Color select post");

		ProductColor productColor = Helper.getProducColorByName(nameProduct);
		model.addAttribute("selectedProductColor", productColor);	
		
		User user = Helper.getUserLogged(request, model);
		user.setProductColorSelected(new ProductColor(productColor));

		return "redirect:eaProductReview";
	}	
}
