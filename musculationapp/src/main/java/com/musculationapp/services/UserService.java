package com.musculationapp.services;

import com.musculationapp.models.User;
import com.musculationapp.repositories.UserRepository;
import com.musculationapp.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public void createUser(User user)
	{
		userRepository.save(user); // save() fonctionne pour la création et la
									// mise à jour
	}

	public User getUserById(int id) throws UserNotFoundException
	{
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
	}

	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	public void updateUser(User user) throws UserNotFoundException
	{
		if (!userRepository.existsById(user.getId()))
		{
			throw new UserNotFoundException("Cannot update. User with ID " + user.getId() + " not found.");
		}
		userRepository.save(user); // save() met à jour si l'ID existe déjà
	}

	public void deleteUser(int id) throws UserNotFoundException
	{
		if (!userRepository.existsById(id))
		{
			throw new UserNotFoundException("Cannot delete. User with ID " + id + " not found.");
		}
		userRepository.deleteById(id);
	}
}
