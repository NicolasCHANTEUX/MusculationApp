package com.musculationapp.models;

import java.time.LocalDate;

public class Poids
{

	private Long id;
	private LocalDate datePesee;
	private double poids;
	private Long utilisateurId;

	// Constructeurs
	public Poids()
	{
	}

	public Poids(LocalDate datePesee, double poids, Long utilisateurId)
	{
		this.datePesee = datePesee;
		this.poids = poids;
		this.utilisateurId = utilisateurId;
	}

	// Getters et Setters
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public LocalDate getDatePesee()
	{
		return datePesee;
	}

	public void setDatePesee(LocalDate datePesee)
	{
		this.datePesee = datePesee;
	}

	public double getPoids()
	{
		return poids;
	}

	public void setPoids(double poids)
	{
		this.poids = poids;
	}

	public Long getUtilisateurId()
	{
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId)
	{
		this.utilisateurId = utilisateurId;
	}
}
