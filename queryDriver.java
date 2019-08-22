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
	private SQLQueries query;
	private ResultSet result;
	/**
	 * 
	 */
	public queryDriver () {
      try
        {
    	    this.connector = new ConnectToMySQL();
    	    this.connect = this.connector.ConnectToSQL(connect);
    	    //this.connect.setAutoCommit(false);
    	    this.query = new SQLQueries();
        }
      catch(Exception e)
      {
          e.printStackTrace();
          System.out.println(e.getMessage().toString());
      }
	}
	
	public ResultSet getResult() {
		return this.result;
	}

	/**
	 * @param shopperId
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public void executeFirstQuery(int shopperId) throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement(this.query.getFirstQuery());
			this.statement.setInt(1,shopperId);
			this.result = statement.executeQuery();
		}catch(SQLException e) {
			throw e;
		}catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @param urlArray
	 * @param productId
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean executeSecondQuery(String []urlArray , int productId) throws SQLException , Exception {
		try{
		 	for(int index=0;index<urlArray.length;index++){
		 		this.statement = this.connect.prepareStatement(this.query.getSecondQuery());
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
	public int executeThirdQuery() throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement("SET SQL_SAFE_UPDATES = 0;");
	        return this.statement.executeUpdate(this.query.getThirdQuery())-2;
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
	public void executeFourthQuery() throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement(this.query.getFourthQuery());
	        this.result = statement.executeQuery();
		} 
		catch (SQLException e) {
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	/**
	 * @param newquery
	 * @return ResultSet type result
	 * @throws SQLException
	 * @throws Exception
	 */
	public void executeNewQuery(String newquery) throws SQLException , Exception{
		try {
			this.statement = this.connect.prepareStatement(newquery);
	        this.result = statement.executeQuery();
		} 
		catch (SQLException e) {
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
}