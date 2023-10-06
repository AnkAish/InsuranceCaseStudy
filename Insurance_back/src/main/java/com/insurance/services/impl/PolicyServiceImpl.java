package com.insurance.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insurance.entities.Policy;
import com.insurance.repository.PolicyRepository;
import com.insurance.services.PolicyService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class PolicyServiceImpl.
 */
@Component
@Slf4j
public class PolicyServiceImpl implements PolicyService{

	/** The policy repository. */
	@Autowired
	private PolicyRepository policyRepository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	//Get All Policies 
	public List<Policy> getAll(){
		log.info("Inside getAllPolicies function of PolicyService");
		return (List<Policy>) this.policyRepository.findAll();
	}
	
	/**
	 * Gets the policy by id.
	 *
	 * @param id the id
	 * @return the policy by id
	 */
	//Get Policy By ID
	public Optional<Policy> getPolicyById(Long id) {
		log.info("Inside getPolicyById function of PolicyService");
		return this.policyRepository.findById(id);
	}
	
	/**
	 * Adds the policy.
	 *
	 * @param u the u
	 * @return the policy
	 */
	//Add Policy
	public Policy addPolicy(Policy u) {
		log.info("Inside insertPolicy function of PolicyService");
		this.policyRepository.save(u);
		return u;
	}
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	//Delete
	public void deleteById(Long id) {
		log.info("Inside deletePolicyById function of PolicyService");
		this.policyRepository.deleteById(id);
	}

	/**
	 * Update policy.
	 *
	 * @param u the u
	 * @param id the id
	 */
	//Update
	public void updatePolicy(Policy u,Long id) {
		log.info("Inside updatePolicyById function of PolicyService");
		u.setPolicyId(id);
		this.policyRepository.save(u);
	}
}
