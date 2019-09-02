package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.ConnectToMySQL;
import Dao.SQLQueries;
import POJO.Employee;
import POJO.Plan;
import POJO.Vehicle;

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
		
		/**
		 * @param shopperId
		 * @return ResultSet type result
		 * @throws SQLException
		 * @throws Exception
		 */
		
		public boolean executeInsertionQuery(Employee employee) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getInsertionQuery());
				this.statement.setString(1,employee.getName());
				this.statement.setString(2,employee.getGender());
				this.statement.setString(3,employee.getEmail());
				this.statement.setString(4,employee.getPassword());
				this.statement.setString(5,employee.getContact());
				this.statement.setString(6,employee.getCompany());
				statement.executeUpdate();
				return true;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet getRegistrationNumber(Employee employee) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getRegistrationNumber());
				this.statement.setString(1,employee.getEmail());
				this.result = statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public boolean areCredentialsAuthentic(String email , String password) throws SQLException , Exception{
			try {
				boolean flag = false;
				this.statement = this.connect.prepareStatement(this.query.getPassword());
				this.statement.setString(1,email);
				this.result = statement.executeQuery();
				if (this.result.next()){
					String pass = result.getString(1);
					if(password.equals(pass)) {
						flag = true ;
					}
				}
				return flag;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public boolean executeVehicleInsertionQuery(Vehicle vehicle) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getVehicleInsertionQuery());
				this.statement.setString(1,vehicle.getEmail());
				this.statement.setString(2,vehicle.getVehicleName());
				this.statement.setString(3,vehicle.getVehicleType());
				this.statement.setString(4,vehicle.getVehiclenumber());
				this.statement.setString(5,vehicle.getEmployeeId());
				this.statement.setString(6,vehicle.getVehicleDetails());
				statement.executeUpdate();
				return true;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet executeGetVehicleId(String email) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getVehicleId());
				this.statement.setString(1,email);
				this.result = statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet getFriends(String email)  throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getCompany());
				this.statement.setString(1,email);
				this.result = statement.executeQuery();
				result.next();
				String company = (String)result.getString(1);
				this.statement = this.connect.prepareStatement(this.query.getFriends());
				this.statement.setString(1,company);
				this.result = statement.executeQuery();
				return this.result;
			}
			catch(SQLException e) {
				throw e;
			}
			catch (Exception e) {
				throw e;
			}
		}
		public ResultSet getFriendsByName(String email)  throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getCompany());
				this.statement.setString(1,email);
				this.result = statement.executeQuery();
				result.next();
				String company = (String)result.getString(1);
				this.statement = this.connect.prepareStatement(this.query.getFriendsByName());
				this.statement.setString(1,company);
				this.result = statement.executeQuery();
				return this.result;
			}
			catch(SQLException e) {
				throw e;
			}
			catch (Exception e) {
				throw e;
			}
		}
		public ResultSet getProfile(String email)  throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getProfile());
				System.out.println("Email Here is "+email);
				this.statement.setString(1,email);
				this.result = this.statement.executeQuery();
				return this.result;
			}
			catch(SQLException e) {
				throw e;
			}
			catch (Exception e) {
				throw e;
			}
		}
		public boolean executePlanInsertionQuery(Plan plan) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getPlanInsertionQuery());
				this.statement.setInt(1,plan.getVehicleId());
				this.statement.setString(2,plan.getEmail());
				this.statement.setString(3,plan.getCurrency());
				this.statement.setString(4,plan.getPlanType());
				this.statement.setString(5,plan.getPrice());
				statement.executeUpdate();
				return true;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet executeGetPlanId(int vehicleId,String email) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getPlanId());
				this.statement.setInt(1,vehicleId);
				this.statement.setString(2,email);
				this.result = statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public boolean execteCheckIfFirstTimeRegister(String email) throws SQLException , Exception{
			try {
				boolean flag=false;
				this.statement = this.connect.prepareStatement(this.query.getCheckIfFirstTimeRegisterQuery());
				this.statement.setString(1,email);
				this.result = statement.executeQuery();
				this.result.next();
				if(result.getString(1).equals("0")){
					flag = true;
				}
				return flag;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public boolean executeUpdationQuery(Employee employee) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getUpdationQuery());
				this.statement.setString(1,employee.getName());
				this.statement.setString(2,employee.getGender());
				this.statement.setString(3,employee.getContact());
				this.statement.setString(4,employee.getCompany());
				this.statement.setString(5,employee.getEmail());
				statement.executeUpdate();
				return true;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
}
