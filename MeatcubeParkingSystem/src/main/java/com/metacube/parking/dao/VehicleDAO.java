package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.parking.dao.ConnectionFactory;
import com.metacube.parking.model.Vehicle;

public class VehicleDAO {
	/**
	 * 
	 * @param vehicle
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertVehicle(Vehicle vehicle , String email) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getVehicleInsertionQuery());
			preStmt.setString(1,email);
			preStmt.setString(2,vehicle.getVehicleName());
			preStmt.setString(3,vehicle.getVehicleType());
			preStmt.setString(4,vehicle.getvehicleNumber());
			preStmt.setString(5,vehicle.getEmployeeId());
			preStmt.setString(6,vehicle.getVehicleDetails());
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
	 * @throws SQLException
	 * @throws Exception
	 */
	public int getVehicleId(String email) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet result = null; 
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.getVehicleID());
			preStmt.setString(1,email);
			result = preStmt.executeQuery();
			result.next();
			int vehicleId = result.getInt(1);
			return vehicleId;
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
