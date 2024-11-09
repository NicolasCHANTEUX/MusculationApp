package com.musculationapp.repositories;

import com.musculationapp.models.GroupMuscle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupMuscleRepository
{

	private Connection connection;

	public GroupMuscleRepository(Connection connection)
	{
		this.connection = connection;
	}

	public void createGroupMuscle(GroupMuscle groupMuscle)
	{
		String query = "INSERT INTO GroupMuscles (nom, description) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setString(1, groupMuscle.getNom());
			stmt.setString(2, groupMuscle.getDescription());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public GroupMuscle getGroupMuscleById(int id)
	{
		String query = "SELECT * FROM GroupMuscles WHERE id = ?";
		GroupMuscle groupMuscle = null;
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
			{
				groupMuscle = new GroupMuscle(rs.getString("nom"), rs.getString("description"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return groupMuscle;
	}

	public List<GroupMuscle> getAllGroupMuscles()
	{
		String query = "SELECT * FROM GroupMuscles";
		List<GroupMuscle> groupMuscles = new ArrayList<>();
		try (Statement stmt = connection.createStatement())
		{
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				GroupMuscle groupMuscle = new GroupMuscle(rs.getString("nom"), rs.getString("description"));
				groupMuscles.add(groupMuscle);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return groupMuscles;
	}

	public void updateGroupMuscle(GroupMuscle groupMuscle)
	{
		String query = "UPDATE GroupMuscles SET nom = ?, description = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query))
		{
			stmt.setString(1, groupMuscle.getNom());
			stmt.setString(2, groupMuscle.getDescription());
			stmt.setInt(3, groupMuscle.getId());
			stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteGroupMuscle(int id)
	{
		String query = "DELETE FROM GroupMuscles WHERE id = ?";
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
