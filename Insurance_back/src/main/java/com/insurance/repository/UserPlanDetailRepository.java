package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entities.UserPlanDetail;

/**
 * The Interface UserPlanDetailRepository.
 */
@Repository
public interface UserPlanDetailRepository extends JpaRepository<UserPlanDetail, Long> {
	
	/**
	 * Find by id.
	 *
	 * @param orderId the order id
	 * @return the optional
	 */
	public Optional<UserPlanDetail> findById(Long orderId);
	
	/**
	 * Find by is verified.
	 *
	 * @param isVerified the is verified
	 * @return the list
	 */
	//@Query(value = "select * from user_plan_detail where is_verified=?1",nativeQuery = true)
	public List<UserPlanDetail> findByIsVerified(Integer isVerified);

}
