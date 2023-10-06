package com.insurance.services;

import com.insurance.entities.Nominee;

// TODO: Auto-generated Javadoc
/**
 * The Interface NomineeService.
 */
public interface NomineeService {
	
	/**
	 * Adds the nominee.
	 *
	 * @param u the u
	 * @return the nominee
	 */
	public Nominee addNominee(Nominee u);
	
	/**
	 * Update nominee.
	 *
	 * @param u the u
	 * @param id the id
	 */
	public void updateNominee(Nominee u,Long id);
	
	/**
	 * Gets the nominee by order id.
	 *
	 * @param OrderId the order id
	 * @return the nominee by order id
	 */
	public Nominee getNomineeByOrderId(Long OrderId);
	
	/**
	 * Delete nominee.
	 *
	 * @param id the id
	 */
	public void deleteNominee(Long id);
}
