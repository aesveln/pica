CREATE VIEW sales_orders_items
 AS (SELECT so.ID_SALES as idSale, so.ORDER_DATE as orderDate, so.PRICE as priceSales, so.STATUS_ORDER as statusOrder ,so.COMMENTS as commentsSale,
  so.CUSTOMER_ID as customerId, oi.ORDER_ID as orderId, oi.PRODUCT_COD as productCode, oi.PRODUCT_NAME as productName, oi.PRICE as priceOrderItem, oi.QUANTITY as quantityOrderItem
 from SALES_ORDER so inner join ORDER_ITEM oi on so.ID_SALES = oi.ORDER_ID);


 with idSale as (select idSale from sales_orders_items where productCode = '771800018'),
 productos as (select * from (select productCode, count(productCode) as totalProduct
               from sales_orders_items inner join idSale on idSale.idSale = orderId
               where productCode != 771800018
               group by productCode
               order by totalProduct desc)
where ROWNUM <= 5)
select *
from productos
;