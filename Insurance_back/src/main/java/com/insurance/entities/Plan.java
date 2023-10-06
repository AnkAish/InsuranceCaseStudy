package com.insurance.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * The Class Plan.
 */
@Entity

/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * Instantiates a new plan.
 *
 * @param planId the plan id
 * @param planName the plan name
 * @param planType the plan type
 * @param minAge the min age
 * @param maxAge the max age
 * @param planValidity the plan validity
 * @param planCreationDate the plan creation date
 * @param planDescription the plan description
 * @param paymentFrequency the payment frequency
 * @param baseValue the base value
 * @param userPlanDetail the user plan detail
 * @param policy the policy
 */
@AllArgsConstructor

/**
 * Instantiates a new plan.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class Plan {

	/** The plan id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long planId;
	
	/** The plan name. */
	@Column(unique = true,nullable = false)
	private String planName;
	
	/** The plan type. */
	private String planType;
	
	/** The min age. */
	@Column(nullable = false)
	private Integer minAge;
	
	/** The max age. */
	@Column(nullable = false)
	private Integer maxAge;
	
	/** The plan validity. */
	@Column(nullable = false)
	private Integer planValidity;
	
	/** The plan creation date. */
	@Column(updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date planCreationDate;
	
	/** The plan description. */
	@Column(nullable = false,length = 100000)
	private String planDescription;
	
	/** The payment frequency. */
	@Column(nullable = false)
	private Integer paymentFrequency;
	
	/** The base value. */
	@Column(nullable = false)
	private Double baseValue;
	
	/** The user plan detail. */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "plan")
	private List<UserPlanDetail> userPlanDetail;

	/** The policy. */
	@ManyToOne
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Policy policy;
}
