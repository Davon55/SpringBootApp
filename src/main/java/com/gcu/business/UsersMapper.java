package com.gcu.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.model.LoginModel;

public class UsersMapper implements RowMapper<LoginModel>{

	
	//matches the property names in OrderModel with the column name sin the database
	
	
	@Override
	public LoginModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginModel users = new LoginModel(
				rs.getInt("ID"),
				rs.getString("FISRT_NAME"),
				rs.getString("LAST_NAME"),
				rs.getString("USERNAME"),
				rs.getString("PASSWORD"),
				rs.getString("EMAIL")
				);
		return users;
	}

}
