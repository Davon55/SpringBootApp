package com.gcu.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;


public interface UsersBusinessServiceInterface {
	
	public void test();
	public LoginModel getById(int id);
	public List<LoginModel> getUsers();
	public List<LoginModel> searchUsers(String searchTerm);
	public int addOne(LoginModel newUser);
	public boolean deleteOne(long id);
	public LoginModel updateOne(long idToUpdate, LoginModel updateUsers);
	public void init();
	public void destroy();
	
}