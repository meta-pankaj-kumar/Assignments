package com.metacube.parking.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionFactory;
import com.metacube.parking.facade.SingleStringMapper;
/**
 * 
 * @author Pankaj
 *
 */
public class ParkingDAO {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean checkAuthentication(String email, String password) throws SQLException,Exception{
		
		String extractedPassword = jdbcTemplate.queryForObject(DatabaseQuery.getPassword(),new Object[] { email }, new SingleStringMapper());
		boolean flag = false;
		if(extractedPassword.equals(password)) {
			flag=true;
		}
		return flag;
	}
}