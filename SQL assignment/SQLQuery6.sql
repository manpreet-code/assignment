USE AdventureWorks2008R2
GO
CREATE TRIGGER PRODUCTION.tr_ListPrice_Update
ON Production.Product
AFTER UPDATE
AS
BEGIN
	IF UPDATE(ListPrice)
		BEGIN
			DECLARE @oldval int
			DECLARE @newval int
			DECLARE @PID int

			SELECT @PID=ProductID 
			FROM inserted;

			SELECT @oldval = ListPrice 
			FROM deleted 
			WHERE ProductID = @PID;

			SELECT @newval = ListPrice 
			FROM inserted 
			WHERE ProductID = @PID;
			
			IF @newval - @oldval > 0.15*@oldval
			BEGIN
				PRINT('Can not be Modified')
				ROLLBACK
			END
		END
END
GO

--DROP TRIGGER PRODUCTION.tr_ListPrice_Update

/*
UPDATE Production.Product
SET ListPrice = 60
WHERE ProductID = 711
*/