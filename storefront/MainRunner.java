package storefront;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 * @author Pankaj
 */
public class MainRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		queryDriver driver = new queryDriver();
		ResultSet result;
		while(true){
			try{
				System.out.println("Enter 1  to fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state");
				System.out.println("Enter 2  to Insert five or more images of a product using batch insert technique");
				System.out.println("Enter 3  to Delete all those products which were not ordered by any Shopper in last 1 year and get number of products deleted");
				System.out.println("Enter 4  to display the category title of all top parent categories sorted alphabetically and the count of their child categories");
				System.out.println("Enter 5 for closing the connection and Exitting main Runner");
				int input=Integer.parseInt(in.readLine());
				switch(input){
					case 1: 
						String querry = "SELECT user.userId as Id , user.Name As Name , user.Email As Email , user.Phone As Phone "
								+ "FROM User "
								+ "WHERE user.usertype = 'Shopper' ;";
						result = driver.executeNewQuerry(querry);
						while(result.next()){
							System.out.println(result.getInt("Id") +"\t"+result.getString("Name") +"\t\t"+result.getString("Email")+"\t\t"+result.getString("Phone"));
						}
						result.beforeFirst();
						System.out.println("Enter Id of User");
						int userId=Integer.parseInt(in.readLine());
						boolean flag=false;
						while(result.next()){
							if(result.getInt("Id") == userId){
								flag=true;
							}
						}
						if(!flag){
							throw new Exception("Wrong Id Entered");
						}
						result = driver.executeFirstQuerry(userId);
						printResult(result);
						break;
					case 2:
						String querrySecond = "SELECT product.productId AS Id , product.productName As 'Product Name' "
								+ "FROM Product;";
						result = driver.executeNewQuerry(querrySecond);
						while(result.next()){
							System.out.println(result.getInt("Id") +"\t"+result.getString("Product Name"));
						}
						System.out.println("Enter Id of Product to add its image");
						int productId=Integer.parseInt(in.readLine());
						result.beforeFirst();
						flag = false;
						while(result.next()){
							if(result.getInt("Id") == productId){
								flag=true;
							}
						}
						if(!flag){
							throw new Exception("Wrong Id Entered");
						}
						System.out.println("Enter number of images product is having");
						int numberOfImages = Integer.parseInt(in.readLine());
						String urlArray[] = new String[numberOfImages];
						for(int index=0;index <numberOfImages;index++){
							System.out.println("Enter url of image");
							urlArray[index]=in.readLine();
						}
						if(driver.executeSecondQuerry(urlArray,productId))
						System.out.println("Images Inserted");
						break;
					case 3:
						System.out.println(driver.executeThirdQuerry()-2+" Rows Affected");
						break;
					case 4:
						result = driver.executeFourthQuerry();
						printResult(result);
						break;
						
					case 5:
						driver.connect.close();
						System.out.println("Connection Closed");
						System.out.println("Exitiing Main Runner");
						System.exit(0);
						break;
					default:
						System.out.println("Wrong Choice");
				}
			}
			catch(SQLException e){
				System.out.println(e);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	/**
	 * @param results of resultSet Type
	 * @throws SQLException if caught
	 */
	public static void printResult(ResultSet results) throws SQLException{
		try {
			ResultSetMetaData rsmd = results.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (results.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1){
						System.out.print(",  ");
					}
					String columnValue = results.getString(i);
					System.out.print(rsmd.getColumnName(i) + " " + columnValue );
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}
