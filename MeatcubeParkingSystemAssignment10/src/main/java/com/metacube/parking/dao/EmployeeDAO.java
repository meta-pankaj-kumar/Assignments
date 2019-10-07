package com.metacube.parking.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionFactory;
import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.facade.dtoEmployeeMapper;
import com.metacube.parking.facade.dtoLinkedListOfEmployeeMapper;
import com.metacube.parking.facade.SingleStringMapper;
import com.metacube.parking.model.Employee;
/**
 * 
 * @author Pankaj
 *
 */
public class EmployeeDAO {
	
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
	/**
	 * 
	 * @param employee
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertEmployee(Employee employee) throws DuplicateKeyException{
		try {
		jdbcTemplate.update(DatabaseQuery.getInsertionQuery(),employee.getFullName()
																,employee.getGender()
																,employee.getEmail()
																,employee.getPassword()
																,employee.getContactNumber()
																,employee.getOrganization()
																,employee.getProfilePhtotoUrl());
		}
		catch (DuplicateKeyException e) {
			throw e;
		}
		return true;
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static dtoEmployee getUserProfile(String email) throws SQLException,Exception   {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getUserProfile(),new Object[] { email }, new dtoEmployeeMapper());
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static LinkedList<dtoEmployee> getFriendsProfile(String email) throws SQLException,Exception{
		
		String company = jdbcTemplate.queryForObject(DatabaseQuery.getCompany(),new Object[] { email }, new SingleStringMapper());
		System.out.println(company);
		return jdbcTemplate.queryForObject(DatabaseQuery.getFriendProfile(),new Object[] { company,email }, new dtoLinkedListOfEmployeeMapper());
	}
	/**
	 * 
	 * @param email
	 * @param dtoemployee
	 * @return
	 * @throws Exception
	 */
	public boolean updateEmployee(String email, dtoEmployee dtoemployee) throws Exception {
		
		jdbcTemplate.update(DatabaseQuery.getEmployeeUpdationQuery()
				,dtoemployee.getFullName()
				,dtoemployee.getGender()
				,dtoemployee.getContactNumber()
				,dtoemployee.getOrganization()
				,email);
		return true;
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static String getPhotoUrl(String email) throws Exception {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getUrlQuery(),new Object[] { email }, new SingleStringMapper());
	}
	/**
	 * 
	 * @param url
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static boolean updatePhotoUrl(String url, String email) throws Exception {
		
		jdbcTemplate.update(DatabaseQuery.getPhotoUpdationQuery()
				,url
				,email );
		return true;
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public static String getName(String email) {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getNameQuery(),new Object[] { email }, new SingleStringMapper());
	}
}