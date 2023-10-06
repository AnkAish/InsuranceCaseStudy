package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Nominee;

// TODO: Auto-generated Javadoc
/**
 * The Interface NomineeRepository.
 */
@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Long>{
	
	/**
	 * Gets the nominee by order id.
	 *
	 * @param OrderId the order id
	 * @return the nominee by order id
	 */
	@Query("select n from Nominee n where n.userPlanDetail=:orderid")
	public Nominee getNomineeByOrderId(@Param("orderid") Long OrderId);
	
	/**
	 * Delete nominee by order id.
	 *
	 * @param OrderId the order id
	 */
	@Query("delete from Nominee n where n.userPlanDetail=:orderid")
	public void deleteNomineeByOrderId(@Param("orderid") Long OrderId);
	
}
