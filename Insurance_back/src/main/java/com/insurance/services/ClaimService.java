package com.insurance.services;

import java.util.List;

import com.insurance.entities.Claim;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClaimService.
 */
public interface ClaimService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Claim> getAll();
	
	/**
	 * Gets the claim by id.
	 *
	 * @param claimId the claim id
	 * @return the claim by id
	 */
	public Claim getClaimById(Long claimId);
	
	/**
	 * Adds the claim.
	 *
	 * @param u the u
	 * @return the claim
	 */
	public Claim addClaim(Claim u);
	
	/**
	 * Delete by id.
	 *
	 * @param claimId the claim id
	 */
	public void deleteById(Long claimId);
	
	/**
	 * Update claim.
	 *
	 * @param u the u
	 * @param claimId the claim id
	 */
	public void updateClaim(Claim u,Long claimId);
	
	/**
	 * Gets the claims by claim status.
	 *
	 * @param num the num
	 * @return the claims by claim status
	 */
	public List<Claim> getClaimsByClaimStatus(Integer num);
	
	/**
	 * Verify claim.
	 *
	 * @param claim the claim
	 * @return the claim
	 */
	public Claim verifyClaim(Claim claim);
}
