package com.musculationapp.services;

import com.musculationapp.models.GroupMuscle;
import com.musculationapp.repositories.GroupMuscleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroupMuscleServiceTest
{

	@Mock
	private GroupMuscleRepository groupMuscleRepository;

	@InjectMocks
	private GroupMuscleService groupMuscleService;

	private GroupMuscle groupMuscle;

	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
		groupMuscle = new GroupMuscle("Dorsaux", "");
	}

	@Test
	void testGetGroupMuscleById()
	{
		when(groupMuscleRepository.getGroupMuscleById(1)).thenReturn(groupMuscle);
		GroupMuscle foundGroupMuscle = groupMuscleService.getGroupMuscleById(1);
		assertNotNull(foundGroupMuscle);
		assertEquals(groupMuscle.getNom(), foundGroupMuscle.getNom());
	}

	@Test
	void testCreateGroupMuscle()
	{
		doNothing().when(groupMuscleRepository).createGroupMuscle(groupMuscle);
		groupMuscleService.createGroupMuscle(groupMuscle);
		verify(groupMuscleRepository, times(1)).createGroupMuscle(groupMuscle);
	}

	@Test
	void testDeleteGroupMuscle()
	{
		doNothing().when(groupMuscleRepository).deleteGroupMuscle(1);
		groupMuscleService.deleteGroupMuscle(1);
		verify(groupMuscleRepository, times(1)).deleteGroupMuscle(1);
	}
}
