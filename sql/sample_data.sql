/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  windows 10
 * Created: Jul 19, 2025
 */
-- Insert cities
INSERT INTO cities (city_name, state, country) VALUES ('Delhi', 'Delhi', 'India');
INSERT INTO cities (city_name, state, country) VALUES ('Agra', 'Uttar Pradesh', 'India');
INSERT INTO cities (city_name, state, country) VALUES ('Jaipur', 'Rajasthan', 'India');
INSERT INTO cities (city_name, state, country) VALUES ('Mumbai', 'Maharashtra', 'India');
INSERT INTO cities (city_name, state, country) VALUES ('Kolkata', 'West Bengal', 'India');
INSERT INTO cities (city_name, state, country) VALUES ('Hyderabad', 'Telangana', 'India');

-- Insert place tags
INSERT INTO place_tags (tag_name) VALUES ('Historical');
INSERT INTO place_tags (tag_name) VALUES ('Religious');
INSERT INTO place_tags (tag_name) VALUES ('Nature');
INSERT INTO place_tags (tag_name) VALUES ('Architecture');
INSERT INTO place_tags (tag_name) VALUES ('Museum');

-- Insert places for Delhi
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Red Fort', 1, 2, 50, '17th-century historical fort in Delhi');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Lotus Temple', 1, 1.5, 0, 'Baha''i House of Worship');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('India Gate', 1, 1, 0, 'War memorial arch');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Qutub Minar', 1, 2, 35, 'Tallest brick minaret in the world');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Akshardham Temple', 1, 2, 0, 'Grand Hindu temple complex');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('National Museum', 1, 1.5, 20, 'One of the largest museums in India');

-- Insert places for Agra
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Taj Mahal', 2, 2, 50, 'White marble mausoleum');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Agra Fort', 2, 1.5, 40, 'Historic Mughal fort');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Mehtab Bagh', 2, 1.5, 20, 'Garden across the Yamuna River');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Itmad-ud-Daulah', 2, 1, 25, 'Baby Taj');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Jama Masjid Agra', 2, 1, 0, '17th-century mosque');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Tomb of Akbar the Great', 2, 2, 30, 'Emperor Akbar''s tomb complex');

-- Insert places for Jaipur
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Amber Fort', 3, 2, 50, 'Hilltop fort');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Hawa Mahal', 3, 1, 30, 'Palace of Winds');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('City Palace', 3, 2, 40, 'Royal residence');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Jantar Mantar', 3, 1.5, 20, 'Astronomical observatory');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Albert Hall Museum', 3, 1.5, 30, 'Oldest museum in Rajasthan');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Nahargarh Fort', 3, 2, 20, 'Scenic hill fort');

-- Insert places for Mumbai
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Gateway of India', 4, 1, 0, 'Iconic arch-monument');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Elephanta Caves', 4, 2, 40, 'Rock-cut cave temples');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Chhatrapati Shivaji Maharaj Museum', 4, 1.5, 30, 'Formerly Prince of Wales Museum');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Haji Ali Dargah', 4, 1, 0, 'Mosque on a tiny islet');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Marine Drive', 4, 1, 0, 'Scenic coastal road');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Sanjay Gandhi National Park', 4, 2, 20, 'Nature reserve in the city');

-- Insert places for Kolkata
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Victoria Memorial', 5, 2, 30, 'British-era white marble building');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Dakshineswar Temple', 5, 1.5, 0, 'Temple dedicated to Goddess Kali');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Indian Museum', 5, 2, 25, 'Largest museum in India');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Howrah Bridge', 5, 1, 0, 'Cantilever bridge over Hooghly River');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Belur Math', 5, 1.5, 0, 'Spiritual center on the banks of Ganges');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Science City', 5, 2, 30, 'Science and technology museum');

-- Insert places for Hyderabad
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Charminar', 6, 1.5, 20, 'Iconic 16th-century mosque');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Golconda Fort', 6, 2, 40, 'Ruins of ancient fort');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Hussain Sagar Lake', 6, 1.5, 0, 'Man-made lake with Buddha statue');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Salar Jung Museum', 6, 2, 30, 'One of the largest art museums in India');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Birla Mandir', 6, 1, 0, 'Marble Hindu temple');
INSERT INTO places (name, city_id, visit_duration, entry_fee, description) VALUES ('Chowmahalla Palace', 6, 2, 50, 'Nizam-era royal palace');

-- Insert place-tag mappings
INSERT INTO place_tag_map VALUES (1, 1);
INSERT INTO place_tag_map VALUES (1, 4);
INSERT INTO place_tag_map VALUES (2, 2);
INSERT INTO place_tag_map VALUES (2, 4);
INSERT INTO place_tag_map VALUES (3, 1);
INSERT INTO place_tag_map VALUES (4, 1);
INSERT INTO place_tag_map VALUES (4, 4);
INSERT INTO place_tag_map VALUES (5, 2);
INSERT INTO place_tag_map VALUES (5, 4);
INSERT INTO place_tag_map VALUES (6, 5);
INSERT INTO place_tag_map VALUES (7, 1);
INSERT INTO place_tag_map VALUES (7, 4);
INSERT INTO place_tag_map VALUES (8, 1);
INSERT INTO place_tag_map VALUES (8, 4);
INSERT INTO place_tag_map VALUES (9, 3);
INSERT INTO place_tag_map VALUES (10, 1);
INSERT INTO place_tag_map VALUES (10, 4);
INSERT INTO place_tag_map VALUES (11, 2);
INSERT INTO place_tag_map VALUES (12, 1);
INSERT INTO place_tag_map VALUES (12, 4);
INSERT INTO place_tag_map VALUES (13, 1);
INSERT INTO place_tag_map VALUES (13, 4);
INSERT INTO place_tag_map VALUES (14, 1);
INSERT INTO place_tag_map VALUES (14, 4);
INSERT INTO place_tag_map VALUES (15, 1);
INSERT INTO place_tag_map VALUES (15, 4);
INSERT INTO place_tag_map VALUES (16, 1);
INSERT INTO place_tag_map VALUES (17, 5);
INSERT INTO place_tag_map VALUES (18, 1);
INSERT INTO place_tag_map VALUES (19, 1);
INSERT INTO place_tag_map VALUES (19, 4);
INSERT INTO place_tag_map VALUES (20, 1);
INSERT INTO place_tag_map VALUES (20, 2);
INSERT INTO place_tag_map VALUES (20, 4);
INSERT INTO place_tag_map VALUES (21, 5);
INSERT INTO place_tag_map VALUES (22, 2);
INSERT INTO place_tag_map VALUES (23, 3);
INSERT INTO place_tag_map VALUES (24, 3);
INSERT INTO place_tag_map VALUES (25, 1);
INSERT INTO place_tag_map VALUES (25, 5);
INSERT INTO place_tag_map VALUES (25, 4);
INSERT INTO place_tag_map VALUES (26, 2);
INSERT INTO place_tag_map VALUES (27, 5);
INSERT INTO place_tag_map VALUES (28, 1);
INSERT INTO place_tag_map VALUES (29, 2);
INSERT INTO place_tag_map VALUES (30, 5);
INSERT INTO place_tag_map VALUES (31, 1);
INSERT INTO place_tag_map VALUES (31, 2);
INSERT INTO place_tag_map VALUES (31, 4);
INSERT INTO place_tag_map VALUES (32, 1);
INSERT INTO place_tag_map VALUES (32, 4);
INSERT INTO place_tag_map VALUES (33, 3);
INSERT INTO place_tag_map VALUES (34, 5);
INSERT INTO place_tag_map VALUES (35, 2);
INSERT INTO place_tag_map VALUES (36, 1);
INSERT INTO place_tag_map VALUES (36, 4);

