-- Insertion d'utilisateurs
INSERT INTO Users (nom, prenom, pseudo, mot_de_passe, nombre_sessions)
VALUES 
('Chanteux', 'Nicolas', 'N1kelaos', '28022005', 0),
('Martin', 'Lorenzo', 'Lolo', '0000', 0),
('Michel', 'Edwin', 'Doudou', '0000', 0);

-- Insertion de groupes musculaires
INSERT INTO GroupMuscles (nom)
VALUES 
('Dorsaux'),
('Pectoraux'),
('Biceps'),
('Triceps'),
('Abdos'),
('Épaules'),
('Jambes');

-- Insertion de sessions
INSERT INTO Sessions (date_session, muscles_travailles, utilisateur_id)
VALUES 
('2024-10-01', 'Pectoraux, Biceps', 1),
('2024-10-03', 'Triceps, Dorsaux', 2),
('2024-10-05', 'Épaules, Jambes', 3);

-- Insertion de la relation entre Sessions et GroupMuscles (SessionMuscles)
INSERT INTO SessionMuscles (session_id, muscle_id)
VALUES
(1, 2), -- Session 1 (Pectoraux)
(1, 3), -- Session 1 (Biceps)
(2, 4), -- Session 2 (Triceps)
(2, 1), -- Session 2 (Dorsaux)
(3, 6), -- Session 3 (Épaules)
(3, 7); -- Session 3 (Jambes)

-- Insertion d'exercices pour chaque session
INSERT INTO Exercises (nom, repetitions, duree, session_id)
VALUES
('Développé couché haltères', 8, '00:05:00', 1),
('Curl biceps sur banc', 8, '00:04:00', 1),
('Extensions triceps tresse (dessus tête)', 8, '00:04:30', 2),
('Extensions triceps tresse (debout)', 8, '00:04:30', 2),
('Tirage horizontal dorsaux', 8, '00:06:00', 2),
('Tirage vertical dorsaux', 8, '00:06:00', 2),
('Développé militaire haltères', 8, '00:05:30', 3),
('Squat', 8, '00:07:00', 3);

-- Insertion de poids pour les utilisateurs
INSERT INTO Poids (date_pesée, poids, utilisateur_id)
VALUES
('2024-09-28', 65.5, 1),
('2024-09-29', 66, 1),
('2024-10-01', 81, 2),
('2024-10-03', 81.5, 2),
('2024-10-05', 69, 3);

-- Insertion dans la table UserSessions (pour lier plusieurs utilisateurs à des sessions)
INSERT INTO UserSessions (utilisateur_id, session_id)
VALUES
(1, 1), -- Nicolas Chanteux a participé à la session 1
(2, 2), -- Lorenzo Martin a participé à la session 2
(3, 3); -- Edwin Michel a participé à la session 3
