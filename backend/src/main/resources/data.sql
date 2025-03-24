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
                         rank VARCHAR(50) NOT NULL
);

-- Insert Sample Rewards
INSERT INTO rewards (name, description, date, rank) VALUES
                                                        ('Gold Medal', 'Awarded for first place', CURRENT_DATE, 'GOLD'),
                                                        ('Silver Medal', 'Awarded for second place', CURRENT_DATE, 'SILVER'),
                                                        ('Bronze Medal', 'Awarded for third place', CURRENT_DATE, 'BRONZE'),
                                                        ('Platinum Medal', 'Awarded for special achievement', CURRENT_DATE, 'PLATINUM');

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
                                                                    (20, 'SOUTH', 8, 30);

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
                                                    ('Collection3', 'Address3', 'Number3');

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
                                                       ('2023-03-24 17:00:00', 27.0, 8.0);
