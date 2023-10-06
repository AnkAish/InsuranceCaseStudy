package com.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Policy;

// TODO: Auto-generated Javadoc
/**
 * The Interface PolicyRepository.
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Policy> findById(Long id);
}
