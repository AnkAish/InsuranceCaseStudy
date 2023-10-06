package com.insurance.services;

import java.util.List;
import java.util.Optional;

import com.insurance.entities.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<User> getAll();
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	public Optional<User> getUserById(Long id);
	
	/**
	 * Adds the user.
	 *
	 * @param u the u
	 * @return the user
	 */
	public User addUser(User u);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(Long id);
	
	/**
	 * Update user.
	 *
	 * @param u the u
	 * @param id the id
	 */
	public void updateUser(User u,Long id);
	
	public List<User> getUsersByRole(String role);
}
