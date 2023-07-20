package posojt.web.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import posojt.bl.services.user.UserService;
import posojt.persistence.entity.User;

@Controller
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin/userList")
	public ModelAndView adminUserList() {
		ModelAndView mv = new ModelAndView("adminUserList");
		List<User> userList = userService.getAllUsers();
		mv.addObject("userList", userList);
		return mv;
	}

}
