DROP TABLE IF EXISTS Fruit;
CREATE TABLE Fruit
(
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO Fruit (id, name, description) VALUES (0, 'Orange', 'Winter fruit');
INSERT INTO Fruit (id, name, description) VALUES (1, 'Mango', 'Tropical fruit');