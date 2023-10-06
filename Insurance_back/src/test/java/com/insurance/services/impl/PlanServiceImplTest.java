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
import com.insurance.repository.PlanRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanServiceImplTest.
 */
@SpringBootTest(classes= {PlanServiceImplTest.class})
class PlanServiceImplTest {

	/** The plan service. */
	@InjectMocks
	private PlanServiceImpl planService;
	
	/** The plan repository. */
	@Mock
	private PlanRepository planRepository;
	
	/**
	 * Gets the all test.
	 *
	 * @return the all test
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getAllTest() {
		Date date=new Date(2021, 10, 10);
		List<Plan> l=new ArrayList<>();
		Plan plan=new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,null);
		l.add(plan);
		when(planRepository.findAll()).thenReturn(l);
		assertEquals(1, planService.getAll().size());
	}
	
	/**
	 * Gets the plan by id test.
	 *
	 * @return the plan by id test
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getPlanByIdTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		when(planRepository.findById(plan.getPlanId())).thenReturn(Optional.of(plan));
		assertNotNull(planService.getPlanById(plan.getPlanId()));
	}
	
	/**
	 * Adds the plan test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void addPlanTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		Mockito.when(planRepository.save(plan)).thenReturn(plan);
		   assertEquals(plan, planService.addPlan(plan));
	}
	
	/**
	 * Delete plan by id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void deletePlanById() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		planService.deleteById(plan.getPlanId());
		verify(planRepository,times(1)).deleteById(plan.getPlanId());
	}
	
	/**
	 * Update plan test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void updatePlanTest() {
		Date date=new Date(2021, 10, 10);
		Policy policy=new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		Plan plan =new Plan((long)33,"Test Plan","Endowment",20,40,20,date,"plan is just for testing",10,(double)1000,null,policy);
		when(planRepository.save(plan)).thenReturn(plan);
		planService.updatePlan(plan, plan.getPlanId());
		verify(planRepository,times(1)).save(plan);
	}
}
