package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.metacube.parking.dao.ConnectionFactory;
import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.model.Employee;

public class EmployeeDAO {
	/**
	 * 
	 * @param employee
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertEmployee(Employee employee) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getInsertionQuery());
			preStmt.setString(1,employee.getFullName());
			preStmt.setString(2,employee.getGender());
			preStmt.setString(3,employee.getEmail());
			preStmt.setString(4,employee.getPassword());
			preStmt.setString(5,employee.getContactNumber());
			preStmt.setString(6,employee.getOrganization());
			preStmt.setString(7,employee.getProfilePhtotoUrl());
			preStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static dtoEmployee getUserProfile(String email) throws SQLException,Exception   {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet result;
		dtoEmployee emp;
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getUserProfile());
			preStmt.setString(1,email);
			result = preStmt.executeQuery();
			result.next();
			emp = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static LinkedList<dtoEmployee> getFriendsProfile(String email) throws SQLException,Exception{
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet result;
		LinkedList<dtoEmployee> list;
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getCompany());
			preStmt.setString(1,email);
			result = preStmt.executeQuery();
			result.next();
			String company = result.getString(1);
			list = new LinkedList<dtoEmployee>();
			preStmt = conn.prepareStatement(DatabaseQuery.getFriendProfile());
			preStmt.setString(1,company);
			preStmt.setString(2,email);
			result = preStmt.executeQuery();
			while(result.next()) {
				dtoEmployee emp = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 
	 * @param email
	 * @param dtoemployee
	 * @return
	 * @throws Exception
	 */
	public boolean updateEmployee(String email, dtoEmployee dtoemployee) throws Exception {
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getEmployeeUpdationQuery());
			preStmt.setString(1,dtoemployee.getFullName());
			preStmt.setString(2,dtoemployee.getGender());
			preStmt.setString(3,dtoemployee.getContactNumber());
			preStmt.setString(4,dtoemployee.getOrganization());
			preStmt.setString(5,email);
			preStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static String getPhotoUrl(String email) throws Exception {
		Connection conn = null;
		PreparedStatement preStmt = null;
		String url;
		ResultSet result;
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getUrlQuery());
			preStmt.setString(1,email);
			result=preStmt.executeQuery();
			result.next();
			url = result.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	/**
	 * 
	 * @param url
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static boolean updatePhotoUrl(String url, String email) throws Exception {
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getPhotoUpdationQuery());
			preStmt.setString(1,url);
			preStmt.setString(2,email);
			preStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static String getName(String email) throws Exception {
		Connection conn = null;
		PreparedStatement preStmt = null;
		String name;
		ResultSet result;
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getNameQuery());
			preStmt.setString(1,email);
			result=preStmt.executeQuery();
			result.next();
			name = result.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;
	}
}
