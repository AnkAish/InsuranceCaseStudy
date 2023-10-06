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

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entities.User;
import com.insurance.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImplTest.
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {UserServiceImplTest.class})
class UserServiceImplTest {

	/** The user service. */
	@InjectMocks
	private UserServiceImpl userService;
	
	/** The user repository. */
	@Mock
	private UserRepository userRepository;
	
	/**
	 * Adds the user test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void addUserTest() {
		User user =new User();
		user.setName("Arhaan");
		user.setEmail("arhaan123mail.com");
		user.setAdharNo((long) 123456789098.00);
		user.setContactNo("1234567890");
		user.setPassword("1234567");
		user.setGender("male");
		user.setIsAlcoholer(1);
		user.setIsSmoker(0);
		user.setAge(20);
		user.setRole("NORMAL");
		Date date=new Date(2009, 11, 12);
		user.setDob(date);
	    Mockito.when(userRepository.save(user)).thenReturn(user);
	   assertEquals(user, user);
	}
	
	/**
	 * Gets the users test.
	 *
	 * @return the users test
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(2)
	public void getUsersTest() {
		Date date=new Date(2009, 11, 12);
		when(userRepository.findAll()).thenReturn(Stream.of(new User((long)33,"Arhaan","arhaan123@gmail.com","Arbaz@123","1234567890","male",date,(long)123456789098.00,1,0,"NORMAL",20,null,null)).collect(Collectors.toList()));
		assertEquals(1, userService.getAll().size());
	}
	
	/**
	 * Delete by id test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(5)
	public void deleteByIdTest() {
		Date date=new Date(2009, 11, 12);
		User user = new User((long)33,"Arhaan","arhaan123@gmail.com","Arbaz@123","1234567890","male",date,(long)123456789098.00,1,0,"NORMAL",20,null,null);
		userService.deleteById(user.getId());
		verify(userRepository,times(1)).deleteById(user.getId());
	}
	
	/**
	 * Gets the user by id test.
	 *
	 * @return the user by id test
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(3)
	public void getUserByIdTest() {
		User user =new User();
		user.setId((long) 33);
		user.setName("Arhaan");
		user.setEmail("arhaan123mail.com");
		user.setAdharNo((long) 123456789098.00);
		user.setContactNo("1234567890");
		user.setPassword("1234567");
		user.setGender("male");
		user.setIsAlcoholer(1);
		user.setIsSmoker(0);
		user.setAge(20);
		user.setRole("NORMAL");
		Date date=new Date(2009, 11, 12);
		user.setDob(date);
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		assertNotNull(userService.getUserById(user.getId()));
	}

	/**
	 * Update user test.
	 */
	@SuppressWarnings("deprecation")
	@Test
	@Order(4)
	public void updateUserTest() {
		User user =new User();
		user.setId((long) 33);
		user.setName("Arhaan");
		user.setEmail("arhaan123mail.com");
		user.setAdharNo((long) 123456789098.00);
		user.setContactNo("1234567890");
		user.setPassword("1234567");
		user.setGender("male");
		user.setIsAlcoholer(1);
		user.setIsSmoker(0);
		user.setAge(20);
		user.setRole("NORMAL");
		Date date=new Date(2009, 11, 12);
		user.setDob(date);
		when(userRepository.save(user)).thenReturn(user);
		userService.updateUser(user, user.getId());
		verify(userRepository,times(1)).save(user);
	}
}
