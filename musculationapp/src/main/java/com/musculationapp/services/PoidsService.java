package com.musculationapp.services;

import com.musculationapp.models.Poids;
import com.musculationapp.repositories.PoidsRepository;

import java.util.List;

public class PoidsService
{

	private final PoidsRepository poidsRepository;

	public PoidsService(PoidsRepository poidsRepository)
	{
		this.poidsRepository = poidsRepository;
	}

	public void addPoids(Poids poids)
	{
		if (poids.getPoids() > 0)
		{
			poidsRepository.save(poids);
		}
		else
		{
			throw new IllegalArgumentException("Le poids doit être positif.");
		}
	}

	public List<Poids> getPoidsHistorique(Long utilisateurId)
	{
		return poidsRepository.findByUtilisateurId(utilisateurId);
	}
}
