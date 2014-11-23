package com.kbit.eem.service.usermanagement;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.kbit.eem.DBModel.User;

public class KBAuthenticationProvider implements AuthenticationProvider {
	Logger logger = Logger.getLogger(KBAuthenticationProvider.class);

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		// Load user
		User user = userServiceImpl.loadUserByUsername(username);

		if (user == null) {
			throw new BadCredentialsException("Username not found.");
		}

		if (user.isEncrypted()) {
			password = PasswordEncoder.encode(password);
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Collection<? extends GrantedAuthority> authorities = user
				.getAuthorities();

		return new UsernamePasswordAuthenticationToken(username, password,
				authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//return true;
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
