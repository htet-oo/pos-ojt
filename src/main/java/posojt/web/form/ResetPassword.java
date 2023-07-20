package posojt.web.form;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPassword {
	
	private String token;
	
	@NotBlank
	private String email;
	
	@NotBlank(message = "Please Enter Password")
	private String password;
	
	@NotBlank(message = "Please Enter Confim Password")
	private String confirmPassword;

}
