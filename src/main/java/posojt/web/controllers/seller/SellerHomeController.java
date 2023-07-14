package posojt.web.controllers.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerHomeController {

	@RequestMapping("/seller/home")
	public ModelAndView sellerHome() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
