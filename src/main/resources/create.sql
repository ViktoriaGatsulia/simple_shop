CREATE TABLE buyer (
    id SERIAL PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL
    );

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name varchar(50) NOT NULL,
    price double precision NOT NULL
    );

CREATE TABLE purchases (
    id SERIAL PRIMARY KEY,
    buyer_id INTEGER,
    product_id INTEGER,
    FOREIGN KEY (buyer_id) REFERENCES buyer (id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    date date
    );

INSERT INTO buyer (first_name, last_name) VALUES ('Иван', 'Иванов');
INSERT INTO buyer (first_name, last_name) VALUES ('Иван', 'Москаль');
INSERT INTO buyer (first_name, last_name) VALUES ('Даша', 'Иванова');
INSERT INTO buyer (first_name, last_name) VALUES ('Александр', 'Иванов');

INSERT INTO product (name, price) VALUES ('Сок', 15.0);
INSERT INTO product (name, price) VALUES ('Чай', 200.0);
INSERT INTO product (name, price) VALUES ('Лимонад', 5.0);
INSERT INTO product (name, price) VALUES ('Миниральная вода', 10.0);

INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 4, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 4, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 4, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 4, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 4, '2020-01-16');

INSERT INTO purchases (buyer_id, product_id, date) VALUES (1, 4, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (1, 4, '2020-01-16');

INSERT INTO purchases (buyer_id, product_id, date) VALUES (1, 1, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (1, 2, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (1, 3, '2020-01-16');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (2, 1, '2020-01-01');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (2, 2, '2020-01-01');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (2, 3, '2020-01-01');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 1, '2020-01-30');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 2, '2020-01-30');
INSERT INTO purchases (buyer_id, product_id, date) VALUES (3, 3, '2020-01-30');
