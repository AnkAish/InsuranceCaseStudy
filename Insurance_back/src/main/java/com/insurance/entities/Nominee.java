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
 * The Class Nominee.
 */
@Entity

/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * Instantiates a new nominee.
 *
 * @param nomineeId the nominee id
 * @param name the name
 * @param email the email
 * @param address the address
 * @param gender the gender
 * @param dob the dob
 * @param contactNo the contact no
 * @param relation the relation
 * @param userPlanDetail the user plan detail
 */
@AllArgsConstructor

/**
 * Instantiates a new nominee.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class Nominee {
	
	/** The nominee id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long nomineeId;
	
	/** The name. */
	@Column(nullable = false)
	private String name;
	
	/** The email. */
	@Column(nullable = false)
	private String email;
	
	/** The address. */
	private String address;
	
	/** The gender. */
	@Column(nullable = false)
	private String gender;
	
	/** The dob. */
	@Column(nullable = false)
	private Date dob;
	
	/** The contact no. */
	@Column(nullable = false)
	private Integer contactNo;
	
	/** The relation. */
	@Column(nullable = false)
	private String relation;
	
	/** The user plan detail. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private UserPlanDetail userPlanDetail;
	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "nominee")
//	@JsonIgnore
//	private Claim claim;
}
