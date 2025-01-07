DELETE FROM Salesperson
WHERE id IN (SELECT DISTINCT o.salesperson_id FROM Orders o JOIN Customer c ON o.customer_id = c.id WHERE c.city = 'Jackson');
