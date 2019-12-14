package com.retail.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.application.RetailApplication;
import com.retail.model.User;
import com.retail.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetailApplication.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public UserService employeeService() {
			return new UserServiceImpl();
		}
	}

	@MockBean
	private UserRepository userRepository;

	private User user1, user2, user3;

	@Before
	public void before() {
		Date date1 = Date.valueOf("2018-01-17");
		Date date2 = Date.valueOf("2018-06-20");

		user1 = new User("Shubham", "Mehta", "employee", date1, date2);
		date1 = Date.valueOf("2016-04-01");
		date2 = Date.valueOf("2018-05-22");
		user2 = new User("Debapriya", "Ghosh", "affiliate", date1, date2);
		date1 = Date.valueOf("2016-12-01");
		date2 = Date.valueOf("2019-05-11");
		user3 = new User("Devank", "Chawla", "customer", date1, date2);
	}

	@Test
	public void getUserTest() {

		Mockito.when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
		
		Optional<User> responseUser = userService.getUser(user1.getId());

		assertEquals(responseUser.get().getFirstName(), user1.getFirstName());
	}
	
	@Test
	public void saveUserTest() {
		Mockito.when(userRepository.save(user2)).thenReturn(user2);
		
		User response = userService.addUser(user2);
		
		verify(userRepository,times(1)).save(user2);
		
	}

}
