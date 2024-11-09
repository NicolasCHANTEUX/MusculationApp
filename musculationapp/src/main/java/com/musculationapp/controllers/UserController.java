package com.musculationapp.controllers;

import com.musculationapp.models.User;
import com.musculationapp.services.UserService;
import com.musculationapp.exceptions.UserNotFoundException;

import java.util.List;

public class UserController
{

	private UserService userService;

	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	public void createUser(String nom, String prenom, String pseudo, String motDePasse, int nombreSessions)
	{
		User user = new User(nom, prenom, pseudo, motDePasse, nombreSessions);
		userService.createUser(user);
		System.out.println("User created: " + pseudo);
	}

	public User getUserById(int id)
	{
		try
		{
			return userService.getUserById(id);
		} catch (UserNotFoundException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}

	public void updateUser(int id, String nom, String prenom, String pseudo, String motDePasse, int nombreSessions)
	{
		try
		{
			User user = new User(nom, prenom, pseudo, motDePasse, nombreSessions);
			userService.updateUser(user);
			System.out.println("User updated: " + pseudo);
		} catch (UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void deleteUser(int id)
	{
		try
		{
			userService.deleteUser(id);
			System.out.println("User deleted: ID " + id);
		} catch (UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
