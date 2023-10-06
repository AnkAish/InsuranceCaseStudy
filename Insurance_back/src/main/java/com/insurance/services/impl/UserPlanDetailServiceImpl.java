package com.insurance.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.insurance.entities.UserPlanDetail;
import com.insurance.repository.UserPlanDetailRepository;
import com.insurance.services.UserPlanDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserPlanDetailServiceImpl.
 */
@Component
@Slf4j
@Service
public class UserPlanDetailServiceImpl implements UserPlanDetailService{

	/** The user plan detail repository. */
	@Autowired
	private UserPlanDetailRepository userPlanDetailRepository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	//Get All UserPlanDetails
	public List<UserPlanDetail> getAll(){
		log.info("Inside getAllUserPlans function of UserPlanDetailService");
		return (List<UserPlanDetail>) this.userPlanDetailRepository.findAll();
	}
	
	/**
	 * Adds the user plan detail.
	 *
	 * @param u the u
	 * @return the user plan detail
	 */
	//Add UserPlanDetail
	public UserPlanDetail addUserPlanDetail(UserPlanDetail u) {
		log.info("Inside insertUserPlan function of UserPlanDetailService");
		this.userPlanDetailRepository.save(u);
		return u;
	}
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	//Delete
	public void deleteById(Long id) {
		log.info("Inside deleteUserPlanById function of UserPlanDetailService");
		this.userPlanDetailRepository.deleteById(id);
	}

	/**
	 * Update user plan detail.
	 *
	 * @param u the u
	 * @param id the id
	 */
	//Update
	public void updateUserPlanDetail(UserPlanDetail u,Long id) {
		log.info("Inside updateUserPlanById function of UserPlanDetailService");
		u.setOrderId(id);
		this.userPlanDetailRepository.save(u);
	}

	/**
	 * Gets the user plan by id.
	 *
	 * @param orderId the order id
	 * @return the user plan by id
	 */
	@Override
	public UserPlanDetail getUserPlanById(Long orderId) {
		log.info("Inside getUserPlanById function of UserPlanDetailService");
		return this.userPlanDetailRepository.findById(orderId).get();
	}

	/**
	 * Gets the plans by is verified.
	 *
	 * @param isVerified the is verified
	 * @return the plans by is verified
	 */
	@Override
	public List<UserPlanDetail> getPlansByIsVerified(Integer isVerified) {
		log.info("Inside getUserPlanByIsVerified function of UserPlanDetailService");
		return this.userPlanDetailRepository.findByIsVerified(isVerified);
	}
	
	/**
	 * Verify user plan.
	 *
	 * @param userPlanDetail the user plan detail
	 * @return the user plan detail
	 */
	@Override
	public UserPlanDetail verifyUserPlan(UserPlanDetail userPlanDetail) {
		log.info("Inside verifyUserPlan function of UserPlanDetailService");
		UserPlanDetail entity = this.userPlanDetailRepository.findById(userPlanDetail.getOrderId()).get();
		entity.setIsVerified(userPlanDetail.getIsVerified());
		this.userPlanDetailRepository.save(entity);
		return null;
	}
}
