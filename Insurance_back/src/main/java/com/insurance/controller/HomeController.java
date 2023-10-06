package com.insurance.controller;
	
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.User;
import com.insurance.services.impl.PlanServiceImpl;
import com.insurance.services.impl.PolicyServiceImpl;
import com.insurance.services.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class HomeController.
 */
@RestController
@RequestMapping("/home")
@CrossOrigin("*")
@Slf4j
public class HomeController {

	/** The policy service. */
	@Autowired
	private PolicyServiceImpl policyService;
	/**
	 * Gets the policies.
	 *
	 * @return the policies
	 */
	// Get All Policies
	@GetMapping("/policy")
	public ResponseEntity<List<Policy>> getPolicies() {
		log.info("Inside getAllPolicies function of HomeController");
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
		log.info("Inside getPolicyById function of HomeController");
		Policy b = this.policyService.getPolicyById(id).get();
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/** The plan service. */
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
		log.info("Inside getAllPlans function of HomeController");
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
		log.info("Inside getPlanById function of HomeController");
		Plan b =this.planService.getPlanById(id).get();
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/**
	 * Gets the plans by policy.
	 *
	 * @param policyId the policy id
	 * @return the plans by policy
	 */
	// Get Plans By policy ID
	@GetMapping("/getPlan/{policyId}")
	public ResponseEntity<List<Plan>> getPlansByPolicy(@PathVariable("policyId") Long policyId) {
		log.info("Inside getPlanByPolicyId function of HomeController");
		Policy policy=this.policyService.getPolicyById(policyId).get();
		List<Plan> plans = policy.getPlan();
		if (plans.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(plans);
	}
	
	/** The user service. */
	@Autowired
	private UserServiceImpl userService;
	
	/** The password encoder. */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	// Add OR Register User
	@SuppressWarnings("deprecation")
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		log.info("Inside insertUser function of HomeController");
		User b = null;
		user.setRole("NORMAL");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Date d = user.getDob();
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
		Period p = Period.between(birthday, today);
		user.setAge((p.getYears() - 1900));
		try {
			b = this.userService.addUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
