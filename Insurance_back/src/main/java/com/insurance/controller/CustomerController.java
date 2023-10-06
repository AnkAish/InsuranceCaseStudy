package com.insurance.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Claim;
import com.insurance.entities.Nominee;
import com.insurance.entities.Plan;
import com.insurance.entities.User;
import com.insurance.entities.UserPlanDetail;
import com.insurance.services.impl.ClaimServiceImpl;
import com.insurance.services.impl.NomineeServiceImpl;
import com.insurance.services.impl.PlanServiceImpl;
import com.insurance.services.impl.UserPlanDetailServiceImpl;
import com.insurance.services.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@Slf4j
public class CustomerController {

	/** The nominee service. */
	/* Nominee Service Starts */
	@Autowired
	private NomineeServiceImpl nomineeService;

	/**
	 * Gets the in.
	 *
	 * @param orderId the order id
	 * @return the in
	 */
	// Get Nominee of Particular Subscribed Plan
	@GetMapping("/getNominee/{orderId}")
	public ResponseEntity<Nominee> getin(@PathVariable("orderId") Long orderId) {
		log.info("Inside getNomineeByOrderId function of CustomerController");
		UserPlanDetail planDetail = this.userPlanDetailService.getUserPlanById(orderId);
		Nominee b = planDetail.getNominee().get(0);
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/**
	 * Adds the nominee.
	 *
	 * @param nominee the nominee
	 * @return the response entity
	 */
	// Add Nominee
	@PostMapping("/nominee")
	public ResponseEntity<Nominee> addNominee(@RequestBody Nominee nominee) {
		Nominee b = null;
		try {
			log.info("Inside insertNominee function of CustomerController");
			b = this.nomineeService.addNominee(nominee);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Delete.
	 *
	 * @param orderId the order id
	 * @return the response entity
	 */
	// Delete Nominee of Particular Subscribed Plan
	@DeleteMapping("/nominee/{orderId}")
	public ResponseEntity<Void> delete(@PathVariable("orderId") Long orderId) {
		UserPlanDetail planDetail = this.userPlanDetailService.getUserPlanById(orderId);
		Nominee b = planDetail.getNominee().get(0);
		try {
			log.info("Inside deleteNomineeByOrderId function of CustomerController");
			this.nomineeService.deleteNominee(b.getNomineeId());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/**
	 * Update nominee.
	 *
	 * @param nominee the nominee
	 * @param orderId the order id
	 * @return the response entity
	 */
	// Update Nominee of Particular Subscribed Plan
	@PutMapping("/nominee/{orderId}")
	public ResponseEntity<Nominee> updateNominee(@RequestBody Nominee nominee, @PathVariable("orderId") Long orderId) {
		UserPlanDetail planDetail = this.userPlanDetailService.getUserPlanById(orderId);
		Nominee b = planDetail.getNominee().get(0);
		try {
			log.info("Inside updateNomineeByOrderId function of CustomerController");
			this.nomineeService.updateNominee(nominee, b.getNomineeId());
			return ResponseEntity.ok().body(nominee);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* Nominee Service Ends */
	/** ********************************************. */

	/* UserPlan Service Starts */
	@Autowired
	private UserPlanDetailServiceImpl userPlanDetailService;

	/**
	 * Gets the user plan.
	 *
	 * @param orderId the order id
	 * @return the user plan
	 */
	// Get UserPlans for Particular User By It's OrderId
	@GetMapping("/userPlanDetail/{orderId}")
	public ResponseEntity<UserPlanDetail> getUserPlan(@PathVariable("orderId") Long orderId) {
		log.info("Inside getUserPlanByOrderId function of CustomerController");
		UserPlanDetail userPlanById = this.userPlanDetailService.getUserPlanById(orderId);
		if (userPlanById == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(userPlanById);
	}

	/**
	 * Gets the user plan by user.
	 *
	 * @param id the id
	 * @return the user plan by user
	 */
	// Get UserPlans for Particular User By It's UserId
	@GetMapping("/userPlanDetail1/{id}")
	public ResponseEntity<List<UserPlanDetail>> getUserPlanByUser(@PathVariable("id") Long id) {
		log.info("Inside getUserPlanByUserId function of CustomerController");
		User u = this.userService.getUserById(id).get();
		List<UserPlanDetail> list = u.getUserPlanDetails();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	/**
	 * Adds the user plan detail.
	 *
	 * @param userPlanDetail the user plan detail
	 * @return the response entity
	 */
	// Add UserPlan
	@PostMapping("/userPlanDetail")
	public ResponseEntity<UserPlanDetail> addUserPlanDetail(@RequestBody UserPlanDetail userPlanDetail) {
		try {
			log.info("Inside insertUserPlan function of CustomerController");
			UserPlanDetail b = this.userPlanDetailService.addUserPlanDetail(userPlanDetail);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Delete user plan.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	// Delete UserPlan By It's ID
	@DeleteMapping("/userPlanDetail/{id}")
	public ResponseEntity<Void> deleteUserPlan(@PathVariable("id") Long id) {
		try {
			log.info("Inside deleteUserPlanById function of CustomerController");
			this.userPlanDetailService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/**
	 * Update count.
	 *
	 * @param orderId the order id
	 * @return the response entity
	 */
	// Pay Premium
	@PutMapping("/updateCount/{orderId}")
	public ResponseEntity<Void> updateCount(@PathVariable("orderId") Long orderId) {
		UserPlanDetail planDetail = this.userPlanDetailService.getUserPlanById(orderId);
		planDetail.setCount(planDetail.getCount() - 1);
		planDetail.setAmountPaid(planDetail.getAmountPaid() + planDetail.getPremiumAmount());
		try {
			log.info("Inside payPremium function of CustomerController");
			this.userPlanDetailService.updateUserPlanDetail(planDetail, orderId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* UserPlan Service Ends */
	/** ********************************************. */

	/* Claim Service Ends */
	@Autowired
	private ClaimServiceImpl claimService;

	/**
	 * Gets the claim by user id.
	 *
	 * @param id the id
	 * @return the claim by user id
	 */
	// Get All Claims of Particular User
	@GetMapping("/claim/{id}")
	public ResponseEntity<List<Claim>> getClaimByUserId(@PathVariable("id") Long id) {
		log.info("Inside getClaimsByUserId function of CustomerController");
		User u = this.userService.getUserById(id).get();
		List<Claim> claims = u.getClaim();
		if (claims.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(claims);
	}

	/**
	 * Adds the claim.
	 *
	 * @param claim the claim
	 * @param orderId the order id
	 * @return the response entity
	 */
	// Add Claim
	@PostMapping("/claim/{orderId}")
	public ResponseEntity<Claim> addClaim(@RequestBody Claim claim,@PathVariable("orderId") Long orderId) {
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		claim.setGenerationDate(d);
		
		UserPlanDetail userPlanById = this.userPlanDetailService.getUserPlanById(orderId);
		userPlanById.setIsVerified(3);
		try {
			log.info("Inside insertClaimByOrderId function of CustomerController");
			Claim b = this.claimService.addClaim(claim);
			this.userPlanDetailService.updateUserPlanDetail(userPlanById, orderId);
			return ResponseEntity.ok().body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* Claim Service Ends */
	/** ********************************************. */

	@Autowired
	private UserServiceImpl userService;
	
	/** The plan service. */
	@Autowired
	private PlanServiceImpl planService;

	/**
	 * Show plans.
	 *
	 * @param test the test
	 * @return the response entity
	 */
	@SuppressWarnings("deprecation")
	@GetMapping("/showPlans/{arr}")
	public ResponseEntity<UserPlanDetail> showPlans(@PathVariable("arr") Long[] test) {
		log.info("Inside showPlans(according to user) function of CustomerController");
		User user = this.userService.getUserById(test[0]).get();
		Plan plan = this.planService.getPlanById(test[1]).get();
		UserPlanDetail userPlan = new UserPlanDetail();

		// Inserting all the fields in userPlanDetail
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		// Set Today's Date
		userPlan.setStartDate(d);
		Date d1 = new Date(millis);
		d1.setYear(d1.getYear() + plan.getPlanValidity());
		// Set Ending Date
		userPlan.setEndDate(d1);
		Integer y = 5 + user.getIsSmoker() + 2 * user.getIsAlcoholer();
		Double premiumAmt = plan.getBaseValue() + (y * plan.getBaseValue() * user.getAge()) / 100;
		// Set Premium Amount on basis of some factors
		userPlan.setPremiumAmount(premiumAmt);
		// Set Duration to pay premium
		userPlan.setDuration((int) (0.6 * plan.getPlanValidity()));
		// Set Amount Paid as 0
		userPlan.setAmountPaid(0.0);
		Integer count = (int) ((userPlan.getDuration()) * 12 / plan.getPaymentFrequency());
		userPlan.setCount(count);
		Double x = premiumAmt * (userPlan.getDuration() * 12) / plan.getPaymentFrequency();
		// Set total Cover
		userPlan.setSumAssured(((100 + plan.getMaxAge() - 1 + plan.getPlanValidity() - user.getAge()) * x) / 100);
		userPlan.setIsVerified(1);
		if (plan.getPlanType() != "Term")
			userPlan.setReturnAmt(premiumAmt * userPlan.getDuration() * 12 * 1.05);
//		if(plan.getPlanType()=="Money Back")
//			userPlan.setReturPerYear(userPlan.getReturnAmt()*0.15);

		return ResponseEntity.status(HttpStatus.CREATED).body(userPlan);
	}

	/* User Service Starts */
	/** The password encoder. */
	// Update User By It's ID
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping("/updateName/{id}")
	public ResponseEntity<User> updateUserName(@RequestBody String name, @PathVariable("id") Long id) {
		log.info("Inside updateUserName function of CustomerController");
		User u1=this.userService.getUserById(id).get();
		u1.setName(name);
		try {
			this.userService.updateUser(u1, id);
			return ResponseEntity.ok().body(u1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/updateContact/{id}")
	public ResponseEntity<User> updateUserContactNo(@RequestBody String contactNo, @PathVariable("id") Long id) {
		log.info("Inside updateUserContact function of CustomerController");
		User u1=this.userService.getUserById(id).get();
		u1.setContactNo(contactNo);
		try {
			this.userService.updateUser(u1, id);
			return ResponseEntity.ok().body(u1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/updatePassword/{id}")
	public ResponseEntity<User> updateUserPassword(@RequestBody String password, @PathVariable("id") Long id) {
		log.info("Inside updateUserPassword function of CustomerController");
		User u1=this.userService.getUserById(id).get();
		u1.setPassword(passwordEncoder.encode(password));
		try {
			this.userService.updateUser(u1, id);
			return ResponseEntity.ok().body(u1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	/* User Service Ends */
	/***********************************************/
}
