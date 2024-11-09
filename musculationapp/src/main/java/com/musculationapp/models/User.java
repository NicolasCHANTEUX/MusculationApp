package com.musculationapp.models;

import java.util.List;

public class User
{
	private int id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String motDePasse;
	private int nombreSessions;
	private List<Session> historiqueSessions; // Historique des sessions
	private List<Poids> poidsHistorique; // Historique des poids de l'utilisateur

	// Constructeurs
	public User(String nom, String prenom, String pseudo, String motDePasse, int nombreSessions)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nombreSessions = nombreSessions;
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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public String getPseudo()
	{
		return pseudo;
	}

	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse = motDePasse;
	}

	public int getNombreSessions()
	{
		return nombreSessions;
	}

	public void setNombreSessions(int nombreSessions)
	{
		this.nombreSessions = nombreSessions;
	}

	public List<Session> getHistoriqueSessions()
	{
		return historiqueSessions;
	}

	public void setHistoriqueSessions(List<Session> historiqueSessions)
	{
		this.historiqueSessions = historiqueSessions;
	}

	public List<Poids> getPoidsHistorique()
	{
		return poidsHistorique;
	}

	public void setPoidsHistorique(List<Poids> poidsHistorique)
	{
		this.poidsHistorique = poidsHistorique;
	}
}
