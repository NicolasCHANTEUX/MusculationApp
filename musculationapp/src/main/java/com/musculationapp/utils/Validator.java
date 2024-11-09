package com.musculationapp.utils;

public class Validator
{

	public static boolean isValidPseudo(String pseudo)
	{
		return pseudo != null && !pseudo.trim().isEmpty();
	}

	public static boolean isValidMotDePasse(String motDePasse)
	{
		return motDePasse != null && motDePasse.length() >= 4;
	}

	public static boolean isValidExerciseName(String nom)
	{
		return nom != null && !nom.trim().isEmpty();
	}

	public static boolean isValidRepetitions(int repetitions)
	{
		return repetitions > 0;
	}

	public static boolean isValidDuration(String duree)
	{
		return duree != null && duree.matches("\\d{2}:\\d{2}:\\d{2}");
	}
}
