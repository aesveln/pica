
USE [TouresProductos];


CREATE LOGIN touresUser   
    WITH PASSWORD = 'touresUser.*';

    
CREATE USER touresUser FOR LOGIN touresUser;

exec sp_addrolemember 'db_owner', 'touresUser'


USE TouresProductos;  
GRANT CONTROL ON DATABASE::TouresProductos TO touresUser;  
GO 
