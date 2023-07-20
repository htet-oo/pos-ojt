package posojt.bl.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import posojt.bl.dto.UserDTO;
import posojt.persistence.dao.user.UserDao;
import posojt.persistence.entity.User;



@Service
public class RoleDetailService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		UserDTO userDto = new UserDTO(user);
		return userDto;
	}

}
