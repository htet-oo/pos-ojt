package posojt.persistence.dao.recoveryPassword;

import posojt.persistence.entity.PasswordReset;

public interface RecoveryPasswordDao {
	void setData(PasswordReset passwordReset);
	PasswordReset findResetPasswordToken(String resetPasswordToken);
	PasswordReset searchByEmail(String email);
	void dropPasswordReset(PasswordReset passwordReset);
}
