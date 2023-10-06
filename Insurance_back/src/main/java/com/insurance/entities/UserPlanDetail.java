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
 * The Class UserPlanDetail.
 */
@Entity

/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * Instantiates a new user plan detail.
 *
 * @param orderId the order id
 * @param startDate the start date
 * @param EndDate the end date
 * @param amountPaid the amount paid
 * @param premiumAmount the premium amount
 * @param sumAssured the sum assured
 * @param isVerified the is verified
 * @param duration the duration
 * @param returnAmt the return amt
 * @param count the count
 * @param user the user
 * @param plan the plan
 * @param nominee the nominee
 * @param claim the claim
 */
@AllArgsConstructor

/**
 * Instantiates a new user plan detail.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class UserPlanDetail {

	/** The order id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	/** The start date. */
	@Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date startDate;
	
	/** The End date. */
	@Column(nullable = false,updatable = false)
	private Date EndDate;
	
	/** The amount paid. */
	@Column( nullable = false)
	private Double amountPaid;
	
	/** The premium amount. */
	@Column(nullable = false)
	private Double premiumAmount;
	
	/** The sum assured. */
	private Double sumAssured;
	
	/** The is verified. */
	private Integer isVerified;
	
	/** The duration. */
	private Integer duration;
	
	/** The return amt. */
	private Double returnAmt;
	
	/** The count. */
	private Integer count=0;
	
	/** The user. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private User user;
	
	/** The plan. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Plan plan;
	
	/** The nominee. */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userPlanDetail")
	private List<Nominee> nominee;
	
	/** The claim. */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userPlanDetail")
	private List<Claim> claim;
}
