package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.parking.dao.ConnectionFactory;
import com.metacube.parking.model.Plan;

public class PlanDAO {
	/**
	 * 
	 * @param plan
	 * @param email
	 * @param index
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertPlan(Plan plan , String email , int index) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getPlanInsertionQuery());
			preStmt.setInt(1,index);
			preStmt.setString(2,email);
			preStmt.setString(3,plan.getCurrency());
			preStmt.setString(4,plan.getPrice());
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
}