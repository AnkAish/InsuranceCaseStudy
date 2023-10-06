package com.insurance.entities;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
// TODO: Auto-generated Javadoc

/**
 * Instantiates a new authority.
 *
 * @param authority the authority
 */
@AllArgsConstructor

/**
 * Instantiates a new authority.
 */
@NoArgsConstructor
public class Authority implements GrantedAuthority {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The authority. */
	private String authority;
	
	/**
	 * Gets the authority.
	 *
	 * @return the authority
	 */
	@Override
	public String getAuthority() {
		return this.authority;
	}

}
