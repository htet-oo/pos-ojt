package posojt.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminUserController {

	@RequestMapping("/admin/userList")
	public ModelAndView adminUserList() {
		ModelAndView mv = new ModelAndView("adminUserList");
		return mv;
	}

}
