package com.musculationapp.repositories;

import com.musculationapp.models.Session;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository
{

	private Connection connection;

	public SessionRepository(Connection connection)
	{
		this.connection = connection;
	}

	public void createSession(Session session)
	{
		String query = "INSERT INTO Sessions (date_session, muscles_travailles, utilisateur_id) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setDate(1, Date.valueOf(session.getDateSession()));
			stmt.setString(2, session.getMusclesTravailles());
			stmt.setInt(3, session.getUtilisateurId());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Session getSessionById(int id)
	{
		String query = "SELECT * FROM Sessions WHERE id = ?";
		Session session = null;
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
			{
				session = new Session(rs.getDate("date_session").toLocalDate(),
						rs.getString("muscles_travailles"), rs.getInt("utilisateur_id"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return session;
	}

	public List<Session> getAllSessions()
	{
		String query = "SELECT * FROM Sessions";
		List<Session> sessions = new ArrayList<>();
		try (Statement stmt = connection.createStatement())
		{
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				Session session = new Session(rs.getDate("date_session").toLocalDate(),
						rs.getString("muscles_travailles"), rs.getInt("utilisateur_id"));
				sessions.add(session);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sessions;
	}

	public void updateSession(Session session)
	{
		String query = "UPDATE Sessions SET date_session = ?, muscles_travailles = ?, utilisateur_id = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setDate(1, Date.valueOf(session.getDateSession()));
			stmt.setString(2, session.getMusclesTravailles());
			stmt.setInt(3, session.getUtilisateurId());
			stmt.setInt(4, session.getId());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteSession(int id)
	{
		String query = "DELETE FROM Sessions WHERE id = ?";
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
