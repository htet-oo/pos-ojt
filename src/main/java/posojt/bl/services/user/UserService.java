package posojt.bl.services.user;

import java.util.List;

import posojt.persistence.entity.User;
import posojt.web.form.Register;

public interface UserService {
	List<User> getAllUsers();
	void saveUser(Register register);
	User findByEmail(String email);
	void updatePassword(User user);
}
