package com.musculationapp.services;

import com.musculationapp.models.Exercise;
import com.musculationapp.repositories.ExerciseRepository;
import com.musculationapp.exceptions.InvalidExerciseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.Duration;

class ExerciseServiceTest
{

	@Mock
	private ExerciseRepository exerciseRepository;

	@InjectMocks
	private ExerciseService exerciseService;

	private Exercise exercise;

	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
		exercise = new Exercise("Développé couché haltères", 8, Duration.ofMinutes(5), 1);
	}

	@Test
	void testGetExerciseById() throws InvalidExerciseException
	{
		when(exerciseRepository.getExerciseById(1)).thenReturn(exercise);
		Exercise foundExercise = exerciseService.getExerciseById(1);
		assertNotNull(foundExercise);
		assertEquals(exercise.getNom(), foundExercise.getNom());
	}

	@Test
	void testCreateExercise()
	{
		doNothing().when(exerciseRepository).createExercise(exercise);
		exerciseService.createExercise(exercise);
		verify(exerciseRepository, times(1)).createExercise(exercise);
	}

	@Test
	void testDeleteExercise() throws InvalidExerciseException
	{
		doNothing().when(exerciseRepository).deleteExercise(1);
		exerciseService.deleteExercise(1);
		verify(exerciseRepository, times(1)).deleteExercise(1);
	}
}
