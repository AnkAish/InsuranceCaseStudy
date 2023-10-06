package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.User;
import com.insurance.entities.UserPlanDetail;
import com.insurance.services.impl.PlanServiceImpl;
import com.insurance.services.impl.PolicyServiceImpl;
import com.insurance.services.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class AdminController.
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
@Slf4j
public class AdminController {

	/** The user service. */
	/* User Services Starts */
	@Autowired
	private UserServiceImpl userService;

	/**
	 * Gets the.
	 *
	 * @return the response entity
	 */
	// Get All Users
	@GetMapping("/user")
	public ResponseEntity<List<User>> get() {
		log.info("Inside getAllUsers function of AdminController");
		List<User> list = this.userService.getUsersByRole("NORMAL");
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	// Get Particular User By It's ID
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		log.info("Inside getUserById function of AdminController");
		User b = this.userService.getUserById(id).get();
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	// Delete User By It's ID
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			log.info("Inside deleteUserById function of AdminController");
			this.userService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/* User Services Ends */
	/** *************************************. */

	/* Policy Services Starts */
	@Autowired
	private PolicyServiceImpl policyService;

	/**
	 * Gets the policies.
	 *
	 * @return the policies
	 */
	@GetMapping("/policy")
	public ResponseEntity<List<Policy>> getPolicies() {
		log.info("Inside getAllPolicies function of AdminController");
		List<Policy> list = this.policyService.getAll();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	/**
	 * Gets the policy.
	 *
	 * @param id the id
	 * @return the policy
	 */
	// Get Policy By It's ID
	@GetMapping("/policy/{id}")
	public ResponseEntity<Policy> getPolicy(@PathVariable("id") Long id) {
		log.info("Inside getPolicyById function of AdminController");
		Policy b = this.policyService.getPolicyById(id).get();
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/**
	 * Adds the policy.
	 *
	 * @param policy the policy
	 * @return the response entity
	 */
	// Add Policy
	@PostMapping("/policy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
		Policy b = null;
		try {
			log.info("Inside insertPolicy function of AdminController");
			b = this.policyService.addPolicy(policy);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Delete policy.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	// Delete Policy By It's ID
	@DeleteMapping("/policy/{id}")
	public ResponseEntity<Void> deletePolicy(@PathVariable("id") Long id) {
		try {
			log.info("Inside deletePolicyById function of AdminController");
			this.policyService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Update policy.
	 *
	 * @param policy the policy
	 * @param id     the id
	 * @return the response entity
	 */
	// Update Policy By It's ID
	@PutMapping("/policy/{id}")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy, @PathVariable("id") Long id) {
		try {
			log.info("Inside updatePolicyById function of AdminController");
			this.policyService.updatePolicy(policy, id);
			return ResponseEntity.ok().body(policy);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* Policy Services Ends */
	/** *************************************. */

	/* Plans Services Starts */
	@Autowired
	private PlanServiceImpl planService;

	/**
	 * Gets the plans.
	 *
	 * @return the plans
	 */
	// Get All Plans
	@GetMapping("/plan")
	public ResponseEntity<List<Plan>> getPlans() {
		log.info("Inside getAllPlans function of AdminController");
		List<Plan> list = this.planService.getAll();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	/**
	 * Gets the plan.
	 *
	 * @param id the id
	 * @return the plan
	 */
	// Get Plan By It's ID
	@GetMapping("/plan/{id}")
	public ResponseEntity<Plan> getPlan(@PathVariable("id") Long id) {
		log.info("Inside getPlanById function of AdminController");
		Plan b = this.planService.getPlanById(id).get();
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/**
	 * Adds the plan.
	 *
	 * @param plan the plan
	 * @return the response entity
	 */
	// Add Plan
	@PostMapping("/plan")
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan) {
		Plan b = null;
		try {
			log.info("Inside insertPlan function of AdminController");
			b = this.planService.addPlan(plan);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Delete plan.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	// Delete Plan By It,s ID
	@DeleteMapping("/plan/{id}")
	public ResponseEntity<Void> deletePlan(@PathVariable("id") Long id) {
		try {
			log.info("Inside deletePlanById function of AdminController");
			this.planService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/**
	 * Update plan.
	 *
	 * @param plan the plan
	 * @param id   the id
	 * @return the response entity
	 */
	// Update Plan By It's ID
	@PutMapping("/plan/{id}")
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan, @PathVariable("id") Long id) {
		try {
			log.info("Inside updatePlanById function of AdminController");
			this.planService.updatePlan(plan, id);
			return ResponseEntity.ok().body(plan);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* Plans Services Ends */
	/**
	 * *************************************.
	 *
	 * @param id the id
	 * @return the plans by policy
	 */

	/* UserPlan Services Starts */
	// Get UserPlans By User ID
	@GetMapping("/getUserPlans/{id}")
	public ResponseEntity<List<UserPlanDetail>> getPlansByPolicy(@PathVariable("id") Long id) {
		log.info("Inside getUserPlanByUserId function of AdminController");
		User user = this.userService.getUserById(id).get();
		List<UserPlanDetail> userPlans = user.getUserPlanDetails();
		if (userPlans.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(userPlans);
	}

	/* UserPlan Services Ends */
	/****************************************/

}
