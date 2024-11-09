package com.musculationapp.repositories;

import com.musculationapp.models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository
{

	private Connection connection;

	public UserRepository(Connection connection)
	{
		this.connection = connection;
	}

	public void createUser(User user)
	{
		String query = "INSERT INTO Users (nom, prenom, pseudo, mot_de_passe, nombre_sessions) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setString(1, user.getNom());
			stmt.setString(2, user.getPrenom());
			stmt.setString(3, user.getPseudo());
			stmt.setString(4, user.getMotDePasse());
			stmt.setInt(5, user.getNombreSessions());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public User getUserById(int id)
	{
		String query = "SELECT * FROM Users WHERE id = ?";
		User user = null;
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
			{
				user = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"),
						rs.getString("mot_de_passe"), rs.getInt("nombre_sessions"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getAllUsers()
	{
		String query = "SELECT * FROM Users";
		List<User> users = new ArrayList<>();
		try (Statement stmt = connection.createStatement())
		{
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				User user = new User(rs.getString("nom"), rs.getString("prenom"),
						rs.getString("pseudo"), rs.getString("mot_de_passe"), rs.getInt("nombre_sessions"));
				users.add(user);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}

	public void updateUser(User user)
	{
		String query = "UPDATE Users SET nom = ?, prenom = ?, pseudo = ?, mot_de_passe = ?, nombre_sessions = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setString(1, user.getNom());
			stmt.setString(2, user.getPrenom());
			stmt.setString(3, user.getPseudo());
			stmt.setString(4, user.getMotDePasse());
			stmt.setInt(5, user.getNombreSessions());
			stmt.setInt(6, user.getId());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteUser(int id)
	{
		String query = "DELETE FROM Users WHERE id = ?";
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
