DROP TABLE IF EXISTS fruits;
CREATE TABLE fruits
(
    id BIGINT PRIMARY KEY,
    name VARCHAR (255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO fruits (id, name, description) VALUES (0, 'Orange', 'Winter fruit');
INSERT INTO fruits (id, name, description) VALUES (1, 'Mango', 'Tropical fruit');