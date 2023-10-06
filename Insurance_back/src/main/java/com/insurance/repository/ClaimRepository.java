package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Claim;
// TODO: Auto-generated Javadoc

/**
 * The Interface ClaimRepository.
 */
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Claim> findById(Long id);
	
	/**
	 * Find by claim status.
	 *
	 * @param claimStatus the claim status
	 * @return the list
	 */
	public List<Claim> findByClaimStatus(Integer claimStatus);

}
