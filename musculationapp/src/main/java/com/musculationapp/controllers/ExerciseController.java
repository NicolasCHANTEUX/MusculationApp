package com.musculationapp.controllers;

import com.musculationapp.models.Exercise;
import com.musculationapp.services.ExerciseService;
import com.musculationapp.exceptions.InvalidExerciseException;

import java.time.Duration;
import java.util.List;

public class ExerciseController
{

	private ExerciseService exerciseService;

	public ExerciseController(ExerciseService exerciseService)
	{
		this.exerciseService = exerciseService;
	}

	public void createExercise(String nom, int repetitions, Duration duree, int sessionId)
	{
		Exercise exercise = new Exercise(nom, repetitions, duree, sessionId);
		exerciseService.createExercise(exercise);
		System.out.println("Exercise created: " + nom);
	}

	public Exercise getExerciseById(int id)
	{
		try
		{
			return exerciseService.getExerciseById(id);
		} catch (InvalidExerciseException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Exercise> getAllExercises()
	{
		return exerciseService.getAllExercises();
	}

	public void updateExercise(int id, String nom, int repetitions, Duration duree, int sessionId)
	{
		try
		{
			Exercise exercise = new Exercise(nom, repetitions, duree, sessionId);
			exerciseService.updateExercise(exercise);
			System.out.println("Exercise updated: " + nom);
		} catch (InvalidExerciseException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void deleteExercise(int id)
	{
		try
		{
			exerciseService.deleteExercise(id);
			System.out.println("Exercise deleted: ID " + id);
		} catch (InvalidExerciseException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
