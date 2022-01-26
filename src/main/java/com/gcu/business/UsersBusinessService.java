package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataServiceRepository;
import com.gcu.model.LoginModel;
import com.gcu.model.UserEntity;

@Service
public class UsersBusinessService implements UsersBusinessServiceInterface{
	
	@Autowired
	UsersDataServiceRepository service;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("This is from the business service test!!");
	}

	@Override
	public List<LoginModel> getUsers() {
		//get list of entities
		List<UserEntity> users = service.getUsers();
		//create an empty list of users
		List<LoginModel> user = new ArrayList<LoginModel>();
		//for each entity in the list, create a new user and add users
		for(UserEntity entity: users) {
			user.add(
					//translate from entity to login model
					new LoginModel(
							entity.getId(),
							entity.getFirstname(),
							entity.getLastname(),
							entity.getUsername(),
							entity.getPassword(),
							entity.getEmail()
							)
					);
		}
		return user;
	}

	@Override
	public LoginModel getById(int id) {
		UserEntity result = service.getById(id);
		LoginModel user = new LoginModel(
				result.getId(),
				result.getFirstname(),
				result.getLastname(),
				result.getUsername(),
				result.getPassword(),
				result.getEmail()
				);
		return user;
	}

	@Override
	public List<LoginModel> searchUsers(String searchTerm) {
		//get list of entities
				List<UserEntity> users = service.searchUsers(searchTerm);
				//create an empty list of users
				List<LoginModel> user = new ArrayList<LoginModel>();
				//for each entity in the list, create a new users and add users
				for(UserEntity entity: users) {
					user.add(
							//translate from entity to login model
							new LoginModel(
									entity.getId(),
									entity.getFirstname(),
									entity.getLastname(),
									entity.getUsername(),
									entity.getPassword(),
									entity.getEmail()
									)
							);
				}
				return user;
	}

	@Override
	public int addOne(LoginModel newUser) {
		UserEntity entity = new UserEntity(
				newUser.getId(),
				newUser.getFirstname(),
				newUser.getLastname(),
				newUser.getUsername(),
				newUser.getPassword(),
				newUser.getEmail()
				);
		return service.addOne(entity);
	}

	@Override
	public boolean deleteOne(long id) {
		return service.deleteOne(id);
		
	}

	@Override
	public LoginModel updateOne(long idToUpdate, LoginModel updateUser) {
		UserEntity entity = new UserEntity(
				updateUser.getId(),
				updateUser.getFirstname(),
				updateUser.getLastname(),
				updateUser.getUsername(),
				updateUser.getPassword(),
				updateUser.getEmail()
				);
		UserEntity result = service.updateOne(idToUpdate, entity);
		
		LoginModel updated = new LoginModel(
				result.getId(),
				result.getFirstname(),
				result.getLastname(),
				result.getUsername(),
				result.getPassword(),
				result.getEmail()
				);
		return updated;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
