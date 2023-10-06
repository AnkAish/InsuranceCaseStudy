package com.insurance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.services.impl.PlanServiceImpl;
import com.insurance.services.impl.PolicyServiceImpl;
import com.insurance.services.impl.UserServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeControllerTest.
 */
@SpringBootTest(classes = {HomeControllerTest.class})
class HomeControllerTest {

	/** The policy service. */
	@Mock
	private PolicyServiceImpl policyService;
	
	/** The plan service. */
	@Mock
	private PlanServiceImpl planService;
	
	/** The user service. */
	@Mock
	private UserServiceImpl userService;
	
	/** The home controller. */
	@InjectMocks
	private HomeController homeController;
	
	/**
	 * Test get policies.
	 */
	@Test
	public void test_getPolicies() {
		Policy policy =new Policy();
		policy.setPolicyId((long)33);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		List<Policy> policies=new ArrayList<>();
		policies.add(policy);
		
		when(policyService.getAll()).thenReturn(policies);
		ResponseEntity<List<Policy>> res = homeController.getPolicies();
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get policy by id.
	 */
	@Test
	public void test_getPolicyById() {
		
		Policy policy = new Policy((long)33,"Policy Test","policy is just added for the testing",null);
		Long policyId = (long)33;
		when(policyService.getPolicyById(policyId)).thenReturn(Optional.of(policy));
		 ResponseEntity<Policy> res = homeController.getPolicy(policyId);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(policyId, res.getBody().getPolicyId());
	}
	
	/**
	 * Test get plans.
	 */
	@Test
	public void test_getPlans() {
		@SuppressWarnings("deprecation")
		Date date=new Date(2021, 10, 10);
		List<Plan> plans=new ArrayList<>();
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		plans.add(plan);
		
		when(planService.getAll()).thenReturn(plans);
		ResponseEntity<List<Plan>> res = homeController.getPlans();
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get plans by id.
	 */
	@Test
	public void test_getPlansById() {
		@SuppressWarnings("deprecation")
		Date date=new Date(2021, 10, 10);
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		Long planId = (long)33;
		when(planService.getPlanById(planId)).thenReturn(Optional.of(plan));
		 ResponseEntity<Plan> res = homeController.getPlan(planId);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(planId, res.getBody().getPlanId());
	}
	
	/**
	 * Test get plans by policy id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test_getPlansByPolicyId() {
		Date date=new Date(2021, 10, 10);
		List<Plan> plans=new ArrayList<>();
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		plans.add(plan);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		policy.setPlan(plans);
		when(policyService.getPolicyById(policy.getPolicyId())).thenReturn(Optional.of(policy));
		ResponseEntity<List<Plan>> res = homeController.getPlansByPolicy(policy.getPolicyId());
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
//	
//	@Test
//	public void test_addUser() {
//		User user =new User();
//		user.setId((long)78);
//		user.setName("Arhaan");
//		user.setEmail("arhaan123mail.com");
//		user.setAdharNo((long) 123456789098.00);
//		user.setContactNo("1234567890");
//		user.setPassword("1234567");
//		user.setGender("male");
//		user.setIsAlcoholer(1);
//		user.setIsSmoker(0);
//		user.setAge(20);
//		user.setRole("NORMAL");
//		Date date=new Date(2009, 11, 12);
//		user.setDob(date);
//		user.setRole("NORMAL");
//		when(userService.addUser(user)).thenReturn(user);
//		ResponseEntity<User> res = homeController.addUser(user);
//		assertEquals(HttpStatus.CREATED, res.getStatusCode());
//		assertEquals(user, res.getBody());
//	}
}
