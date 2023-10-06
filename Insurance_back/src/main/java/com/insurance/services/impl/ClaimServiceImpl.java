package com.insurance.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insurance.entities.Claim;
import com.insurance.repository.ClaimRepository;
import com.insurance.services.ClaimService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class ClaimServiceImpl.
 */
@Component
@Slf4j
public class ClaimServiceImpl implements ClaimService{

	/** The claim repository. */
	@Autowired
	private ClaimRepository claimRepository;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Override
	public List<Claim> getAll() {
		log.info("Inside getAllClaims function of ClaimService");
		return (List<Claim>) this.claimRepository.findAll();
	}

	/**
	 * Gets the claim by id.
	 *
	 * @param id the id
	 * @return the claim by id
	 */
	@Override
	public Claim getClaimById(Long id) {
		log.info("Inside getClaimById function of ClaimService");
		return this.claimRepository.findById(id).get();
	}

	/**
	 * Adds the claim.
	 *
	 * @param u the u
	 * @return the claim
	 */
	@Override
	public Claim addClaim(Claim u) {
		log.info("Inside insertClaim function of ClaimService");
		this.claimRepository.save(u);
		return u;
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@Override
	public void deleteById(Long id) {
		log.info("Inside deleteClaimById function of ClaimService");
		this.claimRepository.deleteById(id);
	}

	/**
	 * Update claim.
	 *
	 * @param u the u
	 * @param id the id
	 */
	@Override
	public void updateClaim(Claim u, Long id) {
		log.info("Inside updateClaimById function of ClaimService");
		u.setClaimId(id);
		this.claimRepository.save(u);
	}

	/**
	 * Gets the claims by claim status.
	 *
	 * @param num the num
	 * @return the claims by claim status
	 */
	@Override
	public List<Claim> getClaimsByClaimStatus(Integer num) {
		log.info("Inside getClaimByClaimStatus function of ClaimService");
		return this.claimRepository.findByClaimStatus(num);
	}
	
	/**
	 * Verify claim.
	 *
	 * @param claim the claim
	 * @return the claim
	 */
	@Override
	public Claim verifyClaim(Claim claim) {
		log.info("Inside verifyClaim function of ClaimService");
		Claim entity = this.claimRepository.findById(claim.getClaimId()).get();
		entity.setClaimStatus(claim.getClaimStatus());
		if(claim.getClaimStatus()==0)
			claim.getUserPlanDetail().setIsVerified(2);
		this.claimRepository.save(entity);
		return entity;
	}

}
