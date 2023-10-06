package com.insurance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.entities.Claim;
import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.UserPlanDetail;
import com.insurance.services.impl.ClaimServiceImpl;
import com.insurance.services.impl.UserPlanDetailServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class UnderWriterControllerTest.
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {UnderWriterControllerTest.class})
class UnderWriterControllerTest {

	/** The writer controller. */
	@InjectMocks
	private UnderWriterController writerController;
	
	/** The claim service. */
	@Mock
	private ClaimServiceImpl claimService;

	/** The user plan service. */
	@Mock
	private UserPlanDetailServiceImpl userPlanService;
	
	/**
	 * Test get user plans.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void test_getUserPlans() {
		Date date3=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyId((long)123);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date3,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		List<UserPlanDetail> userPlans=new ArrayList<>();
		userPlans.add(userPlan);
		when(userPlanService.getPlansByIsVerified(1)).thenReturn(userPlans);
		ResponseEntity<List<UserPlanDetail>> res = writerController.getUserPlansByVerified(userPlan.getIsVerified());
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}

	/**
	 * Test get user plan by id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(2)
	public void test_getUserPlanById() {
		Date date3=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyId((long)123);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date3,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,0,12,(double)12000,12,null,plan,null,null);
		when(userPlanService.getUserPlanById(userPlan.getOrderId())).thenReturn(userPlan);
		 ResponseEntity<UserPlanDetail> res = writerController.getUserPlanById(userPlan.getOrderId());
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(userPlan.getOrderId(), res.getBody().getOrderId());
	}
	
	/**
	 * Test get all claims by status.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(3)
	public void test_getAllClaimsByStatus() {
		Date date=new Date(2021, 10, 10);
		Claim claim=new Claim((long)34, (double)220000, 1,date , "Reason", null, null);
		List<Claim> claims=new ArrayList<>();
		claims.add(claim);
		when(claimService.getClaimsByClaimStatus(claim.getClaimStatus())).thenReturn(claims);
		ResponseEntity<List<Claim>> res = writerController.getClaimsByStatus(claim.getClaimStatus());
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get claims by id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(4)
	public void test_getClaimsById() {
		Date date=new Date(2021, 10, 10);
		Claim claim=new Claim((long)34, (double)220000, 1,date , "Reason", null, null);
		when(claimService.getClaimById(claim.getClaimId())).thenReturn(claim);
		 ResponseEntity<Claim> res = writerController.getClaimById(claim.getClaimId());
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(claim.getClaimId(), res.getBody().getClaimId());
	}
	
//	@SuppressWarnings("deprecation")
//	@Test
//	@Order(5)
//	public void test_verifyUserPlan() {
//		Date date3=new Date(2021, 10, 10);
//		Policy policy=new Policy();
//		policy.setPolicyId((long)123);
//		policy.setPolicyName("Policy Test");
//		policy.setPolicyDetail("this policy is just added for the testing");
//		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date3,"plan is just for testing",10,(double)1000,null,policy);
//		Date date1=new Date(2021, 10, 10);
//		Date date2=new Date(2051, 10, 10);
//		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,0,(double)12,(double)12000,12,null,plan,null,null);
//		when(userPlanService.getUserPlanById(userPlan.getOrderId())).thenReturn(userPlan);
//		when(userPlanService.verifyUserPlan(userPlan)).thenReturn(userPlan);
//		ResponseEntity<UserPlanDetail> res = writerController.verifyUserPlan(userPlan);
//		assertEquals(HttpStatus.CREATED, res.getStatusCode());
//		assertEquals(userPlan.getOrderId(), res.getBody().getOrderId());
//	}

}
