package com.insurance.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insurance.entities.Plan;
import com.insurance.repository.PlanRepository;
import com.insurance.services.PlanService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class PlanServiceImpl.
 */
@Component
@Slf4j
public class PlanServiceImpl implements PlanService{

	/** The plan repository. */
	@Autowired
	private PlanRepository planRepository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	//Get All Plans
	public List<Plan> getAll(){
		log.info("Inside getAllPlans function of PlanService");
		return (List<Plan>) this.planRepository.findAll();
	}
	
	/**
	 * Gets the plan by id.
	 *
	 * @param id the id
	 * @return the plan by id
	 */
	//Get Plan By ID
	public Optional<Plan> getPlanById(Long id) {
		log.info("Inside getPlanById function of PlanService");
		return this.planRepository.findById(id);
	}
	
	/**
	 * Adds the plan.
	 *
	 * @param u the u
	 * @return the plan
	 */
	//Add Plan
	public Plan addPlan(Plan u) {
		log.info("Inside insertPlan function of PlanService");
		this.planRepository.save(u);
		return u;
	}
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	//Delete
	public void deleteById(Long id) {
		log.info("Inside deletePlanById function of PlanService");
		this.planRepository.deleteById(id);
	}

	/**
	 * Update plan.
	 *
	 * @param u the u
	 * @param id the id
	 */
	//Update
	public void updatePlan(Plan u,Long id) {
		log.info("Inside updatePlanById function of PlanService");
		u.setPlanId(id);
		this.planRepository.save(u);
	}

}
