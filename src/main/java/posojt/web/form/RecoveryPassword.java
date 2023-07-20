package posojt.web.form;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RecoveryPassword {
	
	@NotBlank(message = "Please Enter Email")
	private String email;

}
