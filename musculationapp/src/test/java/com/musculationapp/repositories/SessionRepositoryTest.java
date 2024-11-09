package com.musculationapp.repositories;

import com.musculationapp.models.Session;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SessionRepositoryTest
{

	@Autowired
	private SessionRepository sessionRepository;

	@Test
	void testSaveAndFindSession()
	{
		Session session = new Session(LocalDate.parse("2024-10-01"), "Pectoraux, Biceps", 1);
		Session savedSession = sessionRepository.save(session);
		assertNotNull(savedSession);
		assertEquals(session.getMusclesTravailles(), savedSession.getMusclesTravailles());

		Optional<Session> foundSession = sessionRepository.findById(savedSession.getId());
		assertTrue(foundSession.isPresent());
		assertEquals(savedSession.getMusclesTravailles(), foundSession.get().getMusclesTravailles());
	}

	@Test
	void testDeleteSession()
	{
		Session session = new Session(LocalDate.parse("2024-10-03"), "Triceps, Dorsaux", 1);
		Session savedSession = sessionRepository.save(session);
		sessionRepository.deleteSession(savedSession.getId());
		Optional<Session> foundSession = sessionRepository.findById(savedSession.getId());
		assertFalse(foundSession.isPresent());
	}
}
