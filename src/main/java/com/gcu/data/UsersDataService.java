package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.business.UsersMapper;
import com.gcu.model.LoginModel;

@Repository
public class UsersDataService implements UsersDataAccessInterface<LoginModel> {

		//jdbctemplate is a spring class used to shorten code needed to interact with SQL database
	    // datasource is defined in the application.properties file
	  
	    DataSource dataSource;
	    JdbcTemplate jdbcTemplate;
	    
	    public UsersDataService(DataSource dataSource) {
	    	this.dataSource = dataSource;
	    	this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	@Override
	public LoginModel getById(int id) {
		LoginModel result = jdbcTemplate.queryForObject("select * from users where id = ?", new UsersMapper(),
				new Object[] {id});
		return result;
	}

	@Override
	public List<LoginModel> getUsers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from users", new UsersMapper());
	}

	@Override
	public List<LoginModel> searchUsers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOne(LoginModel newUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginModel updateOne(long idToUpdate, LoginModel updateUsers) {
		// TODO Auto-generated method stub
		return null;
	}

}
