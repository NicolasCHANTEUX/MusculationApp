package com.musculationapp.controllers;

import com.musculationapp.models.Exercise;
import com.musculationapp.services.ExerciseService;
import com.musculationapp.exceptions.InvalidExerciseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.Duration;

class ExerciseControllerTest
{

	private ExerciseService exerciseService;
	private ExerciseController exerciseController;

	@BeforeEach
	void setUp()
	{
		exerciseService = mock(ExerciseService.class);
		exerciseController = new ExerciseController(exerciseService);
	}

	@Test
	void testCreateExercise()
	{
		exerciseController.createExercise("Curl", 10, Duration.ofMinutes(5), 1);
		verify(exerciseService, times(1)).createExercise(any(Exercise.class));
	}

	@Test
	void testGetExerciseById() throws InvalidExerciseException
	{
		Exercise exercise = new Exercise("Curl", 10, Duration.ofMinutes(5), 1);
		when(exerciseService.getExerciseById(1)).thenReturn(exercise);

		Exercise result = exerciseController.getExerciseById(1);
		assertNotNull(result);
		assertEquals("Curl", result.getNom());
	}

	@Test
	void testGetExerciseById_NotFound() throws InvalidExerciseException
	{
		when(exerciseService.getExerciseById(1)).thenThrow(new InvalidExerciseException("Exercise not found"));
		Exercise result = exerciseController.getExerciseById(1);
		assertNull(result);
	}

	@Test
	void testGetAllExercises()
	{
		List<Exercise> exercises = Arrays.asList(new Exercise("Curl", 10, 
				Duration.ofMinutes(5), 1),
				new Exercise("Squat", 15, Duration.ofMinutes(5), 2));
		when(exerciseService.getAllExercises()).thenReturn(exercises);

		List<Exercise> result = exerciseController.getAllExercises();
		assertEquals(2, result.size());
	}

	@Test
	void testUpdateExercise() throws InvalidExerciseException
	{
		exerciseController.updateExercise(1, "Curl", 10, Duration.ofMinutes(5), 1);
		verify(exerciseService, times(1)).updateExercise(any(Exercise.class));
	}

	@Test
	void testDeleteExercise() throws InvalidExerciseException
	{
		exerciseController.deleteExercise(1);
		verify(exerciseService, times(1)).deleteExercise(1);
	}
}
