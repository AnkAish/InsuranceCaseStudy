package com.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Plan;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanRepository.
 */
@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Plan> findById(Long id);
}
