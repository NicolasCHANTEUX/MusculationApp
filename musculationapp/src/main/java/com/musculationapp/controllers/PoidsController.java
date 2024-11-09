package com.musculationapp.controllers;

import com.musculationapp.models.Poids;
import com.musculationapp.services.PoidsService;

import java.util.List;

public class PoidsController
{

	private final PoidsService poidsService;

	public PoidsController(PoidsService poidsService)
	{
		this.poidsService = poidsService;
	}

	public void ajouterPoids(Poids poids)
	{
		poidsService.addPoids(poids);
	}

	public List<Poids> getHistoriquePoids(Long utilisateurId)
	{
		return poidsService.getPoidsHistorique(utilisateurId);
	}
}
