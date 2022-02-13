-- using join
SELECT 
      C.CustomerID
FROM 
     [Sales].[Customer] C 
	 LEFT JOIN [Sales].[SalesOrderHeader] O
     ON C.CustomerID=O.CustomerID
WHERE 
     O.AccountNumber IS NULL
ORDER BY C.CustomerID

--using subquery

SELECT 
      C.CustomerID
FROM 
      [Sales].[Customer] C
where 
      c.CustomerID not in
      (SELECT
	         O.CustomerID
       FROM 
	        [Sales].[SalesOrderHeader] O)

--using CTE

WITH s AS
(   SELECT 
          CustomerID
    FROM 
	     Sales.SalesOrderHeader
)
SELECT 
       c.CustomerID
FROM 
      Sales.Customer c
      LEFT OUTER JOIN Sales.SalesOrderHeader s 
      ON c.CustomerID = s.CustomerID
WHERE 
      s.SalesOrderID IS NULL;

--using Exists

SELECT 
      c.CustomerID
FROM 
      Sales.Customer c
WHERE NOT EXISTS
     (SELECT 
	        * 
	  FROM 
	       [Sales].[SalesOrderHeader] soh 
	  WHERE 
	       c.CustomerID=soh.CustomerID )