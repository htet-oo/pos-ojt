package posojt.web.controllers.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

	@RequestMapping("/seller/shopList")
	public ModelAndView sellerUserList() {
		ModelAndView mv = new ModelAndView("sellerShopList");
		return mv;
	}
}
