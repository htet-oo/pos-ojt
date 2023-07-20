package posojt.web.form;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Register {
	
	@NotNull(message = "Please select a role.")
	private int role_id;
	
	@NotBlank(message = "Please Enter email.")
	private String email;
	
	@NotBlank(message = "Please Enter name.")
	private String name;
	
	@NotBlank(message = "Please Enter password.")
	private String password;
	
	
}
