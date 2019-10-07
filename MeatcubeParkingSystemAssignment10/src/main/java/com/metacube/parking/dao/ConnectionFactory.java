package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * @author Pankaj
 *
 */
public class ConnectionFactory {

	/**
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		  String userName = "root";
		  String password = "1234";
		  String url = "jdbc:mysql://localhost:3306/employee";
		try {
			Connection conn = null;
			Class.forName( driver);
			conn = DriverManager.getConnection( url, userName, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
