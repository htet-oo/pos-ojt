package posojt.persistence.dao.user;

import java.util.List;

import posojt.persistence.entity.User;

public interface UserDao {
	List<User> getAllUsers();
	void saveUser(User user);
	User findByEmail(String email);
	void updatePassword(User user);
	

}
