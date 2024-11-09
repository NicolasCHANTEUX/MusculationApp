package com.musculationapp.controllers;

import com.musculationapp.models.Session;
import com.musculationapp.services.SessionService;
import com.musculationapp.exceptions.InvalidSessionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SessionControllerTest
{

	private SessionService sessionService;
	private SessionController sessionController;

	@BeforeEach
	void setUp()
	{
		sessionService = mock(SessionService.class);
		sessionController = new SessionController(sessionService);
	}

	@Test
	void testCreateSession()
	{
		sessionController.createSession(LocalDate.now(), "Pectoraux", 1);
		verify(sessionService, times(1)).createSession(any(Session.class));
	}

	@Test
	void testGetSessionById() throws InvalidSessionException
	{
		Session session = new Session(LocalDate.parse("2024-10-01"), "Pectoraux", 1);
		when(sessionService.getSessionById(1)).thenReturn(session);

		Session result = sessionController.getSessionById(1);
		assertNotNull(result);
		assertEquals("2024-10-01", result.getDateSession());
	}

	@Test
	void testGetSessionById_NotFound() throws InvalidSessionException
	{
		when(sessionService.getSessionById(1)).thenThrow(new InvalidSessionException("Session not found"));
		Session result = sessionController.getSessionById(1);
		assertNull(result);
	}

	@Test
	void testGetAllSessions()
	{
		List<Session> sessions = Arrays.asList(new Session(LocalDate.parse("2024-10-01"), "Pectoraux", 1),
				new Session(LocalDate.parse("2024-10-02"), "Biceps", 2));
		when(sessionService.getAllSessions()).thenReturn(sessions);

		List<Session> result = sessionController.getAllSessions();
		assertEquals(2, result.size());
	}

	@Test
	void testUpdateSession() throws InvalidSessionException
	{
		sessionController.updateSession(1, LocalDate.parse("2024-10-01"), "Pectoraux", 1);
		verify(sessionService, times(1)).updateSession(any(Session.class));
	}

	@Test
	void testDeleteSession() throws InvalidSessionException
	{
		sessionController.deleteSession(1);
		verify(sessionService, times(1)).deleteSession(1);
	}
}
