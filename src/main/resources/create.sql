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

-- Поиск по фамилии
SELECT first_name, last_name FROM buyer WHERE (last_name) LIKE 'Иванов';

-- Статистика за период
--SELECT buyer.first_name, buyer.last_name, purchases.date
--FROM buyer
--JOIN purchases
--ON buyer.id = purchases.buyer_id
--WHERE purchases.date BETWEEN to_date('2020-01-14', 'yyyy-mm-dd') AND to_date('2020-01-26', 'yyyy-mm-dd');

-- Статистика за период
SELECT b.first_name, b.last_name, pr.name, pr.price , pur.date
FROM buyer b
JOIN purchases pur ON b.id = pur.buyer_id
JOIN product pr ON pr.id = pur.product_id
WHERE pur.date BETWEEN to_date('2020-01-14', 'yyyy-mm-dd') AND to_date('2020-01-26', 'yyyy-mm-dd');

-- Поиск покупателей, у которых общая стоимость всех покупок
-- попадает в интервал
SELECT b.id, b.first_name, b.last_name,
SUM(pr.price) AS total_sum
FROM buyer b
JOIN purchases pur ON b.id = pur.buyer_id
JOIN product pr ON pr.id = pur.product_id
GROUP BY b.id
HAVING SUM(pr.price) BETWEEN 10 AND 250;

-- Поиск покупателей, купивших меньше всего товаров.
-- Возвращается не более, чем указанное число покупателей.
SELECT b.id, b.first_name, b.last_name,
SUM(pr.price) AS total_sum
FROM buyer b
JOIN purchases pur ON b.id = pur.buyer_id
JOIN product pr ON pr.id = pur.product_id
GROUP BY b.id
ORDER BY total_sum ASC
LIMIT 2;

-- Поиск покупателей, купивших этот товар не менее,
-- чем указанное число раз.
SELECT b.first_name, b.last_name, COUNT(pr.name) AS count_purchases
FROM buyer b
JOIN purchases pur ON b.id = pur.buyer_id
JOIN product pr ON pr.id = pur.product_id
WHERE (pr.name) LIKE 'Миниральная вода'
GROUP BY b.id
HAVING COUNT(pr.name) >= 5;
