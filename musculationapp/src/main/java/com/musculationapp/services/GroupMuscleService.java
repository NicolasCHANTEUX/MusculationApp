package com.musculationapp.services;

import com.musculationapp.models.GroupMuscle;
import com.musculationapp.repositories.GroupMuscleRepository;

import java.util.List;

public class GroupMuscleService
{

	private GroupMuscleRepository groupMuscleRepository;

	public GroupMuscleService(GroupMuscleRepository groupMuscleRepository)
	{
		this.groupMuscleRepository = groupMuscleRepository;
	}

	public void createGroupMuscle(GroupMuscle groupMuscle)
	{
		groupMuscleRepository.createGroupMuscle(groupMuscle);
	}

	public GroupMuscle getGroupMuscleById(int id)
	{
		return groupMuscleRepository.getGroupMuscleById(id);
	}

	public List<GroupMuscle> getAllGroupMuscles()
	{
		return groupMuscleRepository.getAllGroupMuscles();
	}

	public void updateGroupMuscle(GroupMuscle groupMuscle)
	{
		groupMuscleRepository.updateGroupMuscle(groupMuscle);
	}

	public void deleteGroupMuscle(int id)
	{
		groupMuscleRepository.deleteGroupMuscle(id);
	}
}
