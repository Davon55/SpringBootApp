package com.gcu.model;



public class LoginModel {
	private int Id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String Email;
	
	public LoginModel(int Id,String firstname, String lastname, String username, String password, String Email) {
		
		this.Id = Id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.username = username;
		this.password = password;
		this.Email = Email;
	}

	public LoginModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastName;
	}
	
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
}