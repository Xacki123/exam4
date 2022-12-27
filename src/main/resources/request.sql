// запрос 1
CREATE TABLE table_mountaineer
(
    id_mountaineer INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(100),
    age INTEGER
);

// запрос 2
INSERT INTO table_mountaineer (name, address, age) VALUES ('name', 'address', 'age');

// запрос 3
UPDATE table_mountaineer SET name = 'new_name' WHERE name = 'old_name';

// запрос 4
SELECT id_mountaineer, name FROM table_mountaineer WHERE age BETWEEN 30 AND 50;

// запрос 5
SELECT name FROM table_mountain WHERE height>555555;

// запрос 6
SELECT country FROM table_mountain WHERE name LIKE 'name_mountain'

// запрос 7
SELECT idGroup FROM table_group WHERE dateTime < CURRENT_DATE+CURRENT_TIME;

// запрос 8
SELECT table_group.idGroup FROM table_group, table_mountain  WHERE table_mountain.name LIKE 'name_mountain'

// запрос 9
SELECT table_mountaineer.idMountaineer, table_mountaineer.name FROM table_mountaineer, table_mountain, table_group WHERE (не додумался, очень сложно)

