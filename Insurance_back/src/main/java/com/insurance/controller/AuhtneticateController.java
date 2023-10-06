package com.insurance.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.entities.JwtRequest;
import com.insurance.entities.JwtResponse;
import com.insurance.entities.User;
import com.insurance.helper.JwtUtil;
import com.insurance.services.impl.CustomUserDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class AuhtneticateController.
 */
@RestController
@CrossOrigin("*")
@Slf4j
public class AuhtneticateController {

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** The custom user detail service. */
	@Autowired
	private CustomUserDetailService customUserDetailService;

	/** The jwt util. */
	@Autowired
	private JwtUtil jwtUtil;

	/**
	 * Generate token.
	 *
	 * @param jwtRequest the jwt request
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			log.info("Inside generateToken function of AuthenticateController");
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials!!");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials!!");
		}

		// Fine Area
		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUserName());
		String token = this.jwtUtil.generateToken(userDetails);

		// {"token":"value"}
		return ResponseEntity.ok(new JwtResponse(token));
	}

	/**
	 * Gets the current user.
	 *
	 * @param principal the principal
	 * @return the current user
	 */
	@GetMapping("/currentUser")
	public User getCurrentUser(Principal principal) {
		log.info("Inside getCurrentUser function of AuthenticateController");
		return ((User) customUserDetailService.loadUserByUsername(principal.getName()));
	}

}
