USE AdventureWorks2008R2
GO
CREATE PROCEDURE dbo.usp_GetNameDetails @FirstNameFilter nvarchar(20)
AS
SELECT 
          FirstName,
          MiddleName,
          LastName
FROM Person.Person 
WHERE FirstName LIKE '%' + @FirstNameFilter + '%'; 
GO
--DROP PROCEDURE dbo.uspGetNameDetails
EXEC dbo.usp_GetNameDetails 'ss';
GO
ALTER PROCEDURE dbo.usp_GetNameDetails @FirstNameFilter nvarchar(20) = 'Ruth'
AS
SELECT    FirstName, 
          MiddleName, 
          LastName
FROM Person.Person 
WHERE FirstName LIKE '%' + @FirstNameFilter + '%'; 
GO
EXEC dbo.usp_GetNameDetails 'ab'
