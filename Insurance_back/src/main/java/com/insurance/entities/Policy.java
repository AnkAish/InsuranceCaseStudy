package com.insurance.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * The Class Policy.
 */
@Entity

/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * Instantiates a new policy.
 *
 * @param policyId the policy id
 * @param policyName the policy name
 * @param policyDetail the policy detail
 * @param plan the plan
 */
@AllArgsConstructor

/**
 * Instantiates a new policy.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class Policy {
	
	/** The policy id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policyId;
	
	/** The policy name. */
	@Column(unique = true,nullable = false)
	private String policyName;
	
	/** The policy detail. */
	@Column(length = 5000,nullable = false)
	private String policyDetail;
	
	/** The plan. */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "policy")
	private List<Plan> plan;
}
