package com.metacube.parking.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionFactory;
import com.metacube.parking.model.Plan;
/**
 * 
 * @author Pankaj
 *
 */
public class PlanDAO {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
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
		
		jdbcTemplate.update(DatabaseQuery.getPlanInsertionQuery()
				,index
				,email
				,plan.getCurrency()
				,plan.getPrice() );
		return true;
	}
}