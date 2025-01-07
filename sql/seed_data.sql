INSERT INTO customers (id, name, email) VALUES
(1, 'Abe', 'abe@example.com'),
(2, 'Bob', 'bob@example.com');

INSERT INTO orders (id, customer_id, order_date, amount) VALUES
(1, 1, '2023-01-01', 100.50),
(2, 2, '2023-01-02', 200.75);
