package posojt.web.controllers.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import posojt.bl.services.user.UserService;
import posojt.web.form.Register;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signUp")
	public ModelAndView signUp() {
		ModelAndView mv = new ModelAndView("signUp");
		mv.addObject("registerForm", new Register());
		return mv;
	}
	
	@RequestMapping(value = "/signUp/save", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("registerForm") @Valid Register register,BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("signUp");
			return mv;
		}
		userService.saveUser(register);
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	

}
