
CREATE TABLE Orders (
  
			orderid int NOT NULL AUTO_INCREMENT,
  
			shopperid int NOT NULL,
  
			shippingaddress VARCHAR(255) NOT NULL,

			
			  
			PRIMARY KEY (orderid),
			FOREIGN KEY (shopperid) REFERENCES shopper (ShopperId),
			FOREIGN KEY (shippingaddress) REFERENCES address(ShopperId,addressId) 
			
			

			);
