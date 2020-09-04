CREATE TYPE buyer AS (first_name varchar(50), last_name varchar(50));
CREATE TYPE product AS (name varchar(50), price double precision);
CREATE TABLE purchases (buyer buyer, product product, date date);

INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Минеральная вода', 15.0), '2020-09-02');
INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Сок', 15.0), '2020-01-15');
INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Сок', 15.0), '2020-01-15'), (ROW('Иван', 'Иванов'), ('Минеральная вода', 15.0), '2020-01-30');
INSERT INTO purchases VALUES (ROW('Иван', 'Москаль'), ('Сок', 15.0), '2020-01-15'), (ROW('Даша', 'Иванова'), ('Минеральная вода', 15.0), '2020-01-30');
INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Минеральная вода', 15.0), '2020-05-02');
INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Минеральная вода', 15.0), '2020-01-016');
INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Чай', 200.0), '2020-01-016');
INSERT INTO purchases VALUES (ROW('Иван', 'Иванов'), ('Лимонад', 5.0), '2020-01-016');
