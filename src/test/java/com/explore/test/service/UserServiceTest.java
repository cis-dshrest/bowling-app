package com.explore.test.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.explore.learn.model.User;
import com.explore.learn.service.UserService;

public class UserServiceTest {
	
	private UserService mockedUserService;
	private User user;
	private ArrayList<User> userList;
	
	
	@Before
	public void setUp() {
		//Effects: Runs before every function annotated with @Test. Basically resetting the user object to what is
		// specified in setUp().
		mockedUserService = Mockito.mock(UserService.class);

		
		user = new User();
		user.setFirstName("Tom");
		user.setLastName("Jenkins");
		user.setUsername("vayne");
		user.setId(1);
		user.setIsActive(1);
		
		userList = new ArrayList<User>();
		userList.add(user);
		
		Mockito.when(mockedUserService.findByUsername("vayne")).thenReturn(user);
//		Mockito.(userList.add(user)).when(mockedUserService).saveUser(user);
		Mockito.doReturn(userList).when(mockedUserService).findAllUsers();
		Mockito.doReturn(isUnique("vayne")).when(mockedUserService).isUsernameUnique("vayne");
	}
	
	public boolean isUnique(String s) {
		// Helper function to test if username is unique for mocked object.
		for(User u : userList) {
			if (u.getUsername().equals(s))
				return false;
		}
		return true;
	}
	
	@Test
	public void testFindByUserName() {
		// Test to see if username is available
		assertEquals(mockedUserService.findByUsername("vayne"), user);
	}
	
	@Test
	public void testUpdateUser() {
		
		user.setFirstName("Tommy");
		user.setLastName("Jenkinz");
		user.setUsername("vayne23");
		
		assertEquals(user.getFirstName(), "Tommy");
		assertEquals(user.getLastName(), "Jenkinz");
		assertEquals(user.getUsername(), "vayne23");
	}
	
	@Test
	public void testFindAllUsers() {
		assertEquals(mockedUserService.findAllUsers(), userList);
	}
	
	@Test
	public void testIsUsernameUnique() {
		assertEquals(mockedUserService.isUsernameUnique("vayne"), false);
	}
}
