package com.musculationapp.repositories;

import com.musculationapp.models.Exercise;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseRepositoryTest
{

	private ExerciseRepository exerciseRepository;
	@Test
	void testCreateAndGetExercise()
	{
		// Création de l'Exercise
		Exercise exercise = new Exercise("Développé couché haltères", 8, Duration.ofMinutes(5), 1);
		exerciseRepository.createExercise(exercise);

		// Récupération de l'exercise par son ID
		Exercise foundExercise = exerciseRepository.getExerciseById(exercise.getId());
		assertNotNull(foundExercise);
		assertEquals(exercise.getNom(), foundExercise.getNom());
	}

	@Test
	void testDeleteExercise()
	{
		Exercise exercise = new Exercise("Curl biceps", 8, Duration.ofMinutes(4), 1);
		exerciseRepository.createExercise(exercise);

		// Suppression de l'exercice
		exerciseRepository.deleteExercise(exercise.getId());

		// Vérification que l'exercice n'existe plus
		Exercise foundExercise = exerciseRepository.getExerciseById(exercise.getId());
		assertNull(foundExercise);
	}
}
