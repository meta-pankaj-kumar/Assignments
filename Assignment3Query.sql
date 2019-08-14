/*
Display Recent 50 Orders placed (Id, Order Date, Order Total)
*/
SELECT orders.OrderId AS "Order Id", orders.OrderDate AS "Order Date", orders.OrderTotal AS "Order Total" FROM orders ORDER BY orders.OrderId DESC LIMIT 50;
/*
Display 10 most expensive Orders
*/
SELECT orders.OrderId AS "Order Id", orders.OrderDate AS "Order Date", orders.OrderTotal AS "Order Total" FROM orders ORDER BY orders.OrderTotal DESC LIMIT 10;
/*
/*
Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped
*/
SELECT orders.OrderId AS "Order Id",orders.ShopperId As "Shopper Id", orders.OrderDate as "Order Date" FROM orders where orders.OrderDate < DATE_SUB(NOW(), INTERVAL 10 DAY) AND orders.OrderId IN (select orderstatus.OrderId from orderstatus where orderstatus.Status = "Not Shipped");

/*
Display list of shoppers which haven't ordered anything since last month
*/
SELECT shopper.ShopperId AS "User Id", user.Name AS "Shopper Name", user.Email AS "Shopper Email",user.Phone AS "Shopper Phone" from shopper,user where shopper.ShopperId = user.UserId AND shopper.ShopperId NOT IN(SELECT DISTINCT orders.ShopperId from orders where MONTH(orders.OrderDate) >= (MONTH(NOW())-1) AND YEAR(orders.OrderDate) = YEAR(NOW()));

/*
Display list of shopper along with orders placed by them in last 15 days
*/
SELECT shopper.ShopperId AS "Shopper Id",user.Name AS "Shopper Name", user.Email AS "Shopper Email",orders.OrderId AS "Order Id",orders.OrderDate AS "Order Date", orders.OrderTotal AS "Order Total" from user,shopper RIGHT JOIN orders ON shopper.ShopperId = orders.ShopperId where shopper.ShopperId = user.UserId AND shopper.ShopperId IN(SELECT DISTINCT orders.ShopperId FROM orders WHERE orders.OrderDate > DATE_SUB(NOW(), INTERVAL 15 DAY));
/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/
SELECT product.ProductId AS "Product Id",product.ProductName AS "Product Name" FROM product WHERE product.ProductId IN(SELECT orderstatus.ProductId from orderstatus where orderstatus.OrderId = "3" AND orderstatus.Status ="Shipped");
/*
Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price
*/
SELECT product.ProductId AS "Product Id",product.ProductName As "Product Name",orders.OrderDate AS "Order Date", product.Price FROM product, orders WHERE product.Price BETWEEN 14000 AND 15000 AND (product.ProductId, orders.OrderId) IN (SELECT ProductId, OrderId FROM orderstatus);