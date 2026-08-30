# Write your MySQL query statement below
SELECT e.name as Employee FROM Employee e Inner Join Employee m 
ON e.managerID = m.id
Where e.salary >m.salary;