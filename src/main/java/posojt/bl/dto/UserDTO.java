package posojt.bl.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import posojt.persistence.entity.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;
	private String password;
	private Date create_at;
	private SimpleGrantedAuthority role;

	
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.create_at = user.getCreated_at();
		this.role = new SimpleGrantedAuthority(user.getRole().getName());
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(role);
	}



	@Override
	public String getPassword() {
		return password;
	}



	@Override
	public String getUsername() {
		return email;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}



	@Override
	public boolean isEnabled() {
		return true;
	}



}
