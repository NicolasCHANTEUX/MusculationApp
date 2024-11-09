package com.musculationapp.repositories;

import com.musculationapp.models.Exercise;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.time.Duration;
import java.time.LocalTime;

public class ExerciseRepository
{

	private Connection connection;

	public ExerciseRepository(Connection connection)
	{
		this.connection = connection;
	}

	public void createExercise(Exercise exercise)
	{
		String query = "INSERT INTO Exercises (nom, repetitions, duree, session_id) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setString(1, exercise.getNom());
			stmt.setInt(2, exercise.getRepetitions());

			// Convertir Duration en LocalTime
			long seconds = exercise.getDuree().getSeconds();
			LocalTime localTimeDuree = LocalTime.ofSecondOfDay(seconds);

			stmt.setTime(3, Time.valueOf(localTimeDuree));
			stmt.setInt(4, exercise.getSessionId());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Exercise getExerciseById(int id)
	{
		String query = "SELECT * FROM Exercises WHERE id = ?";
		Exercise exercise = null;
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			String nom = rs.getString("nom");
			int repetitions = rs.getInt("repetitions");
			LocalTime localTimeDuree = rs.getTime("duree").toLocalTime();
			Duration duree = Duration.ofHours(localTimeDuree.getHour())
									.plusMinutes(localTimeDuree.getMinute())
									.plusSeconds(localTimeDuree.getSecond());
			int sessionId = rs.getInt("session_id");

			exercise = new Exercise(nom, repetitions, duree, sessionId);
		}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return exercise;
	}

	public List<Exercise> getAllExercises()
	{
		String query = "SELECT * FROM Exercises";
		List<Exercise> exercises = new ArrayList<>();
		try (Statement stmt = connection.createStatement())
		{
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				String nom = rs.getString("nom");
				int repetitions = rs.getInt("repetitions");
				LocalTime localTimeDuree = rs.getTime("duree").toLocalTime();
				Duration duree = Duration.ofHours(localTimeDuree.getHour()).plusMinutes(localTimeDuree.getMinute())
						.plusSeconds(localTimeDuree.getSecond());
				int sessionId = rs.getInt("session_id");

				Exercise exercise = new Exercise(nom, repetitions, duree, sessionId);
				exercises.add(exercise);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return exercises;
	}

	public void updateExercise(Exercise exercise)
	{
		String query = "UPDATE Exercises SET nom = ?, repetitions = ?, duree = ?, session_id = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setString(1, exercise.getNom());
			stmt.setInt(2, exercise.getRepetitions());

			// Convertir Duration en LocalTime
			long seconds = exercise.getDuree().getSeconds();
			LocalTime localTimeDuree = LocalTime.ofSecondOfDay(seconds);

			stmt.setTime(3, Time.valueOf(localTimeDuree));
			stmt.setInt(4, exercise.getSessionId());
			stmt.setInt(5, exercise.getId());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteExercise(int id)
	{
		String query = "DELETE FROM Exercises WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
