package com.musculationapp.controllers;

import com.musculationapp.models.Session;
import com.musculationapp.services.SessionService;
import com.musculationapp.exceptions.InvalidSessionException;

import java.time.LocalDate;
import java.util.List;

public class SessionController
{

	private SessionService sessionService;

	public SessionController(SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	public void createSession(LocalDate dateSession, String musclesTravailles, int utilisateurId)
	{
		Session session = new Session(dateSession, musclesTravailles, utilisateurId);
		sessionService.createSession(session);
		System.out.println("Session created for user ID: " + utilisateurId);
	}

	public Session getSessionById(int id)
	{
		try
		{
			return sessionService.getSessionById(id);
		} catch (InvalidSessionException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Session> getAllSessions()
	{
		return sessionService.getAllSessions();
	}

	public void updateSession(int id, LocalDate dateSession, String musclesTravailles, int utilisateurId)
	{
		try
		{
			Session session = new Session(dateSession, musclesTravailles, utilisateurId);
			sessionService.updateSession(session);
			System.out.println("Session updated: ID " + id);
		} catch (InvalidSessionException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void deleteSession(int id)
	{
		try
		{
			sessionService.deleteSession(id);
			System.out.println("Session deleted: ID " + id);
		} catch (InvalidSessionException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
