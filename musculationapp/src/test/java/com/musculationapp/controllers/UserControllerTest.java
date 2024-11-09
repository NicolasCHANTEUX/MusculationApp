package com.musculationapp.controllers;

import com.musculationapp.models.User;
import com.musculationapp.services.UserService;
import com.musculationapp.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest
{

	private UserService userService;
	private UserController userController;

	@BeforeEach
	void setUp()
	{
		userService = mock(UserService.class);
		userController = new UserController(userService);
	}

	@Test
	void testCreateUser()
	{
		userController.createUser("Martin", "Jean", "martin_j", "password123", 0);
		verify(userService, times(1)).createUser(any(User.class));
	}

	@Test
	void testGetUserById() throws UserNotFoundException
	{
		User user = new User("Martin", "Jean", "martin_j", "password123", 0);
		when(userService.getUserById(1)).thenReturn(user);

		User result = userController.getUserById(1);
		assertNotNull(result);
		assertEquals("martin_j", result.getPseudo());
	}

	@Test
	void testGetUserById_NotFound() throws UserNotFoundException
	{
		when(userService.getUserById(1)).thenThrow(new UserNotFoundException("User not found"));
		User result = userController.getUserById(1);
		assertNull(result);
	}

	@Test
	void testGetAllUsers()
	{
		List<User> users = Arrays.asList(new User("Martin", "Jean", "martin_j", "password123", 0),
				new User("Durand", "Sophie", "sophie_d", "password456", 0));
		when(userService.getAllUsers()).thenReturn(users);

		List<User> result = userController.getAllUsers();
		assertEquals(2, result.size());
	}

	@Test
	void testUpdateUser() throws UserNotFoundException
	{
		userController.updateUser(1, "Martin", "Jean", "martin_j", "password123", 1);
		verify(userService, times(1)).updateUser(any(User.class));
	}

	@Test
	void testDeleteUser() throws UserNotFoundException
	{
		userController.deleteUser(1);
		verify(userService, times(1)).deleteUser(1);
	}
}
