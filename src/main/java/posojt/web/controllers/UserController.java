package posojt.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	
	@RequestMapping("/user/home")
	public ModelAndView userHome() {
		ModelAndView mv = new ModelAndView("");
		return mv;
	}


}
