package com.musculationapp.repositories;

import com.musculationapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	// Méthode pour trouver un utilisateur par son pseudo
	Optional<User> findByPseudo(String pseudo);

	// Méthode pour trouver un utilisateur par son nom
	List<User> findByNom(String nom);

	// Méthode pour trouver tous les utilisateurs
	List<User> findAll();

	// Spring Data JPA gère déjà les opérations CRUD de base, telles que :
	// - save(User user) pour créer et mettre à jour
	// - findById(Integer id) pour trouver par ID
	// - deleteById(Integer id) pour supprimer par ID
	// Ces méthodes sont héritées automatiquement de JpaRepository
}
