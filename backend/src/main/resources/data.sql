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
    ('John Smith', '12 Lakeview Rd, Riverdale', 23),
    ('EcoLab Solutions', '98 Dockside Ln, Harbor City', 7),
    ('Sarah Johnson', '34 Forest Path, Greenhill', 45),
    ('Bay Water Analytics', '45 Sunset Blvd, Baytown', 11),
    ('Michael Lee', '88 Pinecrest Dr, Westfield', 60),
    ('GreenTech Labs', '120 Maple Ave, Ridgeway', 18),
    ('Emily Davis', '17 North Shore, Lakeside', 5),
    ('ClearFlow Inc.', '21 Elm St, Valleyton', 33),
    ('Laura Chen', '409 Spring Rd, Crystal City', 27),
    ('AquaInsight Co.', '77 Brook Ln, Stoneville', 49),
    ('Daniel Harris', '11 Coastal Dr, Oceanview', 16),
    ('CleanStream Ltd.', '155 Grove St, Cedar Hill', 39),
    ('Natalie Wright', '73 Summit Dr, Hilltown', 2),
    ('FreshWater Tech', '44 Ridge Ln, Windy Bluffs', 52),
    ('James Anderson', '59 Bluewater Rd, Eastbay', 9),
    ('EnviroScan Corp.', '84 Ironwood Ct, Forestedge', 36),
    ('Olivia Thomas', '65 Goldenfield Dr, Meadowbrook', 4),
    ('PureSource Analytics', '18 Lakeside Blvd, Silverlake', 41),
    ('William Martinez', '99 Ridge Rd, Oakridge', 13),
    ('H2O Watch', '22 Riverbend Dr, Riverbend', 28),
    ('Ava Wilson', '51 Creekside Ln, Shadowton', 55),
    ('HydroTech Engineers', '19 Quarry Rd, Granite Falls', 20),
    ('Sophia Clark', '62 Prairie Ln, Meadowlands', 8),
    ('Blue Drop Labs', '43 Marina Rd, Clearwater', 31),
    ('Benjamin Lewis', '15 Shoreline Ave, Northshore', 50),
    ('NatureScan Environmental', '74 Hollow Dr, Foxtown', 26),
    ('Isabella Young', '27 Pebble Rd, Brookhaven', 14),
    ('WaterGuard Systems', '81 Canyon Edge Dr, Canyonside', 57),
    ('Ethan Hall', '93 Birchwood Ln, Birchville', 6),
    ('HydroView Analytics', '60 Pines Rd, Whisperfield', 22),
    ('Madison Scott', '39 Tranquil Lake Rd, Serenity', 44),
    ('Streamline Tech', '50 Waterflow Blvd, Springfield', 10),
    ('Abigail King', '88 Main St, Eastvale', 53),
    ('OceanPure Labs', '42 Highpoint Rd, Mountview', 35),
    ('Elijah Turner', '69 Waverly Dr, Waverly Hills', 29),
    ('CleanCurrent Corp.', '91 Bayridge Ln, Bayport', 12),
    ('Mia Lopez', '25 Creek Path, Hidden Creek', 58),
    ('RiverSafe Environmental', '78 Redwood Dr, Redvale', 3),
    ('Alexander Allen', '31 Frostlake Rd, Snowtown', 47),
    ('EcoWave Systems', '13 Sunnybrook Ave, Brightvale', 1),
    ('Grace Hill', '83 Hollow Rd, Moosefield', 17),
    ('BlueHaven Waterworks', '24 Thunderhill Blvd, Stormy Ridge', 40),
    ('Jacob Nelson', '56 Greenfield Dr, Plainsville', 30),
    ('PureEarth Ltd.', '14 Willowbend Ln, Willowtown', 25),
    ('Victoria Adams', '48 Shoal Rd, Rockport', 42),
    ('FreshFlow Inc.', '30 Brighthaven Blvd, Havenfield', 54),
    ('Jackson Perez', '90 Crest Rd, Eagle Heights', 21),
    ('WaveCheck Services', '38 Bay Crescent, Crescent City', 46),
    ('Lily Moore', '66 Bridge Ln, Stonebridge', 43),
    ('AquaSystems Group', '72 Old Mill Rd, Milltown', 59),
    ('Logan Rivera', '20 Watchtower Ln, Riverwatch', 19),
    ('CrystalBlue Monitoring', '85 Hollowpoint Dr, Edgewood', 34);

CREATE TABLE input_variable (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                time TIMESTAMP NOT NULL,
                                temperature FLOAT,
                                ph FLOAT,
                                tds FLOAT,
                                water_hyacinth_growth FLOAT
);

INSERT INTO input_variable (time, temperature, ph, tds, water_hyacinth_growth) VALUES
    ('2015-01-01', 334.93, 7.37, 18.81, 46.82),
    ('2015-02-01', 340.54, 7.2, 22.33, 57.78),
    ('2015-03-01', 362.95, 7.35, 25.09, 54.53),
    ('2015-04-01', 373.76, 6.94, 26.3, 60.02),
    ('2015-05-01', 320.32, 6.98, 22.53, 53.22),
    ('2015-06-01', 295.32, 7.01, 22.0, 45.74),
    ('2015-07-01', 306.58, 6.61, 19.29, 44.6),
    ('2015-08-01', 272.05, 6.65, 16.52, 37.75),
    ('2015-09-01', 240.61, 6.8, 18.32, 39.59),
    ('2015-10-01', 267.55, 6.87, 15.61, 32.67),
    ('2015-11-01', 265.73, 6.92, 13.78, 33.92),
    ('2015-12-01', 290.69, 7.22, 18.88, 44.9),
    ('2016-01-01', 329.84, 7.18, 23.18, 58.16),
    ('2016-02-01', 305.04, 7.34, 24.05, 55.45),
    ('2016-03-01', 315.5, 7.12, 22.05, 59.38),
    ('2016-04-01', 332.06, 7.23, 24.27, 48.71),
    ('2016-05-01', 304.74, 6.84, 26.23, 58.63),
    ('2016-06-01', 306.28, 6.76, 21.44, 47.9),
    ('2016-07-01', 256.84, 6.79, 20.67, 54.37),
    ('2016-08-01', 228.45, 6.59, 18.66, 34.55),
    ('2016-09-01', 279.31, 6.81, 14.28, 30.81),
    ('2016-10-01', 252.18, 7.05, 14.91, 31.87),
    ('2016-11-01', 276.35, 6.92, 10.81, 19.24),
    ('2016-12-01', 271.51, 7.23, 15.96, 34.43),
    ('2017-01-01', 314.11, 7.32, 19.62, 40.71),
    ('2017-02-01', 345.52, 7.37, 20.63, 48.23),
    ('2017-03-01', 326.98, 7.09, 26.78, 58.05),
    ('2017-04-01', 350.82, 6.95, 22.85, 61.09),
    ('2017-05-01', 312.99, 6.97, 23.67, 55.86),
    ('2017-06-01', 294.17, 6.82, 22.7, 45.5),
    ('2017-07-01', 262.97, 6.74, 22.16, 41.37),
    ('2017-08-01', 293.74, 6.74, 15.35, 39.66),
    ('2017-09-01', 249.73, 6.72, 17.41, 31.45),
    ('2017-10-01', 235.54, 6.95, 15.02, 43.35),
    ('2017-11-01', 291.45, 7.11, 14.2, 41.55),
    ('2017-12-01', 275.58, 7.14, 18.19, 38.44),
    ('2018-01-01', 329.18, 7.48, 20.3, 37.39),
    ('2018-02-01', 304.11, 7.34, 21.6, 53.7),
    ('2018-03-01', 323.44, 7.09, 24.43, 52.07),
    ('2018-04-01', 347.24, 7.14, 24.42, 59.9),
    ('2018-05-01', 339.77, 6.82, 24.5, 45.42),
    ('2018-06-01', 303.43, 6.87, 23.49, 47.15),
    ('2018-07-01', 272.69, 6.83, 22.38, 46.88),
    ('2018-08-01', 250.68, 6.63, 15.64, 35.49),
    ('2018-09-01', 220.43, 6.88, 18.87, 36.84),
    ('2018-10-01', 242.3, 6.96, 12.07, 33.26),
    ('2018-11-01', 265.79, 7.16, 15.44, 30.79),
    ('2018-12-01', 321.14, 7.4, 18.38, 42.12),
    ('2019-01-01', 331.87, 7.27, 20.42, 47.3),
    ('2019-02-01', 308.04, 7.21, 21.57, 49.89),
    ('2019-03-01', 356.48, 7.12, 24.02, 57.16),
    ('2019-04-01', 335.6, 7.0, 24.26, 47.54),
    ('2019-05-01', 311.46, 6.91, 23.45, 42.9),
    ('2019-06-01', 312.23, 6.82, 23.77, 57.31),
    ('2019-07-01', 295.62, 6.74, 20.54, 46.72),
    ('2019-08-01', 275.32, 6.79, 16.46, 34.3),
    ('2019-09-01', 233.22, 6.79, 17.02, 44.52),
    ('2019-10-01', 250.51, 7.07, 15.46, 36.16),
    ('2019-11-01', 281.63, 7.05, 16.89, 45.21),
    ('2019-12-01', 319.51, 7.48, 18.44, 43.01),
    ('2020-01-01', 315.42, 7.35, 18.76, 53.5),
    ('2020-02-01', 339.59, 7.2, 21.66, 57.84),
    ('2020-03-01', 327.87, 7.11, 25.45, 53.12),
    ('2020-04-01', 319.38, 7.13, 25.92, 59.45),
    ('2020-05-01', 341.25, 6.9, 24.3, 56.54),
    ('2020-06-01', 327.12, 6.86, 22.68, 56.93),
    ('2020-07-01', 273.56, 6.76, 21.92, 41.24),
    ('2020-08-01', 276.77, 6.7, 16.61, 41.59),
    ('2020-09-01', 257.23, 6.7, 16.49, 42.3),
    ('2020-10-01', 243.8, 6.77, 14.7, 24.98),
    ('2020-11-01', 282.23, 7.03, 15.34, 31.14),
    ('2020-12-01', 330.76, 7.3, 19.15, 34.47),
    ('2021-01-01', 324.28, 7.31, 21.24, 46.1),
    ('2021-02-01', 374.59, 7.17, 23.72, 57.57),
    ('2021-03-01', 297.61, 7.23, 26.29, 61.37),
    ('2021-04-01', 359.74, 7.12, 25.03, 55.67),
    ('2021-05-01', 326.74, 6.83, 25.35, 62.18),
    ('2021-06-01', 294.02, 6.8, 22.03, 40.46),
    ('2021-07-01', 276.84, 6.72, 20.49, 35.49),
    ('2021-08-01', 216.95, 6.6, 17.3, 35.72),
    ('2021-09-01', 245.61, 6.82, 15.82, 37.57),
    ('2021-10-01', 263.84, 6.98, 15.89, 36.82),
    ('2021-11-01', 304.56, 7.19, 14.44, 26.18),
    ('2021-12-01', 289.63, 7.32, 20.64, 44.36),
    ('2022-01-01', 308.83, 7.15, 18.49, 36.35),
    ('2022-02-01', 333.27, 7.2, 20.68, 50.64),
    ('2022-03-01', 368.31, 7.26, 26.07, 58.82),
    ('2022-04-01', 349.88, 7.13, 26.19, 51.82),
    ('2022-05-01', 314.4, 6.97, 25.27, 51.0),
    ('2022-06-01', 310.27, 7.17, 23.44, 45.03),
    ('2022-07-01', 276.94, 6.77, 19.98, 43.04),
    ('2022-08-01', 276.07, 6.82, 16.15, 42.46),
    ('2022-09-01', 235.96, 6.88, 15.78, 30.31),
    ('2022-10-01', 250.15, 6.99, 13.98, 35.98),
    ('2022-11-01', 267.16, 7.05, 17.13, 36.31),
    ('2022-12-01', 270.73, 7.29, 17.28, 34.92),
    ('2023-01-01', 330.92, 7.21, 18.76, 43.73),
    ('2023-02-01', 348.52, 7.27, 22.02, 44.74),
    ('2023-03-01', 350.1, 7.16, 24.95, 51.83),
    ('2023-04-01', 338.61, 7.09, 24.15, 47.0),
    ('2023-05-01', 296.69, 7.15, 23.1, 59.0),
    ('2023-06-01', 291.59, 6.6, 22.87, 48.26),
    ('2023-07-01', 268.15, 6.78, 20.37, 40.02),
    ('2023-08-01', 240.65, 6.55, 16.74, 37.31),
    ('2023-09-01', 246.77, 6.74, 14.96, 33.7),
    ('2023-10-01', 264.78, 7.03, 15.35, 35.09),
    ('2023-11-01', 312.72, 7.08, 13.5, 38.79),
    ('2023-12-01', 303.49, 7.1, 15.39, 41.84),
    ('2024-01-01', 330.15, 7.22, 18.92, 41.8),
    ('2024-02-01', 341.81, 7.36, 22.18, 46.77),
    ('2024-03-01', 311.62, 7.14, 24.8, 51.12),
    ('2024-04-01', 342.77, 7.1, 27.21, 46.25),
    ('2024-05-01', 326.2, 6.93, 25.62, 47.01),
    ('2024-06-01', 349.26, 6.72, 22.26, 57.13),
    ('2024-07-01', 271.15, 6.92, 19.97, 51.59),
    ('2024-08-01', 262.73, 6.77, 16.0, 35.43),
    ('2024-09-01', 249.31, 6.59, 15.64, 37.98),
    ('2024-10-01', 233.33, 6.94, 14.57, 34.96),
    ('2024-11-01', 297.86, 7.01, 16.15, 54.5),
    ('2024-12-01', 315.04, 7.3, 16.26, 45.14);

INSERT INTO users (user_name, password, email, first_name, last_name) VALUES
    ('john_doe', 'secure123', 'john@example.com', 'John', 'Doe');

INSERT INTO rewards (name, description, date, rank, user_id) VALUES
    ('Diamond Medal', 'Elite achievement award', CURRENT_DATE, 'DIAMOND', 3);




-- Add user Koos (password hashed with SHA-256)
INSERT INTO users (user_name, password, email, first_name, last_name) VALUES
    ('Koos', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'koos@example.com', 'Koos', 'Pretorius');



INSERT INTO rewards (name, description, date, rank, user_id) VALUES
    ('Koos Starter Badge',   'Awarded for signing up',           CURRENT_DATE, 'BRONZE',   4),
    ('Koos Quick Learner',    'Completed first tutorial',         CURRENT_DATE, 'SILVER',   4),
    ('Koos Consistency Star', 'Logged in 7 days in a row',        CURRENT_DATE, 'GOLD',     4),
    ('Koos Power User',       'Reached power-user level',         CURRENT_DATE, 'PLATINUM', 4),
    ('Koos Elite Achiever',   'Top 1% of activity this month',    CURRENT_DATE, 'DIAMOND',  4),
    ('Koos Marathoner',       'Performed 100 actions total',      CURRENT_DATE, 'GOLD',     4),
    ('Koos Social Butterfly', 'Made 50 connections',              CURRENT_DATE, 'SILVER',   4),
    ('Koos Feedback Guru',    'Submitted 20 feedback items',      CURRENT_DATE, 'BRONZE',   4),
    ('Koos Community Helper', 'Helped other users 30 times',      CURRENT_DATE, 'PLATINUM', 4),
    ('Koos Hall of Fame',     'Lifetime achievement recognition', CURRENT_DATE, 'DIAMOND',  4);


INSERT INTO collections (name, address, number) VALUES
    ('Koos Water Samples',        '101 Sample St, Testville',          101),
    ('Koos River Collection',      '202 River Rd, Flowtown',            202),
    ('Koos Lake Survey',           '303 Lakeview Dr, Watertown',        303),
    ('Koos Coastal Analysis',      '404 Ocean Ave, Shore City',         404),
    ('Koos Well Monitoring',       '505 Well Rd, Depthsville',          505);
