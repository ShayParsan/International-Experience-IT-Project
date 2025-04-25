-- Create Users Table
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_name VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL
);

-- Insert Sample Users
INSERT INTO users (user_name, password, email, first_name, last_name) VALUES
                                                                          ('user1', 'password1', 'user1@example.com', 'FirstName1', 'LastName1'),
                                                                          ('user2', 'password2', 'user2@example.com', 'FirstName2', 'LastName2');



-- Create Rewards Table
CREATE TABLE rewards (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         description TEXT NOT NULL,
                         date DATE NOT NULL,
                         rank VARCHAR(50) NOT NULL,
                         user_id INT,
                         FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert Sample Rewards
INSERT INTO rewards (name, description, date, rank, user_id) VALUES
                                                                 ('Gold Medal', 'Awarded for first place', CURRENT_DATE, 'GOLD', 1),
                                                                 ('Silver Medal', 'Awarded for second place', CURRENT_DATE, 'SILVER', 1),
                                                                 ('Bronze Medal', 'Awarded for third place', CURRENT_DATE, 'BRONZE', 2),
                                                                 ('Platinum Medal', 'Awarded for special achievement', CURRENT_DATE, 'PLATINUM', 2);

-- Create Regions Table
CREATE TABLE regions (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         temperature INT NOT NULL,
                         wind_direction VARCHAR(50) NOT NULL,
                         ph INT NOT NULL,
                         salinity INT NOT NULL
);

-- Insert Sample Regions
INSERT INTO regions (temperature, wind_direction, ph, salinity) VALUES
                                                                    (25, 'NORTH', 7, 35),
                                                                    (30, 'EAST', 6, 40),
                                                                    (20, 'SOUTH', 8, 30),
                                                                    (22, 'NORTH', 7, 30),
                                                                    (25, 'EAST', 6, 35),
                                                                    (28, 'SOUTH', 8, 40),
                                                                    (30, 'WEST', 7, 45),
                                                                    (24, 'NORTH', 6, 32),
                                                                    (26, 'EAST', 7, 38),
                                                                    (29, 'SOUTH', 8, 42),
                                                                    (31, 'WEST', 6, 46),
                                                                    (23, 'NORTH', 7, 33),
                                                                    (27, 'EAST', 6, 37),
                                                                    (30, 'SOUTH', 8, 41),
                                                                    (32, 'WEST', 7, 47),
                                                                    (21, 'NORTH', 6, 31),
                                                                    (25, 'EAST', 7, 36),
                                                                    (28, 'SOUTH', 8, 39),
                                                                    (33, 'WEST', 6, 48),
                                                                    (22, 'NORTH', 7, 34),
                                                                    (26, 'EAST', 6, 38),
                                                                    (29, 'SOUTH', 8, 43),
                                                                    (34, 'WEST', 7, 49),
                                                                    (23, 'NORTH', 6, 32),
                                                                    (27, 'EAST', 7, 39),
                                                                    (30, 'SOUTH', 8, 44),
                                                                    (35, 'WEST', 6, 50),
                                                                    (24, 'NORTH', 7, 35),
                                                                    (28, 'EAST', 6, 40),
                                                                    (31, 'SOUTH', 8, 45),
                                                                    (36, 'WEST', 7, 51),
                                                                    (25, 'NORTH', 6, 33),
                                                                    (29, 'EAST', 7, 41),
                                                                    (32, 'SOUTH', 8, 46),
                                                                    (37, 'WEST', 6, 52),
                                                                    (26, 'NORTH', 7, 36),
                                                                    (30, 'EAST', 6, 42),
                                                                    (33, 'SOUTH', 8, 47),
                                                                    (38, 'WEST', 7, 53),
                                                                    (27, 'NORTH', 6, 34),
                                                                    (31, 'EAST', 7, 43),
                                                                    (34, 'SOUTH', 8, 48),
                                                                    (39, 'WEST', 6, 54),
                                                                    (28, 'NORTH', 7, 37),
                                                                    (32, 'EAST', 6, 44),
                                                                    (35, 'SOUTH', 8, 49),
                                                                    (40, 'WEST', 7, 55),
                                                                    (29, 'NORTH', 6, 35),
                                                                    (33, 'EAST', 7, 45),
                                                                    (36, 'SOUTH', 8, 50),
                                                                    (41, 'WEST', 6, 56),
                                                                    (30, 'NORTH', 7, 38),
                                                                    (34, 'EAST', 6, 46);

-- Create Collections Table
CREATE TABLE collections (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(255) NOT NULL UNIQUE,
                             address VARCHAR(255) NOT NULL,
                             number VARCHAR(50) NOT NULL
);

-- Insert Sample Collections
INSERT INTO collections (name, address, number) VALUES
                                                    ('Collection1', 'Address1', 'Number1'),
                                                    ('Collection2', 'Address2', 'Number2'),
                                                    ('Collection3', 'Address3', 'Number3'),
                                                    ('Collection4', 'Address4', 'Number4'),
                                                    ('Collection5', 'Address5', 'Number5'),
                                                    ('Collection6', 'Address6', 'Number6'),
                                                    ('Collection7', 'Address7', 'Number7'),
                                                    ('Collection8', 'Address8', 'Number8'),
                                                    ('Collection9', 'Address9', 'Number9'),
                                                    ('Collection10', 'Address10', 'Number10'),
                                                    ('Collection11', 'Address11', 'Number11'),
                                                    ('Collection12', 'Address12', 'Number12'),
                                                    ('Collection13', 'Address13', 'Number13'),
                                                    ('Collection14', 'Address14', 'Number14'),
                                                    ('Collection15', 'Address15', 'Number15'),
                                                    ('Collection16', 'Address16', 'Number16'),
                                                    ('Collection17', 'Address17', 'Number17'),
                                                    ('Collection18', 'Address18', 'Number18'),
                                                    ('Collection19', 'Address19', 'Number19'),
                                                    ('Collection20', 'Address20', 'Number20'),
                                                    ('Collection21', 'Address21', 'Number21'),
                                                    ('Collection22', 'Address22', 'Number22'),
                                                    ('Collection23', 'Address23', 'Number23'),
                                                    ('Collection24', 'Address24', 'Number24'),
                                                    ('Collection25', 'Address25', 'Number25'),
                                                    ('Collection26', 'Address26', 'Number26'),
                                                    ('Collection27', 'Address27', 'Number27'),
                                                    ('Collection28', 'Address28', 'Number28'),
                                                    ('Collection29', 'Address29', 'Number29'),
                                                    ('Collection30', 'Address30', 'Number30'),
                                                    ('Collection31', 'Address31', 'Number31'),
                                                    ('Collection32', 'Address32', 'Number32'),
                                                    ('Collection33', 'Address33', 'Number33'),
                                                    ('Collection34', 'Address34', 'Number34'),
                                                    ('Collection35', 'Address35', 'Number35'),
                                                    ('Collection36', 'Address36', 'Number36'),
                                                    ('Collection37', 'Address37', 'Number37'),
                                                    ('Collection38', 'Address38', 'Number38'),
                                                    ('Collection39', 'Address39', 'Number39'),
                                                    ('Collection40', 'Address40', 'Number40'),
                                                    ('Collection41', 'Address41', 'Number41'),
                                                    ('Collection42', 'Address42', 'Number42'),
                                                    ('Collection43', 'Address43', 'Number43'),
                                                    ('Collection44', 'Address44', 'Number44'),
                                                    ('Collection45', 'Address45', 'Number45'),
                                                    ('Collection46', 'Address46', 'Number46'),
                                                    ('Collection47', 'Address47', 'Number47'),
                                                    ('Collection48', 'Address48', 'Number48'),
                                                    ('Collection49', 'Address49', 'Number49'),
                                                    ('Collection50', 'Address50', 'Number50'),
                                                    ('Collection51', 'Address51', 'Number51'),
                                                    ('Collection52', 'Address52', 'Number52');

-- Create Input Variable Table
CREATE TABLE input_variable (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                time TIMESTAMP NOT NULL,
                                temperature FLOAT,
                                ph FLOAT
);

-- Insert Sample Values
INSERT INTO input_variable (time, temperature, ph) VALUES
                                                       ('2023-03-24 08:00:00', 22.5, 7.1),
                                                       ('2023-03-24 09:00:00', 23.0, 7.2),
                                                       ('2023-03-24 10:00:00', 23.5, 7.3),
                                                       ('2023-03-24 11:00:00', 24.0, 7.4),
                                                       ('2023-03-24 12:00:00', 24.5, 7.5),
                                                       ('2023-03-24 13:00:00', 25.0, 7.6),
                                                       ('2023-03-24 14:00:00', 25.5, 7.7),
                                                       ('2023-03-24 15:00:00', 26.0, 7.8),
                                                       ('2023-03-24 16:00:00', 26.5, 7.9),
                                                       ('2023-03-24 17:00:00', 27.0, 8.0),
                                                       ('2023-03-24 18:00:00', 27.5, 8.1),
                                                       ('2023-03-24 19:00:00', 28.0, 8.2),
                                                       ('2023-03-24 20:00:00', 28.5, 8.3),
                                                       ('2023-03-24 21:00:00', 29.0, 8.4),
                                                       ('2023-03-24 22:00:00', 29.5, 8.5),
                                                       ('2023-03-24 23:00:00', 30.0, 8.6),
                                                       ('2023-03-25 00:00:00', 30.5, 8.7),
                                                       ('2023-03-25 01:00:00', 31.0, 8.8),
                                                       ('2023-03-25 02:00:00', 31.5, 8.9),
                                                       ('2023-03-25 03:00:00', 32.0, 9.0),
                                                       ('2023-03-25 04:00:00', 32.5, 9.1),
                                                       ('2023-03-25 05:00:00', 33.0, 9.2),
                                                       ('2023-03-25 06:00:00', 33.5, 9.3),
                                                       ('2023-03-25 07:00:00', 34.0, 9.4),
                                                       ('2023-03-25 08:00:00', 34.5, 9.5),
                                                       ('2023-03-25 09:00:00', 35.0, 9.6),
                                                       ('2023-03-25 10:00:00', 35.5, 9.7),
                                                       ('2023-03-25 11:00:00', 36.0, 9.8),
                                                       ('2023-03-25 12:00:00', 36.5, 9.9),
                                                       ('2023-03-25 13:00:00', 37.0, 10.0),
                                                       ('2023-03-25 14:00:00', 37.5, 10.1),
                                                       ('2023-03-25 15:00:00', 38.0, 10.2),
                                                       ('2023-03-25 16:00:00', 38.5, 10.3),
                                                       ('2023-03-25 17:00:00', 39.0, 10.4),
                                                       ('2023-03-25 18:00:00', 39.5, 10.5),
                                                       ('2023-03-25 19:00:00', 40.0, 10.6),
                                                       ('2023-03-25 20:00:00', 40.5, 10.7),
                                                       ('2023-03-25 21:00:00', 41.0, 10.8),
                                                       ('2023-03-25 22:00:00', 41.5, 10.9),
                                                       ('2023-03-25 23:00:00', 42.0, 11.0),
                                                       ('2023-03-26 00:00:00', 42.5, 11.1),
                                                       ('2023-03-26 01:00:00', 43.0, 11.2),
                                                       ('2023-03-26 02:00:00', 43.5, 11.3),
                                                       ('2023-03-26 03:00:00', 44.0, 11.4),
                                                       ('2023-03-26 04:00:00', 44.5, 11.5),
                                                       ('2023-03-26 05:00:00', 45.0, 11.6),
                                                       ('2023-03-26 06:00:00', 45.5, 11.7),
                                                       ('2023-03-26 07:00:00', 46.0, 11.8),
                                                       ('2023-03-26 08:00:00', 46.5, 11.9),
                                                       ('2023-03-26 09:00:00', 47.0, 12.0),
                                                       ('2023-03-26 10:00:00', 47.5, 12.1),
                                                       ('2023-03-26 11:00:00', 48.0, 12.2),
                                                       ('2023-03-26 12:00:00', 48.5, 12.3),
                                                       ('2023-03-26 13:00:00', 49.0, 12.4),
                                                       ('2023-03-26 14:00:00', 49.5, 12.5),
                                                       ('2023-03-26 15:00:00', 50.0, 12.6),
                                                       ('2023-03-26 16:00:00', 50.5, 12.7),
                                                       ('2023-03-26 17:00:00', 51.0, 12.8);

INSERT INTO users (user_name, password, email, first_name, last_name) VALUES
    ('john_doe', 'secure123', 'john@example.com', 'John', 'Doe');

INSERT INTO rewards (name, description, date, rank, user_id) VALUES
    ('Diamond Medal', 'Elite achievement award', CURRENT_DATE, 'DIAMOND', 3);
