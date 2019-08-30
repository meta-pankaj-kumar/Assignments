package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.ConnectToMySQL;
import Dao.SQLQueries;
import POJO.Student;

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
		
		public boolean executeInsertionQuery(Student student) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getInsertionQuery());
				this.statement.setString(1,student.getFirstName());
				this.statement.setString(2,student.getLastName());
				this.statement.setString(3,student.getFathersName());
				this.statement.setString(4,student.getEmail());
				this.statement.setInt(5,student.getClassOfStudent());
				this.statement.setInt(6,student.getAge());
				statement.executeUpdate();
				return true;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		
		public ResultSet executeDisplayQuery() throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getStudentsQuery());
				this.result=statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		
		public ResultSet executeDisplayQueryForStudentId(int studentId) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getStudentByIdQuery());
				this.statement.setInt(1,studentId);
				this.result=statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public boolean executeUpdateQuery(Student student, int studentId) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getUpdationQuery());
				this.statement.setString(1,student.getFirstName());
				this.statement.setString(2,student.getLastName());
				this.statement.setString(3,student.getFathersName());
				this.statement.setString(4,student.getEmail());
				this.statement.setInt(5,student.getClassOfStudent());
				this.statement.setInt(6,student.getAge());
				this.statement.setInt(7,studentId);
				statement.executeUpdate();
				return true;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet executeSearchQuery(String firstName, String lastName) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getSearchQuery());
				this.statement.setString(1,firstName);
				this.statement.setString(2,lastName);
				this.result = statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet executeClassQuery() throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getClassQuery());
				this.result = statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
		public ResultSet executeClassStudentsQuery(int classSelected) throws SQLException , Exception{
			try {
				this.statement = this.connect.prepareStatement(this.query.getClassStudentsQuery());
				this.statement.setInt(1,classSelected);
				this.result = statement.executeQuery();
				return this.result;
			}catch(SQLException e) {
				throw e;
			}catch (Exception e) {
				throw e;
			}
		}
}