
CREATE TABLE product (
			Productid int NOT NULL AUTO_INCREMENT,
  
			Productname varchar(50) NOT NULL,

			Price double NOT NULL,
			Description varchar(1000) NOT NULL,  
			Stock int NOT NULL DEFAULT 0,
  
			PRIMARY KEY (Productid)

			);
show tables;