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


SELECT b.id AS id_user, b.first_name, b.last_name, SUM(pr.price) AS sum_for_product, pr.id AS id_product, pr.name
FROM buyer b
JOIN purchases pur ON b.id = pur.buyer_id
JOIN product pr ON pr.id = pur.product_id
WHERE pur.date BETWEEN to_date('2020-01-14', 'yyyy-mm-dd') AND to_date('2020-01-26', 'yyyy-mm-dd')
GROUP BY b.id, pr.id;


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

-- Вывод общей информации о пользователях и об их покупках
SELECT pur.id, b.first_name, b.last_name, pr.name, pr.price, pur.date
FROM buyer b
JOIN purchases pur ON b.id = pur.buyer_id
JOIN product pr ON pr.id = pur.product_id;
