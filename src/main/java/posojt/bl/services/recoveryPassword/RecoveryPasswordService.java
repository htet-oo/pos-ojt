package posojt.bl.services.recoveryPassword;

import posojt.persistence.entity.PasswordReset;
import posojt.persistence.entity.User;

public interface RecoveryPasswordService {
	void updateResetPasswordToken(String token,String email);
	PasswordReset get(String resetPasswordToken);
	void updatePassword(User user, String newPassword);
	
}
