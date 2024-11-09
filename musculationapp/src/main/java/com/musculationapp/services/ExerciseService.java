package com.musculationapp.services;

import com.musculationapp.models.Exercise;
import com.musculationapp.repositories.ExerciseRepository;
import com.musculationapp.exceptions.InvalidExerciseException;

import java.util.List;

public class ExerciseService
{

	private ExerciseRepository exerciseRepository;

	public ExerciseService(ExerciseRepository exerciseRepository)
	{
		this.exerciseRepository = exerciseRepository;
	}

	public void createExercise(Exercise exercise)
	{
		exerciseRepository.createExercise(exercise);
	}

	public Exercise getExerciseById(int id) throws InvalidExerciseException
	{
		Exercise exercise = exerciseRepository.getExerciseById(id);
		if (exercise == null)
		{
			throw new InvalidExerciseException("Exercise with ID " + id + " not found.");
		}
		return exercise;
	}

	public List<Exercise> getAllExercises()
	{
		return exerciseRepository.getAllExercises();
	}

	public void updateExercise(Exercise exercise) throws InvalidExerciseException
	{
		if (exerciseRepository.getExerciseById(exercise.getId()) == null)
		{
			throw new InvalidExerciseException("Cannot update. Exercise with ID " + exercise.getId() + " not found.");
		}
		exerciseRepository.updateExercise(exercise);
	}

	public void deleteExercise(int id) throws InvalidExerciseException
	{
		if (exerciseRepository.getExerciseById(id) == null)
		{
			throw new InvalidExerciseException("Cannot delete. Exercise with ID " + id + " not found.");
		}
		exerciseRepository.deleteExercise(id);
	}
}
