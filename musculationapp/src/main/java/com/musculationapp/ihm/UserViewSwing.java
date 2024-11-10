package com.musculationapp.ihm;

import com.musculationapp.controllers.UserController;
import com.musculationapp.models.User;
import com.musculationapp.repositories.UserRepository;
import com.musculationapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class UserViewSwing extends JFrame
{

	private final UserController userController;
	private JTextField idField;
	private JLabel nameLabel, surnameLabel, usernameLabel, sessionCountLabel;

	@Autowired
	public UserViewSwing(UserController userController)
	{
		this.userController = userController;

		// Configurer la fenêtre
		setTitle("User Management");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		// Champ de saisie pour l'ID utilisateur
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("User ID:"), gbc);

		idField = new JTextField(10);
		gbc.gridx = 1;
		add(idField, gbc);

		JButton fetchButton = new JButton("Fetch User");
		gbc.gridx = 2;
		add(fetchButton, gbc);

		// Labels pour afficher les informations utilisateur
		nameLabel = new JLabel();
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Name:"), gbc);
		gbc.gridx = 1;
		add(nameLabel, gbc);

		surnameLabel = new JLabel();
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Surname:"), gbc);
		gbc.gridx = 1;
		add(surnameLabel, gbc);

		usernameLabel = new JLabel();
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Username:"), gbc);
		gbc.gridx = 1;
		add(usernameLabel, gbc);

		sessionCountLabel = new JLabel();
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(new JLabel("Session Count:"), gbc);
		gbc.gridx = 1;
		add(sessionCountLabel, gbc);

		// Action du bouton
		fetchButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fetchUser();
			}
		});
	}

	private void fetchUser()
	{
		try
		{
			int userId = Integer.parseInt(idField.getText());
			User user = userController.getUserById(userId);

			if (user != null)
			{
				// Afficher les informations utilisateur
				nameLabel.setText(user.getNom());
				surnameLabel.setText(user.getPrenom());
				usernameLabel.setText(user.getPseudo());
				sessionCountLabel.setText(String.valueOf(user.getNombreSessions()));
			}
			else
			{
				showErrorDialog("User Not Found", "No user found with ID " + userId);
			}
		} catch (NumberFormatException e)
		{
			showErrorDialog("Invalid ID", "Please enter a valid user ID.");
		}
	}

	private void showErrorDialog(String title, String message)
	{
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		// Créer et démarrer directement l'interface Swing
		SwingUtilities.invokeLater(() -> {
			UserService userService = new UserService(new UserRepository());
			UserController userController = new UserController(userService);
			UserViewSwing frame = new UserViewSwing(userController);
			frame.setVisible(true);
		});
	}

}
