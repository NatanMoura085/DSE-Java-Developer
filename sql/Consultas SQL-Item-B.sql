UPDATE Salesperson
SET name = CONCAT(name, '*')
WHERE id IN (SELECT salesperson_id FROM Orders GROUP BY salesperson_id HAVING COUNT(*) >= 2);
