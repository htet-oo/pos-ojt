package posojt.bl.services.recoveryPassword.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import posojt.bl.services.recoveryPassword.RecoveryPasswordService;
import posojt.bl.services.user.UserService;
import posojt.persistence.dao.recoveryPassword.RecoveryPasswordDao;
import posojt.persistence.entity.PasswordReset;
import posojt.persistence.entity.User;


@Service
public class RecoveryPasswordServiceImpl implements RecoveryPasswordService {
	
	@Autowired
	private RecoveryPasswordDao recoveryPasswordDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void updateResetPasswordToken(String token, String email) {
		PasswordReset passwordReset = new PasswordReset();
		passwordReset.setEmail(email);
		passwordReset.setToken(token);
		passwordReset.setCreated_at(new Date());
		recoveryPasswordDao.setData(passwordReset);
	}

	@Override
	public PasswordReset get(String resetPasswordToken) {
		return recoveryPasswordDao.findResetPasswordToken(resetPasswordToken);
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		user.setPassword(passwordEncoder.encode(newPassword));
		user.setUpdate_at(new Date());
		userService.updatePassword(user);
		
		PasswordReset passwordReset = recoveryPasswordDao.searchByEmail(user.getEmail());
		recoveryPasswordDao.dropPasswordReset(passwordReset);
		
		
		
	}


	


}
