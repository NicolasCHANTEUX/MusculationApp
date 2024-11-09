package com.musculationapp.models;

import java.time.Duration;

public class Exercise
{
	private static int idCounter = 0; // Compteur statique pour auto-incrémenter l'id
	private int id;
	private String nom;
	private int repetitions;
	private Duration duree;
	private int sessionId;

	// Constructeur modifié pour auto-incrémenter l'id
	public Exercise(String nom, int repetitions, Duration duree, int sessionId)
	{
		this.id = ++idCounter; // Incrémenter le compteur et assigner à id
		this.nom = nom;
		this.repetitions = repetitions;
		this.duree = duree;
		this.sessionId = sessionId;
	}

	// Getters et setters
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getRepetitions()
	{
		return repetitions;
	}

	public void setRepetitions(int repetitions)
	{
		this.repetitions = repetitions;
	}

	public Duration getDuree()
	{
		return duree;
	}

	public void setDuree(Duration duree)
	{
		this.duree = duree;
	}

	public int getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(int sessionId)
	{
		this.sessionId = sessionId;
	}
}
