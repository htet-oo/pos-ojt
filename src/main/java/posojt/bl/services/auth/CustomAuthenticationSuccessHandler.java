package posojt.bl.services.auth;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
	
		if (authorities.contains(new SimpleGrantedAuthority("Admin"))) {
			System.out.println("before admin");
			response.sendRedirect("admin/home");
        }
		
		
		if (authorities.contains(new SimpleGrantedAuthority("Seller"))) {
			System.out.println("before seller");
			response.sendRedirect("seller/home");
		}
		
		if (authorities.contains(new SimpleGrantedAuthority("User"))) {
			System.out.println("before seller");
			response.sendRedirect("user/home");
		}
		
		
	}

}
