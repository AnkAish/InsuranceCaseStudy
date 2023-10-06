package com.insurance.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entities.Policy;
import com.insurance.repository.PolicyRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PolicyServiceImplTest.
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {PolicyServiceImplTest.class})
class PolicyServiceImplTest {

	/** The policy service. */
	@InjectMocks
	private PolicyServiceImpl policyService;
	
	/** The policy repository. */
	@Mock
	private PolicyRepository policyRepository;
	
	/**
	 * Adds the policy test.
	 */
	@Test
	@Order(3)
	public void addPolicyTest() {
		Policy policy =new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		 Mockito.when(policyRepository.save(policy)).thenReturn(policy);
		   assertEquals(policy, policyService.addPolicy(policy));
	}
	
	/**
	 * Gets the all test.
	 *
	 * @return the all test
	 */
	@Test
	@Order(1)
	public void getAllTest() {
		when(policyRepository.findAll()).thenReturn(Stream.of(new Policy((long)33,"Policy Test","policy is just added for the testing",null)).collect(Collectors.toList()));
		assertEquals(1, policyService.getAll().size());
	}
	
	/**
	 * Delete by id.
	 */
	@Test
	@Order(5)
	public void deleteById() {
		Policy policy =new Policy();
		policy.setPolicyId((long)33);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		policyService.deleteById(policy.getPolicyId());
		verify(policyRepository,times(1)).deleteById(policy.getPolicyId());
	}
	
	/**
	 * Gets the policy by id.
	 *
	 * @return the policy by id
	 */
	@Test
	@Order(2)
	public void getPolicyById() {
		Policy policy =new Policy();
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		when(policyRepository.findById(policy.getPolicyId())).thenReturn(Optional.of(policy));
		assertNotNull(policyService.getPolicyById(policy.getPolicyId()));
	}
	
	/**
	 * Update policy test.
	 */
	@Test
	@Order(4)
	public void updatePolicyTest() {
		Policy policy =new Policy();
		policy.setPolicyId((long)33);
		policy.setPolicyName("Policy Test");
		policy.setPolicyDetail("this policy is just added for the testing");
		when(policyRepository.save(policy)).thenReturn(policy);
		policyService.updatePolicy(policy, policy.getPolicyId());
		verify(policyRepository,times(1)).save(policy);
	}
}
