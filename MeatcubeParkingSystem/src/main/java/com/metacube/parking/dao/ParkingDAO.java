package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.parking.dao.ConnectionFactory;

public class ParkingDAO {
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean checkAuthentication(String email, String password) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet result =null;
		boolean flag=false;
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getPassword());
			preStmt.setString(1,email);
			result = preStmt.executeQuery();
			result.next();
			String dbPass = result.getString(1);
			if(dbPass.equals(password)) {
				flag=true;
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
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
