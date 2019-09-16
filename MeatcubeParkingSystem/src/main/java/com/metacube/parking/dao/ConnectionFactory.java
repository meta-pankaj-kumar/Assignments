package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private String driver ;
	private String userName;
	private String password;
	private String url;
	
	public ConnectionFactory(){
		this.driver = "com.mysql.jdbc.Driver";
		this.userName = "root";
		this.password = "1234";
		this.url = "jdbc:mysql://localhost:3306/employee";
	}
	/** 
	 * @return object of Connection class
	 * @throws Exception
	 *             when driver class not found or can't create connection
	 */
	public Connection getConnection() throws Exception {
		try {
			Connection conn = null;
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url,this.userName,this.password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}
