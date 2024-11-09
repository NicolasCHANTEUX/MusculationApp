package com.musculationapp.repositories;

import com.musculationapp.models.GroupMuscle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GroupMuscleRepositoryTest
{

	@Autowired
	private GroupMuscleRepository groupMuscleRepository;

	@Test
	void testSaveAndFindGroupMuscle()
	{
		GroupMuscle groupMuscle = new GroupMuscle("Dorsaux", "Muscles du dos");
		groupMuscleRepository.createGroupMuscle(groupMuscle);	}

	@Test
	void testDeleteGroupMuscle()
	{
		GroupMuscle groupMuscle = new GroupMuscle("Pectoraux", "Muscles de la poitrine");
		GroupMuscle savedGroupMuscle = groupMuscleRepository.save(groupMuscle);
		groupMuscleRepository.deleteGroupMuscle(savedGroupMuscle.getId());
		Optional<GroupMuscle> foundGroupMuscle = groupMuscleRepository.findById(savedGroupMuscle.getId());
		assertFalse(foundGroupMuscle.isPresent());
	}
}
