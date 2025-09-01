# Write your MySQL query statement below
SELECT MAX(Salary) AS SecondHighestsalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee)