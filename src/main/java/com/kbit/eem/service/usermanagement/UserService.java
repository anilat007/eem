package com.kbit.eem.service.usermanagement;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	public boolean changePassword(String userId, String password,
			String newPassword) throws BadCredentialsException;
	
	public int[] getRoleSubModules(String userId);
}
