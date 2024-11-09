package com.musculationapp.controllers;

import com.musculationapp.models.GroupMuscle;
import com.musculationapp.services.GroupMuscleService;

import java.util.List;

public class GroupMuscleController
{

	private GroupMuscleService groupMuscleService;

	public GroupMuscleController(GroupMuscleService groupMuscleService)
	{
		this.groupMuscleService = groupMuscleService;
	}

	public void createGroupMuscle( String nom, String description)
	{
		GroupMuscle groupMuscle = new GroupMuscle(nom, description);
		groupMuscleService.createGroupMuscle(groupMuscle);
		System.out.println("Muscle group created: " + nom);
	}

	public GroupMuscle getGroupMuscleById(int id)
	{
		return groupMuscleService.getGroupMuscleById(id);
	}

	public List<GroupMuscle> getAllGroupMuscles()
	{
		return groupMuscleService.getAllGroupMuscles();
	}

	public void updateGroupMuscle(int id, String nom, String description)
	{
		GroupMuscle groupMuscle = new GroupMuscle(nom, description);
		groupMuscleService.updateGroupMuscle(groupMuscle);
		System.out.println("Muscle group updated: " + nom);
	}

	public void deleteGroupMuscle(int id)
	{
		groupMuscleService.deleteGroupMuscle(id);
		System.out.println("Muscle group deleted: ID " + id);
	}
}
