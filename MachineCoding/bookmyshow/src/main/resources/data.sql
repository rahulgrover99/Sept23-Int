
DELETE FROM show_seat;
DELETE FROM movie_show;
DELETE FROM movies;
DELETE FROM screen_seats;
DELETE FROM seat;
DELETE FROM screen;
DELETE FROM theatre;
DELETE FROM region;

ALTER TABLE show_seat AUTO_INCREMENT=1;
ALTER TABLE movie_show AUTO_INCREMENT=1;
ALTER TABLE movies AUTO_INCREMENT=1;
ALTER TABLE screen_seats AUTO_INCREMENT=1;
ALTER TABLE seat AUTO_INCREMENT=1;
ALTER TABLE screen AUTO_INCREMENT=1;
ALTER TABLE theatre AUTO_INCREMENT=1;
ALTER TABLE region AUTO_INCREMENT=1;

INSERT INTO region (latitude, longitude, name) VALUES
(1.1, 2.1, 'Delhi'), (3.1, 2.5, 'Mumbai');

INSERT INTO theatre (address, name, region_id) VALUES
('3, Bangla road', 'PVR', 1), ('4, MG road', 'MBD', 2);

INSERT INTO screen (name, theatre_id) VALUES
('Screen 1', 1), ('Screen 2', 1), ('Screen 1', 2);

INSERT INTO seat (col_num, row_num, seat_type, seat_number) VALUES
(1, 'A', 1, 12), (1, 'C', 2, 19), (3, 'D', 2, 20);

INSERT INTO screen_seats (screen_id, seats_id) VALUES
(1, 1), (1, 2), (2, 3);

INSERT INTO movies (duration, rating, category, language, name) VALUES
                                                                    (180, 4.0, 'DRAMA', 'HINDI', 'kal ho na ho'),
                                                                    (200, 5.0, 'ACTION', 'TELEGU', 'baahubali');

INSERT INTO movie_show (end_time, movie_id, screen_id, start_time) VALUES
                                                                       ('2020-09-11', 1, 1, '2020-08-10'),
                                                                       ('2020-09-11', 2, 1, '2020-08-11'),
                                                                       ('2020-09-11', 1, 2, '2020-08-11');

INSERT INTO show_seat (price, show_seat_status, seat_id, show_id) VALUES
                                                                      (100, 1, 1, 1), (120, 1, 2, 1), (140, 1, 3, 1);

