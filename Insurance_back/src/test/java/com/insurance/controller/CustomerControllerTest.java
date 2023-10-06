package com.insurance.controller;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.entities.Claim;
import com.insurance.entities.Nominee;
import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.User;
import com.insurance.entities.UserPlanDetail;
import com.insurance.services.impl.ClaimServiceImpl;
import com.insurance.services.impl.NomineeServiceImpl;
import com.insurance.services.impl.UserPlanDetailServiceImpl;
import com.insurance.services.impl.UserServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerControllerTest.
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {CustomerControllerTest.class})
class CustomerControllerTest {
	
	/** The user service. */
	@Mock
	private UserServiceImpl userService;
	
	/** The user plan service. */
	@Mock
	private UserPlanDetailServiceImpl userPlanService;
	
	/** The claim service. */
	@Mock
	private ClaimServiceImpl claimService;
	
	/** The nominee service. */
	@Mock
	private NomineeServiceImpl nomineeService;
	
	/** The customer controller. */
	@InjectMocks
	private CustomerController customerController;
	
	/**
	 * Test get all user plans by user.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void test_getAllUserPlansByUser() {
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
		ResponseEntity<List<UserPlanDetail>> res = customerController.getUserPlanByUser(user.getId());
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get nominee by order id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(2)
	public void test_getNomineeByOrderId() {
		Date date1=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyId((long)123);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date1,"plan is just for testing",10,(double)1000,null,policy);
		Date date3=new Date(2001, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Nominee nominee = new Nominee((long)23,"Rehan","rehan123mail.com","4, new malakpet","male",date3,12345678,"brother",null);
		List<Nominee> l=new ArrayList<>();
		l.add(nominee);
		userPlan.setNominee(l);
		when(userPlanService.getUserPlanById(userPlan.getOrderId())).thenReturn(userPlan);
		ResponseEntity<Nominee> res = customerController.getin(userPlan.getOrderId());
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(nominee.getNomineeId(), res.getBody().getNomineeId());
	}
	
	/**
	 * Test add nominee.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(3)
	public void test_addNominee() {
		Date date3=new Date(2001, 10, 10);
		Nominee nominee = new Nominee((long)23,"Rehan","rehan123mail.com","4, new malakpet","male",date3,12345678,"brother",null);
		when(nomineeService.addNominee(nominee)).thenReturn(nominee);
	    ResponseEntity<Nominee> res = customerController.addNominee(nominee);	
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(nominee, res.getBody());
	}
	
	/**
	 * Test delete nominee test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(4)
	public void test_deleteNomineeTest() {
		Date date1=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyId((long)123);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date1,"plan is just for testing",10,(double)1000,null,policy);
		Date date3=new Date(2001, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Nominee nominee = new Nominee((long)23,"Rehan","rehan123mail.com","4, new malakpet","male",date3,12345678,"brother",null);
		List<Nominee> l=new ArrayList<>();
		l.add(nominee);
		userPlan.setNominee(l);
		when(userPlanService.getUserPlanById(userPlan.getOrderId())).thenReturn(userPlan);
		ResponseEntity<Void> res = customerController.delete(userPlan.getOrderId());
		assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
		
	}
	
	
	/**
	 * Test add user plan.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(5)
	public void test_addUserPlan() {
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
		Date date1=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyId((long)123);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date1,"plan is just for testing",10,(double)1000,null,policy);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,user,plan,null,null);
		when(userPlanService.addUserPlanDetail(userPlan)).thenReturn(userPlan);
	    ResponseEntity<UserPlanDetail> res = customerController.addUserPlanDetail(userPlan);	
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(userPlan, res.getBody());
	}
	
	/**
	 * Test get user plan by order id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(6)
	public void test_getUserPlanByOrderId() {
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
		 ResponseEntity<UserPlanDetail> res = customerController.getUserPlan(userPlan.getOrderId());
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(userPlan.getOrderId(), res.getBody().getOrderId());
	}
	
	/**
	 * Test get all user plans.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(7)
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
		ResponseEntity<List<UserPlanDetail>> res = customerController.getUserPlanByUser(user.getId());
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	
	/**
	 * Test get claims by id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(8)
	public void test_getClaimsById() {
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
		Date date1=new Date(2021, 10, 10);
		Claim claim=new Claim((long)34, (double)220000, 1,date1 , "Reason", null, null);
		List<Claim> claims=new ArrayList<>();
		claims.add(claim);
		user.setClaim(claims);
		when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));
		 ResponseEntity<List<Claim>> res = customerController.getClaimByUserId(user.getId());
		 assertEquals(HttpStatus.CREATED,res.getStatusCode());
		 assertEquals(1, res.getBody().size());
	}
}
