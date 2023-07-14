package posojt.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("/admin/userList")
	public ModelAndView adminUserList() {
		ModelAndView mv = new ModelAndView("adminUserList");
		return mv;
	}
	
	@RequestMapping("/admin/shopList")
	public ModelAndView adminShopList() {
		ModelAndView mv = new ModelAndView("adminShopList");
		return mv;
	}
	
	@RequestMapping("/admin/home")
	public ModelAndView adminHome() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
