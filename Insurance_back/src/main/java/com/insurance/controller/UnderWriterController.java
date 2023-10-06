package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Claim;
import com.insurance.entities.UserPlanDetail;
import com.insurance.services.impl.ClaimServiceImpl;
import com.insurance.services.impl.UserPlanDetailServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UnderWriterController.
 */
@RestController
@RequestMapping("/writer")
@CrossOrigin("*")
@Slf4j
public class UnderWriterController {

	/** The detail service impl. */
	@Autowired
	private UserPlanDetailServiceImpl detailServiceImpl;
	
	/* UserPlan Service Starts */

	/**
	 * Gets the user plans by verified.
	 *
	 * @param num the num
	 * @return the user plans by verified
	 */
	// Get UserPlans for which isVerified is num
	@GetMapping("/verifyUserPlan/{num}")
	public ResponseEntity<List<UserPlanDetail>> getUserPlansByVerified(@PathVariable("num") Integer num) {
		log.info("Inside verifyUserPlan byIsVerified field of UnderWriterController");
		List<UserPlanDetail> userPlans = this.detailServiceImpl.getPlansByIsVerified(num);
		if (userPlans.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(userPlans);
	}

	/**
	 * Gets the user plan by id.
	 *
	 * @param id the id
	 * @return the user plan by id
	 */
	@GetMapping("/userPlanDetail/{id}")
	public ResponseEntity<UserPlanDetail> getUserPlanById(@PathVariable("id") Long id) {
		log.info("Inside getUserPlanById function of UnderWriterController");
		UserPlanDetail b = detailServiceImpl.getUserPlanById(id);
		if (b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	/**
	 * Verify user plan.
	 *
	 * @param userPlanDetail the user plan detail
	 * @return the response entity
	 */
	@PostMapping("/verifyUserPlan")
	public ResponseEntity<UserPlanDetail> verifyUserPlan(@RequestBody UserPlanDetail userPlanDetail) {
		
		try {
			log.info("Inside verifyUserPlan function of UnderWriterController");
			UserPlanDetail b = this.detailServiceImpl.verifyUserPlan(userPlanDetail);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
//	private static final int INITIALDELAY= 1000;
//	private static final int FIXEDRATE= 1000 * 10 * 1;
//	@Scheduled(cron = "0/30 * * * * ?")
//	//Auto Verify User Plans By Scheduler
//	public ResponseEntity<?> autoVerifyUserPlan() {
//		try {
//			LOGGER.info("Auto Verification Started");
//			List<UserPlanDetail> all = this.detailServiceImpl.getPlansByIsVerified(1);
//			LOGGER.info(all+"");
//			for (UserPlanDetail u : all) {
//				if((u.getUser().getIsSmoker()==0 && u.getUser().getIsAlcoholer()==0)) {
//					u.setIsVerified(2);
//					this.detailServiceImpl.verifyUserPlan(u);
//				}
//			}
//			LOGGER.info("Auto Verification Done");
//			return ResponseEntity.status(HttpStatus.CREATED).body(all);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	} 
	/* UserPlan Service Ends */
	/* **************************************************** */
	/* Claim Service Starts */

	/** The claim service. */
	@Autowired
	private ClaimServiceImpl claimService;

	/**
	 * Gets the claims by status.
	 *
	 * @param num the num
	 * @return the claims by status
	 */
	// Get Claims for which Status is 1
	@GetMapping("/statusClaim/{num}")
	public ResponseEntity<List<Claim>> getClaimsByStatus(@PathVariable("num") Integer num) {
		log.info("Inside getAllClaimsByClaimStatus function of UnderWriterController");
		List<Claim> claims = this.claimService.getClaimsByClaimStatus(num);
		if (claims.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(claims);
	}

	/**
	 * Gets the claim by id.
	 *
	 * @param id the id
	 * @return the claim by id
	 */
	// Get Claim By Its Id
	@GetMapping("/claim/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable("id") Long id) {
		log.info("Inside getClaimByClaimId function of UnderWriterController");
		Claim claim = this.claimService.getClaimById(id);
		if (claim == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(claim);
	}

	/**
	 * Verify claim.
	 *
	 * @param claim the claim
	 * @return the response entity
	 */
	//Verify Claim Request
	@PostMapping("/verifyClaim")
	public ResponseEntity<Claim> verifyClaim(@RequestBody Claim claim) {
		try {
			log.info("Inside verifyClaim function of UnderWriterController");
			Claim b = this.claimService.verifyClaim(claim);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	/* Claim Service Ends */
}
