package com.musculationapp.services;

import com.musculationapp.models.User;
import com.musculationapp.repositories.UserRepository;
import com.musculationapp.services.UserService;
import com.musculationapp.exceptions.UserNotFoundException;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

public class UserServiceTest
{

	
	private UserRepository userRepository;

	
	private UserService userService;

	private User user;

	
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		user = new User("Chanteux", "Nicolas", "N1kelaos", "28022005", 0);
	}

	
	public void testCreateUser()
	{
		userService.createUser(user);
		verify(userRepository, times(1)).createUser(user);
	}

	
	public void testGetUserById() throws UserNotFoundException
	{
		when(userRepository.getUserById(1)).thenReturn(user);
		User foundUser = userService.getUserById(1);
		assertNotNull(foundUser);
		assertEquals(user.getPseudo(), foundUser.getPseudo());
	}

	(expected = UserNotFoundException.class)
	public void testGetUserByIdThrowsException() throws UserNotFoundException
	{
		when(userRepository.getUserById(1)).thenReturn(null);
		userService.getUserById(1);
	}

	
	public void testGetAllUsers()
	{
		List<User> users = new ArrayList<>();
		users.add(user);
		when(userRepository.getAllUsers()).thenReturn(users);
		List<User> foundUsers = userService.getAllUsers();
		assertEquals(1, foundUsers.size());
		assertEquals(user.getPseudo(), foundUsers.get(0).getPseudo());
	}

	
	public void testUpdateUser() throws UserNotFoundException
	{
		when(userRepository.getUserById(user.getId())).thenReturn(user);
		userService.updateUser(user);
		verify(userRepository, times(1)).updateUser(user);
	}

	(expected = UserNotFoundException.class)
	public void testUpdateUserThrowsException() throws UserNotFoundException
	{
		when(userRepository.getUserById(user.getId())).thenReturn(null);
		userService.updateUser(user);
	}

	
	public void testDeleteUser() throws UserNotFoundException
	{
		when(userRepository.getUserById(1)).thenReturn(user);
		userService.deleteUser(1);
		verify(userRepository, times(1)).deleteUser(1);
	}

	(expected = UserNotFoundException.class)
	public void testDeleteUserThrowsException() throws UserNotFoundException
	{
		when(userRepository.getUserById(1)).thenReturn(null);
		userService.deleteUser(1);
	}
}
