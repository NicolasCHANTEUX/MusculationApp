package com.musculationapp.controllers;

import com.musculationapp.models.GroupMuscle;
import com.musculationapp.services.GroupMuscleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroupMuscleControllerTest
{

	private GroupMuscleService groupMuscleService;
	private GroupMuscleController groupMuscleController;

	@BeforeEach
	void setUp()
	{
		groupMuscleService = mock(GroupMuscleService.class);
		groupMuscleController = new GroupMuscleController(groupMuscleService);
	}

	@Test
	void testCreateGroupMuscle()
	{
		groupMuscleController.createGroupMuscle("Pectoraux", "");
		verify(groupMuscleService, times(1)).createGroupMuscle(any(GroupMuscle.class));
	}

	@Test
	void testGetGroupMuscleById()
	{
		GroupMuscle groupMuscle = new GroupMuscle("Pectoraux", "");
		when(groupMuscleService.getGroupMuscleById(1)).thenReturn(groupMuscle);

		GroupMuscle result = groupMuscleController.getGroupMuscleById(1);
		assertNotNull(result);
		assertEquals("Pectoraux", result.getNom());
	}

	@Test
	void testGetAllGroupMuscles()
	{
		List<GroupMuscle> groupMuscles = Arrays.asList(new GroupMuscle("Pectoraux", ""), new GroupMuscle("Biceps", ""));
		when(groupMuscleService.getAllGroupMuscles()).thenReturn(groupMuscles);

		List<GroupMuscle> result = groupMuscleController.getAllGroupMuscles();
		assertEquals(2, result.size());
	}

	@Test
	void testUpdateGroupMuscle()
	{
		groupMuscleController.updateGroupMuscle(1, "Pectoraux", "");
		verify(groupMuscleService, times(1)).updateGroupMuscle(any(GroupMuscle.class));
	}

	@Test
	void testDeleteGroupMuscle()
	{
		groupMuscleController.deleteGroupMuscle(1);
		verify(groupMuscleService, times(1)).deleteGroupMuscle(1);
	}
}
