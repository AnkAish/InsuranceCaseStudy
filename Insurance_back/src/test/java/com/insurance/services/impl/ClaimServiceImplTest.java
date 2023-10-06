package com.insurance.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entities.Claim;
import com.insurance.repository.ClaimRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaimServiceImplTest.
 */
@SpringBootTest(classes = {ClaimServiceImplTest.class})
class ClaimServiceImplTest {

	/** The claim service. */
	@InjectMocks
	private ClaimServiceImpl claimService;
	
	/** The claim repository. */
	@Mock
	private ClaimRepository claimRepository;
	
	/**
	 * Gets the all test.
	 *
	 * @return the all test
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void getAllTest() {
		Date date=new Date(2021, 10, 10);
		when(claimRepository.findAll()).thenReturn(Stream.of(new Claim((long)33,(double)550000,1,date,"Reason",null,null)).collect(Collectors.toList()));
		assertEquals(1, claimService.getAll().size());
	}
	
	/**
	 * Gets the claim by id test.
	 *
	 * @return the claim by id test
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(2)
	public void getClaimByIdTest() {
		Date date=new Date(2021, 10, 10);
		Claim claim=new Claim((long)33,(double)550000,1,date,"Reason",null,null);
		when(claimRepository.findById(claim.getClaimId())).thenReturn(Optional.of(claim));
		assertNotNull(claimService.getClaimById(claim.getClaimId()));
	}
	
	/**
	 * Adds the claim test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(3)
	public void addClaimTest() {
		Date date=new Date(2021, 10, 10);
		Claim claim=new Claim((long)33,(double)550000,1,date,"Reason",null,null);
		 Mockito.when(claimRepository.save(claim)).thenReturn(claim);
		   assertEquals(claim, claimService.addClaim(claim));
	}
	
	/**
	 * Update claim test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(4)
	public void updateClaimTest() {
		Date date=new Date(2021, 10, 10);
		Claim claim=new Claim();
		claim.setClaimId((long)33);
		claim.setClaimAmount((double)550000);
		claim.setClaimStatus(1);
		claim.setGenerationDate(date);
		when(claimRepository.save(claim)).thenReturn(claim);
		claimService.updateClaim(claim, claim.getClaimId());
		verify(claimRepository,times(1)).save(claim);
	}
	
	/**
	 * Delete by id.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(5)
	public void deleteById() {
		Date date=new Date(2021, 10, 10);
		Claim claim=new Claim((long)33,(double)550000,1,date,"Reason",null,null);
		claimService.deleteById(claim.getClaimId());
		verify(claimRepository,times(1)).deleteById(claim.getClaimId());
	}
	
	
}
