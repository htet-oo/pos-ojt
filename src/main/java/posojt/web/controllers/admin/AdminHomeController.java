package posojt.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminHomeController {

	@RequestMapping("/admin/home")
	public ModelAndView adminHome() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
