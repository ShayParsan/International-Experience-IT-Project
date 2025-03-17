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
