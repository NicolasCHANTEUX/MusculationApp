package com.musculationapp.services;

import com.musculationapp.models.Session;
import com.musculationapp.repositories.SessionRepository;
import com.musculationapp.exceptions.InvalidSessionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SessionServiceTest
{

	@Mock
	private SessionRepository sessionRepository;

	@InjectMocks
	private SessionService sessionService;

	private Session session;

	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
		session = new Session(LocalDate.parse("2024-10-01"), "Pectoraux, Biceps", 1);
	}

	@Test
	void testGetSessionById() throws InvalidSessionException
	{
		when(sessionRepository.getSessionById(1)).thenReturn(session);
		Session foundSession = sessionService.getSessionById(1);
		assertNotNull(foundSession);
		assertEquals(session.getMusclesTravailles(), foundSession.getMusclesTravailles());
	}

	@Test
	void testCreateSession()
	{
		doNothing().when(sessionRepository).createSession(session);
		sessionService.createSession(session);
		verify(sessionRepository, times(1)).createSession(session);
	}

	@Test
	void testDeleteSession() throws InvalidSessionException
	{
		when(sessionRepository.getSessionById(1)).thenReturn(session);
		doNothing().when(sessionRepository).deleteSession(1);
		sessionService.deleteSession(1);
		verify(sessionRepository, times(1)).deleteSession(1);
	}
}
