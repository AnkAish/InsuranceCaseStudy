package com.insurance.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entities.Nominee;
import com.insurance.entities.Plan;
import com.insurance.entities.Policy;
import com.insurance.entities.UserPlanDetail;
import com.insurance.repository.NomineeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class NomineeServiceImplTest.
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {NomineeServiceImplTest.class})
class NomineeServiceImplTest {

	/** The nominee service impl. */
	@InjectMocks
	private NomineeServiceImpl nomineeServiceImpl;
	
	/** The nominee repository. */
	@Mock
	private NomineeRepository nomineeRepository;
	
	/**
	 * Adds the nominee test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void addNomineeTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Nominee nominee = new Nominee((long)33,"Arhaan" , "arhaan610@gmail.com", "5, lajpat nagar", "male", date, 70479, "Brother", userPlan);
		Mockito.when(nomineeRepository.save(nominee)).thenReturn(nominee);
		assertEquals(nominee, nomineeServiceImpl.addNominee(nominee));
	}
	
	/**
	 * Gets the nominee by order id test.
	 *
	 * @return the nominee by order id test
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(2)
	public void getNomineeByOrderIdTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Nominee nominee = new Nominee((long)33,"Arhaan" , "arhaan610@gmail.com", "5, lajpat nagar", "male", date, 70479, "Brother", userPlan);
		when(nomineeRepository.getNomineeByOrderId(userPlan.getOrderId())).thenReturn(nominee);
		assertNotNull(nomineeServiceImpl.getNomineeByOrderId(userPlan.getOrderId()));
	}
	
	/**
	 * Delete nominee by id test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(4)
	public void deleteNomineeByIdTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Nominee nominee = new Nominee((long)33,"Arhaan" , "arhaan610@gmail.com", "5, lajpat nagar", "male", date, 70479, "Brother", userPlan);
		nomineeServiceImpl.deleteNominee(nominee.getNomineeId());
		verify(nomineeRepository,times(1)).deleteById(nominee.getNomineeId());
	}
	
	/**
	 * Update nominee test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(3)
	public void updateNomineeTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Date date1=new Date(2021, 10, 10);
		Date date2=new Date(2051, 10, 10);
		UserPlanDetail userPlan=new UserPlanDetail((long)33,date1,date2,(double)0,(double)1200,(double)220000,1,12,(double)12000,12,null,plan,null,null);
		Nominee nominee = new Nominee((long)33,"Arhaan" , "arhaan610@gmail.com", "5, lajpat nagar", "male", date, 70479, "Brother", userPlan);
		when(nomineeRepository.save(nominee)).thenReturn(nominee);
		nomineeServiceImpl.updateNominee(nominee, nominee.getNomineeId());
		verify(nomineeRepository,times(1)).save(nominee);
	}
}
