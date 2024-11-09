package com.musculationapp.services;

import com.musculationapp.models.User;
import com.musculationapp.repositories.UserRepository;
import com.musculationapp.exceptions.UserNotFoundException;

import java.util.List;

public class UserService
{

	private UserRepository userRepository;

	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public void createUser(User user)
	{
		userRepository.createUser(user);
	}

	public User getUserById(int id) throws UserNotFoundException
	{
		User user = userRepository.getUserById(id);
		if (user == null)
		{
			throw new UserNotFoundException("User with ID " + id + " not found.");
		}
		return user;
	}

	public List<User> getAllUsers()
	{
		return userRepository.getAllUsers();
	}

	public void updateUser(User user) throws UserNotFoundException
	{
		if (userRepository.getUserById(user.getId()) == null)
		{
			throw new UserNotFoundException("Cannot update. User with ID " + user.getId() + " not found.");
		}
		userRepository.updateUser(user);
	}

	public void deleteUser(int id) throws UserNotFoundException
	{
		if (userRepository.getUserById(id) == null)
		{
			throw new UserNotFoundException("Cannot delete. User with ID " + id + " not found.");
		}
		userRepository.deleteUser(id);
	}
}
