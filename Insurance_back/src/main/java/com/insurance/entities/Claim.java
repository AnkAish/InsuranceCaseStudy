package com.insurance.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * The Class Claim.
 */
@Entity

/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString

/**
 * Instantiates a new claim.
 *
 * @param claimId the claim id
 * @param claimAmount the claim amount
 * @param claimStatus the claim status
 * @param generationDate the generation date
 * @param reason the reason
 * @param user the user
 * @param userPlanDetail the user plan detail
 */
@AllArgsConstructor

/**
 * Instantiates a new claim.
 */
@NoArgsConstructor
public class Claim {

	/** The claim id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long claimId;
	
	/** The claim amount. */
	@Column(nullable = false)
	private Double claimAmount;
	
	/** The claim status. */
	@Column(nullable = false)
	private Integer claimStatus;
	
	/** The generation date. */
	@Column(nullable = false)
	private Date generationDate;
	
	/** The reason. */
	@Column(nullable = false)
	private String reason;
	
	/** The user. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private User user;
	
//	@OneToOne
//	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//	private Nominee nominee;
	
	/** The user plan detail. */
@ManyToOne
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private UserPlanDetail userPlanDetail;

}
