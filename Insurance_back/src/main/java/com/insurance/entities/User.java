package com.insurance.entities;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class User.
 */
@Entity

/**
 * Hash code.
 *
 * @return the int
 */
@Data

/**
 * Instantiates a new user.
 *
 * @param id the id
 * @param name the name
 * @param email the email
 * @param password the password
 * @param contactNo the contact no
 * @param gender the gender
 * @param dob the dob
 * @param adharNo the adhar no
 * @param isSmoker the is smoker
 * @param isAlcoholer the is alcoholer
 * @param role the role
 * @param age the age
 * @param userPlanDetails the user plan details
 * @param claim the claim
 */
@AllArgsConstructor

/**
 * Instantiates a new user.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class User implements UserDetails{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** The name. */
	@Column(nullable = false)
	private String name;
	
	/** The email. */
	@Column(unique = true, nullable = false)
	private String email;
	
	/** The password. */
	@Column(nullable = false)
	private String password;
	
	/** The contact no. */
	@Column(unique = true, nullable = false)
	private String contactNo;
	
	/** The gender. */
	@Column(nullable = false)
	private String gender;
	
	/** The dob. */
	@Column(nullable = false)
	private Date dob;
	
	/** The adhar no. */
	@Column(unique = true, nullable = false)
	private Long adharNo;
	
	/** The is smoker. */
	@Column(nullable = false)
	private Integer isSmoker;
	
	/** The is alcoholer. */
	@Column(nullable = false)
	private Integer isAlcoholer;
	
	/** The role. */
	private String role;
	
	/** The age. */
	private Integer age;
	
	/** The user plan details. */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "user")
	private List<UserPlanDetail> userPlanDetails;
	
	/** The claim. */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
	private List<Claim> claim;

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<Authority> set=new HashSet<>();
		set.add(new Authority(this.getRole()));
		return set;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return this.getEmail();
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
