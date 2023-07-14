package posojt.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {

	@RequestMapping("/seller/home")
	public ModelAndView sellerHome() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("/seller/shopList")
	public ModelAndView adminUserList() {
		ModelAndView mv = new ModelAndView("sellerShopList");
		return mv;
	}
}
