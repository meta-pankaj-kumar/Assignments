package storefront;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Pankaj
 */
public class queryDriver {
	private PreparedStatement statement;
	private ConnectToMySQL connector;
	public Connection connect;
	private SQLQuerries querry;
	private ResultSet result;
	/**
	 * 
	 */
	public AssignmentOfSession5 () {
      try
        {
    	    this.connector = new ConnectToMySQL();
    	    this.connect = this.connector.ConnectToSQL(connect);
    	    //this.connect.setAutoCommit(false);
    	    this.querry = new SQLQuerries();
        }
      catch(Exception e)
      {
          e.printStackTrace();
          System.out.println(e.getMessage().toString());
      }
	}
	/**
	 * @param shopperId
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet executeFirstQuerry(int shopperId) throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement(this.querry.getFirstQuerry());
			this.statement.setInt(1,shopperId);
			this.result = statement.executeQuery();
		}catch(SQLException e) {
			throw e;
		}catch (Exception e) {
			throw e;
		}
        return this.result;
	}
	/**
	 * @param urlArray
	 * @param productId
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean executeSecondQuerry(String []urlArray , int productId) throws SQLException , Exception {
		try{
		 	for(int index=0;index<urlArray.length;index++){
		 		this.statement = this.connect.prepareStatement(this.querry.getSecondQuerry());
		 		this.statement.setInt(1,productId);
		 		this.statement.setString(2,urlArray[index]);
		 		this.statement.addBatch();
		 	}
		 	statement.executeBatch();
		 	return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	/**
	 * @return number of rows affected
	 * @throws SQLException
	 * @throws Exception
	 */
	public int executeThirdQuerry() throws SQLException , Exception{
		try {
		this.statement = this.connect.prepareStatement("SET SQL_SAFE_UPDATES = 0;");
	        return this.statement.executeUpdate(this.querry.getThirdQuerry())-2;
		} 
		catch (SQLException e) {
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	/**
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet executeFourthQuerry() throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement(this.querry.getFourthQuerry());
	        this.result = statement.executeQuery();
	        return this.result;
		} 
		catch (SQLException e) {
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	/**
	 * @param newQuerry
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet executeNewQuerry(String newQuerry) throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement(newQuerry);
	        this.result = statement.executeQuery();
	        return this.result;
		} 
		catch (SQLException e) {
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
}
