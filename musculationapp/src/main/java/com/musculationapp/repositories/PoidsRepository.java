package com.musculationapp.repositories;

import com.musculationapp.models.Poids;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PoidsRepository
{

	private final Connection connection;

	// Constructeur pour injecter une connexion existante
	public PoidsRepository(Connection connection)
	{
		this.connection = connection;
	}

	// Méthode pour enregistrer un nouveau poids
	public Poids save(Poids poids)
	{
		String query = "INSERT INTO Poids (date_pesée, poids, utilisateur_id) VALUES (?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
		{
			statement.setDate(1, Date.valueOf(poids.getDatePesee()));
			statement.setDouble(2, poids.getPoids());
			statement.setLong(3, poids.getUtilisateurId());

			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0)
			{
				throw new SQLException("Échec de la création du poids, aucune ligne affectée.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys())
			{
				if (generatedKeys.next())
				{
					poids.setId(generatedKeys.getLong(1));
				}
				else
				{
					throw new SQLException("Échec de la création du poids, aucun ID obtenu.");
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return poids;
	}

	// Méthode pour récupérer l'historique des poids d’un utilisateur
	public List<Poids> findByUtilisateurId(Long utilisateurId)
	{
		List<Poids> poidsList = new ArrayList<>();
		String query = "SELECT id, date_pesée, poids FROM Poids WHERE utilisateur_id = ? ORDER BY date_pesée ASC";

		try (PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setLong(1, utilisateurId);

			try (ResultSet resultSet = statement.executeQuery())
			{
				while (resultSet.next())
				{
					Poids poids = new Poids();
					poids.setId(resultSet.getLong("id"));
					poids.setDatePesee(resultSet.getDate("date_pesée").toLocalDate());
					poids.setPoids(resultSet.getDouble("poids"));
					poids.setUtilisateurId(utilisateurId);
					poidsList.add(poids);
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return poidsList;
	}
}
