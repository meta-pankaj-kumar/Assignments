package storefront;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Pankaj
 */
public class ConnectToMySQL {
	/**
	 * @param connect
	 * @return Connection variable
	 */
	public Connection ConnectToSQL(Connection connect){
		try	    {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront","root","1234");
	        System.out.println("Remote DB connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    catch (ClassNotFoundException e)	    {
	        e.printStackTrace();
	        System.out.println("Remote server could not be connected");
	    }
	    catch (NullPointerException e)	    {
	        e.printStackTrace();
	        System.out.println("Remote server could not be connected");
	    }
		return connect;
	}
}