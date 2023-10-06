package com.insurance.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insurance.entities.Nominee;
import com.insurance.repository.NomineeRepository;
import com.insurance.services.NomineeService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class NomineeServiceImpl.
 */
@Component
@Slf4j
public class NomineeServiceImpl implements NomineeService{

	/** The nominee repository. */
	@Autowired
	private NomineeRepository nomineeRepository;
	
	/**
	 * Adds the nominee.
	 *
	 * @param u the u
	 * @return the nominee
	 */
	//Add Nominee
	public Nominee addNominee(Nominee u) {
		log.info("Inside insertNominee function of NomineeService");
		this.nomineeRepository.save(u);
		return u;
	}

	/**
	 * Update nominee.
	 *
	 * @param u the u
	 * @param id the id
	 */
	//Update
	public void updateNominee(Nominee u,Long id) {
		log.info("Inside updateNominee function of NomineeService");
		u.setNomineeId(id);
		this.nomineeRepository.save(u);
	}

	/**
	 * Gets the nominee by order id.
	 *
	 * @param OrderId the order id
	 * @return the nominee by order id
	 */
	@Override
	public Nominee getNomineeByOrderId(Long OrderId) {
		log.info("Inside getNomineeByOrderId function of NomineeService");
		Nominee n = this.nomineeRepository.getNomineeByOrderId(OrderId);
		return n;
	}

	/**
	 * Delete nominee.
	 *
	 * @param id the id
	 */
	@Override
	public void deleteNominee(Long id) {
		log.info("Inside deleteNomineebyId function of NomineeService");
		this.nomineeRepository.deleteById(id);
	}

}
