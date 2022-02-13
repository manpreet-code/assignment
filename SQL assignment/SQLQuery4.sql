USE AdventureWorks2008R2;
GO
CREATE FUNCTION dbo.ufnGetSalesOrderDetails(@SalesOrderID int, @CurrencyCode nvarchar(50),@date datetime)
RETURNS TABLE 
AS
RETURN (SELECT      
               SOD.OrderQty,
			   SOD.ProductID,
			   SOD.UnitPrice,
			   SOD.UnitPrice * 
			   (SELECT CR.EndOfDayRate
                           FROM
                              sales.CurrencyRate CR 
                           WHERE 
                                 CR.ToCurrencyCode = @CurrencyCode
                           AND
                                 CR.CurrencyRateDate = @date
                           ) AS 'Target Currency Price'
             FROM 
                    Sales.SalesOrderDetail SOD
             WHERE
                    SOD.SalesOrderID = @SalesOrderID
 );
GO