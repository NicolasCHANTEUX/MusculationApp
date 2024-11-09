-- Étape 1 : Créer la base de données musculation_db
CREATE DATABASE musculation_db;

-- Connexion à la base de données musculation_db
\c musculation_db;

-- Étape 2 : Création de la table Users
CREATE TABLE Users (
	id SERIAL PRIMARY KEY, -- Ajout de l'attribut id pour correspondre à la classe Java
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	pseudo VARCHAR(50) UNIQUE NOT NULL,
	mot_de_passe VARCHAR(100) NOT NULL, -- longueur plus longue pour potentiellement stocker des hash
	nombre_sessions INTEGER DEFAULT 0 -- compteur de sessions
);

-- Étape 3 : Création de la table Sessions
CREATE TABLE Sessions (
	id SERIAL PRIMARY KEY,
	date_session DATE NOT NULL,
	muscles_travailles VARCHAR(255), -- les groupes musculaires seront listés ici pour l'instant
	utilisateur_id INTEGER REFERENCES Users(id) -- relation avec l'utilisateur
);

-- Étape 4 : Création de la table GroupMuscles
CREATE TABLE GroupMuscles (
	id SERIAL PRIMARY KEY,
	nom VARCHAR(50) UNIQUE NOT NULL
);

-- Étape 5 : Table intermédiaire pour lier les Sessions et les GroupMuscles
CREATE TABLE SessionMuscles (
	session_id INTEGER REFERENCES Sessions(id),
	muscle_id INTEGER REFERENCES GroupMuscles(id),
	PRIMARY KEY (session_id, muscle_id)
);

-- Étape 6 : Création de la table Poids (pour suivre l'évolution du poids des utilisateurs)
CREATE TABLE Poids (
	id SERIAL PRIMARY KEY,
	date_pesée DATE NOT NULL,
	poids DECIMAL(5,2) NOT NULL, -- deux décimales pour les poids comme 72.50 kg
	utilisateur_id INTEGER REFERENCES Users(id) -- relation avec l'utilisateur
);

-- Étape 7 : Création de la table Exercises (chaque exercice aura une durée et un nombre de répétitions)
CREATE TABLE Exercises (
	id SERIAL PRIMARY KEY,
	nom VARCHAR(100) NOT NULL,
	repetitions INTEGER NOT NULL,
	duree TIME NOT NULL, -- durée de l'exercice
	session_id INTEGER REFERENCES Sessions(id) -- chaque exercice est lié à une session
);

-- Étape 8 : Relation entre les utilisateurs et les sessions (si plusieurs utilisateurs participent à une session)
CREATE TABLE UserSessions (
	utilisateur_id INTEGER REFERENCES Users(id),
	session_id INTEGER REFERENCES Sessions(id),
	PRIMARY KEY (utilisateur_id, session_id)
);

-- Vérification des tables créées
\dt
