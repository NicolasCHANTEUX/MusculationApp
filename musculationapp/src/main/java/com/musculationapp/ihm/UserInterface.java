package com.musculationapp.ihm;

import com.musculationapp.models.User;
import com.musculationapp.services.UserService;
import com.musculationapp.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Scanner;

public class UserInterface
{
	private UserService userService;
	private Scanner scanner;

	public UserInterface(UserService userService)
	{
		this.userService = userService;
		this.scanner = new Scanner(System.in);
	}

	public void start()
	{
		while (true)
		{
			System.out.println("===== Menu Utilisateur =====");
			System.out.println("1. Créer un utilisateur");
			System.out.println("2. Voir un utilisateur par ID");
			System.out.println("3. Voir tous les utilisateurs");
			System.out.println("4. Mettre à jour un utilisateur");
			System.out.println("5. Supprimer un utilisateur");
			System.out.println("0. Quitter");
			System.out.print("Choisissez une option : ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consomme la nouvelle ligne

			switch (choice)
			{
			case 1:
				createUser();
				break;
			case 2:
				viewUserById();
				break;
			case 3:
				viewAllUsers();
				break;
			case 4:
				updateUser();
				break;
			case 5:
				deleteUser();
				break;
			case 0:
				System.out.println("Au revoir !");
				return;
			default:
				System.out.println("Option invalide. Veuillez réessayer.");
			}
		}
	}

	private void createUser()
	{
		System.out.print("Nom : ");
		String nom = scanner.nextLine();
		System.out.print("Prénom : ");
		String prenom = scanner.nextLine();
		System.out.print("Pseudo : ");
		String pseudo = scanner.nextLine();
		System.out.print("Mot de passe : ");
		String motDePasse = scanner.nextLine();
		System.out.print("Nombre de sessions : ");
		int nombreSessions = scanner.nextInt();
		scanner.nextLine(); // Consomme la nouvelle ligne

		User user = new User(nom, prenom, pseudo, motDePasse, nombreSessions);
		userService.createUser(user);
		System.out.println("Utilisateur créé avec succès !");
	}

	private void viewUserById()
	{
		System.out.print("ID de l'utilisateur : ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consomme la nouvelle ligne

		try
		{
			User user = userService.getUserById(id);
			System.out.println("Nom : " + user.getNom());
			System.out.println("Prénom : " + user.getPrenom());
			System.out.println("Pseudo : " + user.getPseudo());
			System.out.println("Nombre de sessions : " + user.getNombreSessions());
		} catch (UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void viewAllUsers()
	{
		List<User> users = userService.getAllUsers();
		if (users.isEmpty())
		{
			System.out.println("Aucun utilisateur trouvé.");
		}
		else
		{
			for (User user : users)
			{
				System.out.println("ID : " + user.getId() + " | Nom : " + user.getNom() + " | Prénom : "
						+ user.getPrenom() + " | Pseudo : " + user.getPseudo() + " | Nombre de sessions : "
						+ user.getNombreSessions());
			}
		}
	}

	private void updateUser()
	{
		System.out.print("ID de l'utilisateur à mettre à jour : ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consomme la nouvelle ligne

		try
		{
			User user = userService.getUserById(id);
			System.out.print("Nouveau nom (actuel : " + user.getNom() + ") : ");
			user.setNom(scanner.nextLine());
			System.out.print("Nouveau prénom (actuel : " + user.getPrenom() + ") : ");
			user.setPrenom(scanner.nextLine());
			System.out.print("Nouveau pseudo (actuel : " + user.getPseudo() + ") : ");
			user.setPseudo(scanner.nextLine());
			System.out.print("Nouveau mot de passe (actuel : " + user.getMotDePasse() + ") : ");
			user.setMotDePasse(scanner.nextLine());
			System.out.print("Nouveau nombre de sessions (actuel : " + user.getNombreSessions() + ") : ");
			user.setNombreSessions(scanner.nextInt());
			scanner.nextLine(); // Consomme la nouvelle ligne

			userService.updateUser(user);
			System.out.println("Utilisateur mis à jour avec succès !");
		} catch (UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void deleteUser()
	{
		System.out.print("ID de l'utilisateur à supprimer : ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consomme la nouvelle ligne

		try
		{
			userService.deleteUser(id);
			System.out.println("Utilisateur supprimé avec succès !");
		} catch (UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
