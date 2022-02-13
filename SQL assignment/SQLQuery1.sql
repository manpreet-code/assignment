--Question 1
SELECT 
      COUNT(*) AS 'number of records '
FROM 
    Sales.SalesPerson; 

--Question 2

SELECT 
       p.FirstName
      ,p.LastName
FROM
      Person.Person p
where 
      p.FirstName like 'B%';

--Question 3

SELECT 
       p.FirstName
      ,p.LastName
FROM  
       Person.Person p
     INNER JOIN HumanResources.Employee H ON H.BusinessEntityID=P.BusinessEntityID
	 WHERE 
	      H.JobTitle ='Design Engineer' 
		  OR H.JobTitle = 'Tool Designer'
		  OR H.JobTitle ='Marketing Assistant';

--Question 4

SELECT 
       Name
      ,Color
FROM 
      Production.Product 
WHERE Weight= 
             (SELECT 
			        Max(Weight) 
			  FROM 
			        Production.Product);

--Question 5

SELECT 
      Description,  
	  ISNULL(MaxQty, 0.00) AS 'Max Quantity'  

FROM 
     Sales.SpecialOffer; 

--Question 6

SELECT 
       AVG(AverageRate) AS 'Average exchange rate for the day'
FROM 
     Sales.CurrencyRate
WHERE 
      ToCurrencyCode = 'GBP' 
      AND DATEPART(year,CurrencyRateDate) = '2005';

--Question 7

SELECT 
       p.FirstName
      ,p.LastName
	  ,ROW_NUMBER() OVER(ORDER BY p.FirstName) AS 'sequential numbers'
FROM 
      Person.Person p
where 
      p.FirstName like '%ss%';

--Question 8

SELECT 
        [BusinessEntityID] 
       ,IIF([CommissionPct]=0,'Band 0'
	   ,IIF(CommissionPct <=0.01,'Band 1'
	   ,IIF(CommissionPct<=0.015,'Band 2'
	   ,IIF(CommissionPct>0.015,'Band 3',NULL))))
FROM
      [Sales].[SalesPerson];

--Question 9
DECLARE @id INT
SELECT 
      @id = BusinessEntityID 
FROM 
     Person.Person
WHERE 
     FirstName = 'Ruth' 
	 AND LastName = 'Ellerbrock' 
	 AND PersonType = 'EM'
EXEC 
    dbo.uspGetEmployeeManagers @id;

--Question 10
SELECT 
      ProductID
FROM 
      Production.Product
WHERE 
      dbo.ufnGetStock(ProductID)=
	  (SELECT
	          MAX(dbo.ufnGetStock(ProductID)) 
		FROM 
		     Production.ProductInventory);