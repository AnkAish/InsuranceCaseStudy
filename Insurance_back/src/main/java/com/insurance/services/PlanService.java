package com.insurance.services;

import java.util.List;
import java.util.Optional;

import com.insurance.entities.Plan;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanService.
 */
public interface PlanService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Plan> getAll();
	
	/**
	 * Gets the plan by id.
	 *
	 * @param id the id
	 * @return the plan by id
	 */
	public Optional<Plan> getPlanById(Long id);
	
	/**
	 * Adds the plan.
	 *
	 * @param u the u
	 * @return the plan
	 */
	public Plan addPlan(Plan u);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(Long id);
	
	/**
	 * Update plan.
	 *
	 * @param u the u
	 * @param id the id
	 */
	public void updatePlan(Plan u,Long id);
}
