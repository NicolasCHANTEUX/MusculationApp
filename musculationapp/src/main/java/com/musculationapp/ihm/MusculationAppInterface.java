package com.musculationapp.ihm;

import com.musculationapp.controllers.UserController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MusculationAppInterface extends JFrame
{

	public MusculationAppInterface()
	{
		setTitle("Application Musculation");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Panel du haut pour les informations de profil
		JPanel profilePanel = new JPanel(new GridBagLayout());
		profilePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		// Image de profil
		JLabel profileImageLabel = new JLabel(new ImageIcon("path/to/profile.png")); // Remplacer
																						// par
																						// le
																						// chemin
																						// de
																						// l'image
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		profilePanel.add(profileImageLabel, gbc);

		// Informations utilisateur
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		profilePanel.add(new JLabel("Nom : [Nom]"), gbc);

		gbc.gridy = 1;
		profilePanel.add(new JLabel("Prénom : [Prénom]"), gbc);

		gbc.gridy = 2;
		profilePanel.add(new JLabel("Pseudonyme : [Pseudo]"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		profilePanel.add(new JLabel("Age : [Age]"), gbc);

		gbc.gridy = 1;
		profilePanel.add(new JLabel("Poids : [Poids]"), gbc);

		gbc.gridy = 2;
		profilePanel.add(new JLabel("Taille : [Taille]"), gbc);

		// Niveau
		JPanel levelPanel = new JPanel();
		levelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		levelPanel.setPreferredSize(new Dimension(80, 80));

		JLabel levelLabel = new JLabel("<html><center>Niveau<br>11<br>11 532 XP</center></html>",
				SwingConstants.CENTER);
		levelPanel.add(levelLabel);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		profilePanel.add(levelPanel, gbc);

		add(profilePanel, BorderLayout.NORTH);

		// Historique des séances
		JPanel historyPanel = new JPanel(new BorderLayout());
		historyPanel.setBorder(BorderFactory.createTitledBorder("Historique de Séances"));

		// Table pour l'historique des séances
		String[] columnNames = { "id", "date", "titre de la séance", "exercices" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		JTable historyTable = new JTable(tableModel);

		// Ajouter des exemples de données dans le modèle de table (à remplacer
		// par les données réelles)
		tableModel.addRow(new Object[] { 1, "2024-11-08", "Séance 1", "Exercice A, Exercice B" });
		tableModel.addRow(new Object[] { 2, "2024-11-07", "Séance 2", "Exercice C, Exercice D" });

		JScrollPane tableScrollPane = new JScrollPane(historyTable);
		historyPanel.add(tableScrollPane, BorderLayout.CENTER);

		add(historyPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> new MusculationAppInterface());
	}
}
