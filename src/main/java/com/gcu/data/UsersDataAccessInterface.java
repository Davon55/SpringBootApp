package com.gcu.data;

import java.util.List;



public interface UsersDataAccessInterface<T> {
	public T getById(int id);
	public List<T> getUsers();
	public List<T> searchUsers(String searchTerm);
	public int addOne(T newUser);
	public boolean deleteOne(long id);
	public T updateOne(long idToUpdate, T updateUsers);
	

}
