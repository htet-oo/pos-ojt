package posojt.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminSellerController {

	@RequestMapping("/admin/shopList")
	public ModelAndView adminShopList() {
		ModelAndView mv = new ModelAndView("adminShopList");
		return mv;
	}

}
