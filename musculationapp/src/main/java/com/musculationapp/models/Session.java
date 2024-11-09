package com.musculationapp.models;

import java.time.LocalDate;
import java.util.List;

public class Session
{
	private int id;
	private LocalDate dateSession;
	private String musclesTravailles;
	private int utilisateurId; // ID de l'utilisateur associé
	private List<Exercise> exercices; // Exercices associés à la session

	// Constructeurs
	public Session(LocalDate dateSession, String musclesTravailles, int utilisateurId)
	{
		this.dateSession = dateSession;
		this.musclesTravailles = musclesTravailles;
		this.utilisateurId = utilisateurId;
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

	public LocalDate getDateSession()
	{
		return dateSession;
	}

	public void setDateSession(LocalDate dateSession)
	{
		this.dateSession = dateSession;
	}

	public String getMusclesTravailles()
	{
		return musclesTravailles;
	}

	public void setMusclesTravailles(String musclesTravailles)
	{
		this.musclesTravailles = musclesTravailles;
	}

	public int getUtilisateurId()
	{
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId)
	{
		this.utilisateurId = utilisateurId;
	}

	public List<Exercise> getExercices()
	{
		return exercices;
	}

	public void setExercices(List<Exercise> exercices)
	{
		this.exercices = exercices;
	}
}
