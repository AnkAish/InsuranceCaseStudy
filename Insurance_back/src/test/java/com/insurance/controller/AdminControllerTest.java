package com.insurance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.User;
import com.insurance.entities.UserPlanDetail;
import com.insurance.services.impl.PlanServiceImpl;
import com.insurance.services.impl.PolicyServiceImpl;
import com.insurance.services.impl.UserPlanDetailServiceImpl;
import com.insurance.services.impl.UserServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminControllerTest.
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {AdminControllerTest.class})
class AdminControllerTest {
	
	/** The policy service. */
	@Mock
	private PolicyServiceImpl policyService;
	
	/** The plan service. */
	@Mock
	private PlanServiceImpl planService;
	
	/** The user service. */
	@Mock
	private UserServiceImpl userService;
	
	/** The user plan service. */
	@Mock
	private UserPlanDetailServiceImpl userPlanService;
	
	/** The admin controller. */
	@InjectMocks
	private AdminController adminController;

	/**
	 * Test get policies.
	 */
	@Test
	@Order(1)
	public void test_getPolicies() {
		Policy policy =new Policy();
		policy.setPolicyId((long)33);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		List<Policy> policies=new ArrayList<>();
		policies.add(policy);
		
		when(policyService.getAll()).thenReturn(policies);
		ResponseEntity<List<Policy>> res = adminController.getPolicies();
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get policy by id.
	 */
	@Test
	@Order(2)
	public void test_getPolicyById() {
		
		Policy policy = new Policy((long)33,"Policy Test","policy is just added for the testing",null);
		Long policyId = (long)33;
		when(policyService.getPolicyById(policyId)).thenReturn(Optional.of(policy));
		 ResponseEntity<Policy> res = adminController.getPolicy(policyId);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(policyId, res.getBody().getPolicyId());
	}

	/**
	 * Test add policy.
	 */
	@Test
	@Order(3)
	public void test_addPolicy() {
		Policy policy =new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		when(policyService.addPolicy(policy)).thenReturn(policy);
		ResponseEntity<Policy> res = adminController.addPolicy(policy);	
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(policy, res.getBody());
	}
	
	/**
	 * Test delete policy test.
	 */
	@Test
	@Order(4)
	public void test_deletePolicyTest() {
		Policy policy =new Policy();
		policy.setPolicyId((long)33);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		when(policyService.getPolicyById(policy.getPolicyId())).thenReturn(Optional.of(policy));
		ResponseEntity<Void> res = adminController.deletePolicy(policy.getPolicyId());
		assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
		
	}
	
	/**
	 * Test get plans.
	 */
	@Test
	@Order(5)
	public void test_getPlans() {
		@SuppressWarnings("deprecation")
		Date date=new Date(2021, 10, 10);
		List<Plan> plans=new ArrayList<>();
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		plans.add(plan);
		
		when(planService.getAll()).thenReturn(plans);
		ResponseEntity<List<Plan>> res = adminController.getPlans();
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get plans by id.
	 */
	@Test
	@Order(6)
	public void test_getPlansById() {
		@SuppressWarnings("deprecation")
		Date date=new Date(2021, 10, 10);
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		Long planId = (long)33;
		when(planService.getPlanById(planId)).thenReturn(Optional.of(plan));
		 ResponseEntity<Plan> res = adminController.getPlan(planId);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(planId, res.getBody().getPlanId());
	}
	
	/**
	 * Test add plan.
	 */
	@Test
	@Order(7)
	public void test_addPlan() {
		@SuppressWarnings("deprecation")
		Date date=new Date(2021, 10, 10);
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		when(planService.addPlan(plan)).thenReturn(plan);
		ResponseEntity<Plan> res = adminController.addPlan(plan);	
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(plan, res.getBody());
	}
	
	/**
	 * Test delete plan test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(8)
	public void test_deletePlanTest() {
		Date date=new Date(2021, 10, 10);
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		when(planService.getPlanById(plan.getPlanId())).thenReturn(Optional.of(plan));
		ResponseEntity<Void> res = adminController.deletePlan(plan.getPlanId());
		assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
		
	}
	
	/**
	 * Test get all users.
	 */
	@Test
	@Order(9)
	public void test_getAllUsers() {
		User user =new User();
		user.setName("Arhaan");
		user.setEmail("arhaan123mail.com");
		user.setAdharNo((long) 123456789098.00);
		user.setContactNo("1234567890");
		user.setPassword("1234567");
		user.setGender("male");
		user.setIsAlcoholer(1);
		user.setIsSmoker(0);
		user.setAge(20);
		user.setRole("NORMAL");
		@SuppressWarnings("deprecation")
		Date date=new Date(2009, 11, 12);
		user.setDob(date);
		List<User> users= new ArrayList<>();
		users.add(user);
		when(userService.getUsersByRole(user.getRole())).thenReturn(users);
		ResponseEntity<List<User>> res = adminController.get();
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}

	/**
	 * Test get user by id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(10)
	public void test_getUserById() {
		User user =new User();
		user.setName("Arhaan");
		user.setEmail("arhaan123mail.com");
		user.setAdharNo((long) 123456789098.00);
		user.setContactNo("1234567890");
		user.setPassword("1234567");
		user.setGender("male");
		user.setIsAlcoholer(1);
		user.setIsSmoker(0);
		user.setAge(20);
		user.setRole("NORMAL");
		Date date=new Date(2009, 11, 12);
		user.setDob(date);
		List<User> users= new ArrayList<>();
		users.add(user);
		when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));
		 ResponseEntity<User> res = adminController.getUser(user.getId());
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(user.getId(), res.getBody().getId());
	}
	
	/**
	 * Test delete user test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(11)
	public void test_deleteUserTest() {
		Date date=new Date(2009, 11, 12);
		User user = new User((long)33,"Arhaan","arhaan123@gmail.com","Arbaz@123","1234567890","male",date,(long)123456789098.00,1,0,"NORMAL",20,null,null);
		when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));
		ResponseEntity<Void> res = adminController.delete(user.getId());
		assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
		
	}
	
	/**
	 * Test get all user plans.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(12)
	public void test_getAllUserPlans() {
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
		User user =new User();
		user.setName("Arhaan");
		user.setEmail("arhaan123mail.com");
		user.setAdharNo((long) 123456789098.00);
		user.setContactNo("1234567890");
		user.setPassword("1234567");
		user.setGender("male");
		user.setIsAlcoholer(1);
		user.setIsSmoker(0);
		user.setAge(20);
		user.setRole("NORMAL");
		Date date=new Date(2009, 11, 12);
		user.setDob(date);
		user.setUserPlanDetails(userPlans);
		when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));
		ResponseEntity<List<UserPlanDetail>> res = adminController.getPlansByPolicy(user.getId());
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test update policy.
	 */
	@Test
	@Order(13)
	public void test_updatePolicy() {
		Policy policy =new Policy();
		policy.setPolicyId((long)33);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		when(policyService.getPolicyById(policy.getPolicyId())).thenReturn(Optional.of(policy));
		
	}

}
