package com.musculationapp.models;

public class GroupMuscle
{
	private int id;
	private String nom;
	private String description; // Nouvelle propriété pour la description du groupe musculaire

	// Constructeurs
	public GroupMuscle(String nom, String description)
	{
		this.nom = nom;
		this.description = description;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
