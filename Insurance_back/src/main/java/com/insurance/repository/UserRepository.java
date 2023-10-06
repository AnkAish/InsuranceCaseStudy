package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<User> findById(Long id);
	
	/**
	 * Gets the user by user name.
	 *
	 * @param email the email
	 * @return the user by user name
	 */
	@Query("select u from User u where u.email=:email")
	public User getUserByUserName(@Param("email") String email);

	public List<User> findByRole(String role);
}
