package posojt.bl.services.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import posojt.bl.services.user.UserService;
import posojt.persistence.dao.role.RoleDao;
import posojt.persistence.dao.user.UserDao;
import posojt.persistence.entity.User;
import posojt.web.form.Register;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	public void saveUser(Register register) {
		User user = new User();
		user.setCreated_at(new Date());
		user.setName(register.getName());
		user.setEmail(register.getEmail());
		user.setPassword(passwordEncoder.encode(register.getPassword()));
		user.setRole(this.roleDao.findById(register.getRole_id()));
		userDao.saveUser(user);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void updatePassword(User user) {
		userDao.updatePassword(user);
		
	}


}
