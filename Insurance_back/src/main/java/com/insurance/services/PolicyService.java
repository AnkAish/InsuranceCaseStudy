package com.insurance.services;

import java.util.List;
import java.util.Optional;

import com.insurance.entities.Policy;

// TODO: Auto-generated Javadoc
/**
 * The Interface PolicyService.
 */
public interface PolicyService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Policy> getAll();
	
	/**
	 * Gets the policy by id.
	 *
	 * @param id the id
	 * @return the policy by id
	 */
	public Optional<Policy> getPolicyById(Long id);
	
	/**
	 * Adds the policy.
	 *
	 * @param u the u
	 * @return the policy
	 */
	public Policy addPolicy(Policy u);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(Long id);
	
	/**
	 * Update policy.
	 *
	 * @param u the u
	 * @param id the id
	 */
	public void updatePolicy(Policy u,Long id);
}
