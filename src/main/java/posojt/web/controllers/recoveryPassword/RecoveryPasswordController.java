package posojt.web.controllers.recoveryPassword;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.bytebuddy.utility.RandomString;
import posojt.bl.services.recoveryPassword.RecoveryPasswordService;
import posojt.web.form.RecoveryPassword;

@Controller
public class RecoveryPasswordController {
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private RecoveryPasswordService recoveryPasswordService;
	
	@RequestMapping("/recoveryPassword")
	public ModelAndView recoveryPassword() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("recoveryPasswordForm", new RecoveryPassword());
		return mv;
	}
	
	@PostMapping("/recoveryPassword")
	public String processRecoveryPassword(@ModelAttribute("recoveryPasswordForm") @Valid RecoveryPassword recoveryPassword,BindingResult result) throws UnsupportedEncodingException, MessagingException {
		if (result.hasErrors()) {
			return "/recoveryPassword";
		}
		String email = recoveryPassword.getEmail();
		String token = RandomString.make(45);
		recoveryPasswordService.updateResetPasswordToken(token, email);
		String resertPasswordLink = ServletUriComponentsBuilder.fromCurrentContextPath().path("/resetPassword").queryParam("token",token).toUriString();
		sendEmail(email, resertPasswordLink);
		return "/recoveryPassword";
	}
	
	
	private void sendEmail(String email,String resertPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("www.htetooaa@gmail.com", "Together");
		helper.setTo(email);
		String subject = "Here's your link to reset password.";
		String content = "<p>Hello,</p>"
					   + "<p>Your Reset Password Link is Here</p>"
					   +"<p><b><a href =\""+ resertPasswordLink + "\">change my password</a></b></p>";
		
		helper.setSubject(subject);
		helper.setText(content,true);
		mailSender.send(message);
	}
}
