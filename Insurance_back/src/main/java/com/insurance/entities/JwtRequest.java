package com.insurance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * Instantiates a new jwt request.
 *
 * @param userName the user name
 * @param password the password
 */
@AllArgsConstructor

/**
 * Instantiates a new jwt request.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class JwtRequest {

	/** The user name. */
	String userName;
	
	/** The password. */
	String password;
}
