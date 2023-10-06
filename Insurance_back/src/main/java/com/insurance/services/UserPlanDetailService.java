package com.insurance.services;

import java.util.List;

import com.insurance.entities.UserPlanDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserPlanDetailService.
 */
public interface UserPlanDetailService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<UserPlanDetail> getAll();
	
	/**
	 * Adds the user plan detail.
	 *
	 * @param u the u
	 * @return the user plan detail
	 */
	public UserPlanDetail addUserPlanDetail(UserPlanDetail u);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(Long id);
	
	/**
	 * Update user plan detail.
	 *
	 * @param u the u
	 * @param id the id
	 */
	public void updateUserPlanDetail(UserPlanDetail u,Long id);
	
	/**
	 * Gets the user plan by id.
	 *
	 * @param orderId the order id
	 * @return the user plan by id
	 */
	public UserPlanDetail getUserPlanById(Long orderId);
	
	/**
	 * Gets the plans by is verified.
	 *
	 * @param isVerified the is verified
	 * @return the plans by is verified
	 */
	public List<UserPlanDetail> getPlansByIsVerified(Integer isVerified);
	
	/**
	 * Verify user plan.
	 *
	 * @param userPlanDetail the user plan detail
	 * @return the user plan detail
	 */
	public UserPlanDetail verifyUserPlan(UserPlanDetail userPlanDetail);
}
