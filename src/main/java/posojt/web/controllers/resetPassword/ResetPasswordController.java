package posojt.web.controllers.resetPassword;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import posojt.bl.services.recoveryPassword.RecoveryPasswordService;
import posojt.bl.services.user.UserService;
import posojt.persistence.entity.PasswordReset;
import posojt.persistence.entity.User;
import posojt.web.form.ResetPassword;

@Controller
public class ResetPasswordController {
	@Autowired
	private RecoveryPasswordService recoveryPasswordService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/resetPassword")
	public ModelAndView resetPassword(@RequestParam String token) {
		ModelAndView mv = new ModelAndView();
		PasswordReset passwordReset = recoveryPasswordService.get(token);
		String mail = passwordReset.getEmail();
		ResetPassword resetPasswordForm = new ResetPassword();
		resetPasswordForm.setEmail(mail);
		mv.addObject("resetPasswordForm", resetPasswordForm);
		mv.addObject("token",token);
		mv.addObject("email", mail);
		return mv;
	}
	@PostMapping("/resetPassword")
	public String processResetPassword(@ModelAttribute("resetPasswordForm") @Valid ResetPassword resetPassword,BindingResult result) {
		System.out.println("before submit1");
		ModelAndView mv = new ModelAndView();
		System.out.println("before submit2");
		String token = resetPassword.getToken();
		System.out.println("before submit3");
		String password = resetPassword.getPassword();
		System.out.println("before submit4");
		String confirmPassword = resetPassword.getConfirmPassword();
		System.out.println("before submit5");
		PasswordReset passwordReset = recoveryPasswordService.get(token);
	    if (!password.equals(confirmPassword)) {
	    	System.out.println("before submit6");
	        result.rejectValue("confirmPassword", "password.mismatch", "Password and Confirm Password must match");
	    }
	    if (result.hasErrors()) {
	    	System.out.println("before submit7");
	        mv.addObject("token", token);
	        mv.addObject("email", resetPassword.getEmail());
	        return "/resetPassword";
		}
		if(passwordReset != null) {
			System.out.println("before submit8");
			User user = userService.findByEmail(passwordReset.getEmail());
			System.out.println("before submit9");
			recoveryPasswordService.updatePassword(user, password);
		}
		return "/login";
	}
}
