package com.insurance.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.insurance.entities.User;
import com.insurance.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class CustomUserDetailService.
 */
@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService{

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Load user by username.
	 *
	 * @param userName the user name
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("Inside loadUserByUserName function of CustomUserDetailService");
		User user = userRepository.getUserByUserName(userName);
		if(user==null)
			throw new UsernameNotFoundException("USER NOT FOUND");
		return user;
	}

}
