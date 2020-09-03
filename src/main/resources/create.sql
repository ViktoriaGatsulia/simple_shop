CREATE TABLE buyer (
    id SERIAL PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL
    );

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name varchar(50) NOT NULL,
    prise double precision NOT NULL
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

INSERT INTO product (name, prise) VALUES ('Сок', 15.0);
INSERT INTO product (name, prise) VALUES ('Чай', 200.0);
INSERT INTO product (name, prise) VALUES ('Лимонад', 5.0);
INSERT INTO product (name, prise) VALUES ('Миниральная вода', 10.0);

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

// Поиск по фамилии
SELECT first_name, last_name FROM buyer WHERE (last_name) LIKE 'Иванов';

// Статистика за период
SELECT buyer.first_name, buyer.last_name, purchases.date
    FROM buyer
    JOIN purchases
    ON buyer.id = purchases.buyer_id
    WHERE purchases.date BETWEEN to_date('2020-01-14', 'yyyy-mm-dd') AND to_date('2020-01-26', 'yyyy-mm-dd');

SELECT emp_name, dept_name FROM Employee e
    JOIN Register r ON e.emp_id=r.emp_id
    JOIN Department d ON r.dept_id=d.dept_id;
