package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.gcu.model.UserEntity;

@Repository
public class UsersDataServiceRepository implements UsersDataAccessInterface<UserEntity>{
		
		@Autowired
		private UsersRepository usersRepository;
		@SuppressWarnings("unused")
		//data source is defined in the application.properties file,l
		private DataSource dataSource;
		private JdbcTemplate jdbcTemplate;
		
		//non default constructor for constructor injection 
		public UsersDataServiceRepository(UsersRepository usersRepository, DataSource dataSource) {
			
		    this.usersRepository = usersRepository;
			this.dataSource = dataSource;
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		@Override
		public UserEntity getById(int id) {
			return usersRepository.findById((long) id).orElse(null);
		}
		

	@Override
	public List<UserEntity> getUsers() {
		
		List<UserEntity> user = (List<UserEntity>) usersRepository.findAll();
		return user;
	}
	
	@Override
	public int addOne(UserEntity newUser) {
		UserEntity result = usersRepository.save(newUser);
		if(result == null) {
			return 0;
		}
		return (int) result.getId();
		
	}
	

	@Override
	public List <UserEntity> searchUsers(String searchTerm) {
		
		List<UserEntity> result = usersRepository.findByUserNameContainingIgnoreCase(searchTerm);
		return result;
	}



	@Override
	public boolean deleteOne(long id) {
		usersRepository.deleteById(id);
		return true;
	}

	
	
	@Override
	public UserEntity updateOne(long idToUpdate, UserEntity updateUsers) {
		UserEntity result = usersRepository.save(updateUsers);
		return result;
	}

}
