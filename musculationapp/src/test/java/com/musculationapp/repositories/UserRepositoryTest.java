package com.musculationapp.repositories;

import com.musculationapp.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest
{

	@Autowired
	private UserRepository userRepository;

	@Test
	void testSaveAndFindUser()
	{
		User user = new User("Chanteux", "Nicolas", "N1kelaos", "28022005", 0);
		User savedUser = userRepository.save(user);
		assertNotNull(savedUser);
		assertEquals(user.getPseudo(), savedUser.getPseudo());

		Optional<User> foundUser = userRepository.findById(savedUser.getId());
		assertTrue(foundUser.isPresent());
		assertEquals(savedUser.getPseudo(), foundUser.get().getPseudo());
	}

	@Test
	void testDeleteUser()
	{
		User user = new User("Martin", "Lorenzo", "Lolo", "0000", 0);
		User savedUser = userRepository.save(user);
		userRepository.deleteUser(savedUser.getId());
		Optional<User> foundUser = userRepository.findById(savedUser.getId());
		assertFalse(foundUser.isPresent());
	}
}
