package com.kbit.eem.service.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kbit.eem.DBModel.User;
import com.kbit.eem.repository.usermanagement.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		return userRepository.loadUserByUsername(username);
	}

	@Override
	public int[] getRoleSubModules(String userId) {
		// TODO Add logic to fetch modules
		int len = 42;
		int[] submoduleIds = new int[len];
		for (int i = 0; i < len; i++) {
			submoduleIds[i] = i + 1;
		}
		return submoduleIds;
	}

	@Override
	public boolean changePassword(String userId, String password,
			String newPassword) throws BadCredentialsException {
		// TODO Auto-generated method stub
		return false;
	}
}