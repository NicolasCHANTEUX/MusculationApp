import com.musculationapp.models.Poids;
import com.musculationapp.repositories.PoidsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PoidsRepositoryTest
{

	@Autowired
	private PoidsRepository poidsRepository;

	@Test
	void testSaveAndFindPoids()
	{
		Poids poids = new Poids();
		poids.setDatePesee(LocalDate.now());
		poids.setPoids(70.0);
		poids.setUtilisateurId(1L);

		Poids savedPoids = poidsRepository.save(poids);
		assertNotNull(savedPoids.getId());

		List<Poids> poidsList = poidsRepository.findByUtilisateurId(1L);
		assertFalse(poidsList.isEmpty());
		assertEquals(70.0, poidsList.get(0).getPoids());
	}
}
