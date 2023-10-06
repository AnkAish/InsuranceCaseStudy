package com.insurance.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.insurance.entities.User;
import com.insurance.entities.UserPlanDetail;
import com.insurance.repository.UserRepository;
import com.insurance.services.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserServiceImpl.
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService{

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	//Get All Users
	public List<User> getAll(){
		log.info("Inside getAllUser function of UserService");
		return (List<User>) this.userRepository.findAll();
	}
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	//Get User By ID
	public Optional<User> getUserById(Long id) {
		log.info("Inside getUserById function of UserService");
		return this.userRepository.findById(id);
	}
	
	/**
	 * Adds the user.
	 *
	 * @param u the u
	 * @return the user
	 */
	//Add User
	public User addUser(User u) {
		log.info("Inside insertUser function of UserService");
		this.userRepository.save(u);
		return u;
	}
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	//Delete
	public void deleteById(Long id) {
		log.info("Inside deleteUserById function of UserService");
		this.userRepository.deleteById(id);
	}

	/**
	 * Update user.
	 *
	 * @param u the u
	 * @param id the id
	 */
	//Update
	public void updateUser(User u,Long id) {
		log.info("Inside updateUserById function of UserService");
		u.setId(id);
		//Optional<User> u1=this.userRepository.findById(id);
		this.userRepository.save(u);
	}

	public List<User> getUsersByRole(String role) {
		log.info("Inside getUserByRole function of UserService");
		return this.userRepository.findByRole(role);
	}
	
	//@Scheduled(cron = "0/100 * * * * ?")
	@Scheduled(fixedRate = 1000 * 60 * 60 *4 )
	public void autoApproval() {
		log.info("Inside autoApproval function of UserService");
		List<User> users=this.userRepository.findAll();
		for(User u:users) {
			if(u.getIsSmoker()==0 && u.getIsAlcoholer()==0) {
				for(UserPlanDetail uP:u.getUserPlanDetails()) {
					if(uP.getIsVerified()==1) 
						uP.setIsVerified(2);
				}
				this.userRepository.save(u);
				log.info("Auto Approval Successfully");
			}
		}
	}
}

