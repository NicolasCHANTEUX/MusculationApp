package com.musculationapp.services;

import com.musculationapp.models.Session;
import com.musculationapp.repositories.SessionRepository;
import com.musculationapp.exceptions.InvalidSessionException;

import java.util.List;

public class SessionService
{

	private SessionRepository sessionRepository;

	public SessionService(SessionRepository sessionRepository)
	{
		this.sessionRepository = sessionRepository;
	}

	public void createSession(Session session)
	{
		sessionRepository.createSession(session);
	}

	public Session getSessionById(int id) throws InvalidSessionException
	{
		Session session = sessionRepository.getSessionById(id);
		if (session == null)
		{
			throw new InvalidSessionException("Session with ID " + id + " not found.");
		}
		return session;
	}

	public List<Session> getAllSessions()
	{
		return sessionRepository.getAllSessions();
	}

	public void updateSession(Session session) throws InvalidSessionException
	{
		if (sessionRepository.getSessionById(session.getId()) == null)
		{
			throw new InvalidSessionException("Cannot update. Session with ID " + session.getId() + " not found.");
		}
		sessionRepository.updateSession(session);
	}

	public void deleteSession(int id) throws InvalidSessionException
	{
		if (sessionRepository.getSessionById(id) == null)
		{
			throw new InvalidSessionException("Cannot delete. Session with ID " + id + " not found.");
		}
		sessionRepository.deleteSession(id);
	}
}
