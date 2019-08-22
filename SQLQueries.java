package storefront;
/**
 * @author Pankaj
 */
public class SQLQueries {
	private String query;
	public SQLQueries(){
		this.query="";
	}
	public String getQuery() {
		return this.query;
	}
	/**
	 * @return String type querry
	 */
	public String getFirstQuery(){
		this.query=" SELECT orders.OrderId AS 'Id',orders.OrderDate AS 'Order Date',SUM(orderedproducts.Quantity*product.Price) AS 'Order Total' "
				+ "FROM shopper INNER JOIN orders ON shopper.shopperId = orders.ShopperId  "
				+ "INNER JOIN orderedproducts ON orders.OrderId = orderedproducts.OrderId "
				+ "INNER JOIN orderstatus ON orderedproducts.OrderId = orderstatus.OrderId AND orderedproducts.ProductId = orderstatus.ProductId "
				+ "INNER JOIN product ON orderstatus.ProductId = product.ProductId "
				+ "WHERE shopper.ShopperId = ? AND orderstatus.Status = 'Shipped' "
				+ "GROUP BY orders.OrderId;";
		return this.query;		
	}	
	/**
	 * @return String type querry
	 */
	public String getSecondQuery(){
			this.query="INSERT INTO images (productId,url) VALUES(?,?);";
		return this.query;	
	}
	/**
	 * @return String type querry
	 */
	public String getThirdQuery(){
		this.query= "update "
				+ "Product left join orderstatus on product.productId = orderstatus.productId "
				+ "left join orders on orderstatus.orderid = orders.orderId	"
				+ "SET product.status = 'Inactive' "
				+ "where product.status = 'Active' and orderdate is null || orderdate < DATE_SUB(NOW(),INTERVAL 365 DAY);";
		return this.query;	
	}
	/**
	 * @return String type querry
	 */
	public String getFourthQuery(){
		this.query= "SELECT c.CategoryName, Count(c1.CategoryId) AS count_Of_Child "
				+ "FROM category c LEFT JOIN category c1 ON c.categoryId = c1.ParentcategoryId "
				+ "WHERE c.ParentcategoryId = 0 GROUP BY c.categoryName "
				+ "ORDER BY c.CategoryName;";
		return this.query;	
	}
}