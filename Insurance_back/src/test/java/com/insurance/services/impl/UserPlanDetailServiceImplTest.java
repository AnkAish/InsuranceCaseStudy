package com.insurance.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.UserPlanDetail;
import com.insurance.repository.UserPlanDetailRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserPlanDetailServiceImplTest.
 */
@SpringBootTest(classes = {UserPlanDetailServiceImplTest.class})
class UserPlanDetailServiceImplTest {

	/** The user plan service. */
	@InjectMocks
	private UserPlanDetailServiceImpl userPlanService;
	
	/** The user plan repository. */
	@Mock
	private UserPlanDetailRepository userPlanRepository;
	
	/**
	 * Gets the all plans test.
	 *
	 * @return the all plans test
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getAllPlansTest() {
		List<UserPlanDetail> u=new ArrayList<>();
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,null,null,null);
		u.add(userPlan);
		when(userPlanRepository.findAll()).thenReturn(u);
		assertEquals(1, userPlanService.getAll().size());
	}
	
	/**
	 * Gets the user plan by id test.
	 *
	 * @return the user plan by id test
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getUserPlanByIdTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		when(userPlanRepository.findById(userPlan.getOrderId())).thenReturn(Optional.of(userPlan));
		assertNotNull(userPlanService.getUserPlanById(userPlan.getOrderId()));
	}
	
	/**
	 * Adds the user plan test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void addUserPlanTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Mockito.when(userPlanRepository.save(userPlan)).thenReturn(userPlan);
		   assertEquals(userPlan, userPlanService.addUserPlanDetail(userPlan));
	}
	
	/**
	 * Delete plan by id test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void deletePlanByIdTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		userPlanService.deleteById(userPlan.getOrderId());
		verify(userPlanRepository,times(1)).deleteById(userPlan.getOrderId());
	}
	
	/**
	 * Gets the all plans by is verified test.
	 *
	 * @return the all plans by is verified test
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getAllPlansByIsVerifiedTest() {
		List<UserPlanDetail> u=new ArrayList<>();
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,null,null,null);
		u.add(userPlan);
		when(userPlanRepository.findByIsVerified(userPlan.getIsVerified())).thenReturn(u);
		assertEquals(1, userPlanService.getPlansByIsVerified(userPlan.getIsVerified()).size());
	}
	
//	@Test
//	public void verifyUserPlanTest() {
//		Policy policy =new Policy();
//		policy.setPolicyId((long)33);
//		policy.setPolicyName("Policy Test");
//		policy.setPolicyDetail("this policy is just added for the testing");
//		Date date=new Date(2021, 10, 10);
//		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
//		Date date1=new Date(2021, 10, 10);
//		Date date2=new Date(2051, 10, 10);
//		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,2,(double)12,(double)12000,12,null,plan,null,null);
//		when(userPlanRepository.save(userPlan)).thenReturn(userPlan);
//		userPlanService.verifyUserPlan(userPlan);
//		verify(userPlanRepository,times(1)).save(userPlan);
//	}

}
