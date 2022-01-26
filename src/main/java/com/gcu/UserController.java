package com.gcu;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.SearchUsersModel;


@Controller
@RequestMapping("/users")
public class UserController {

	// uses dependency injection configuration found in the SpringConfig file 
		// to choose which busienssService will be utilized.
		
		private UsersBusinessServiceInterface usersService;
		
		@GetMapping("/spa") 
		public String displaySPA(Model model)
		{
			// Display single page application
			model.addAttribute("title", "Users");
			model.addAttribute("searchUsersModel", new SearchUsersModel());
			
			return "ordersSPA";
		}

		@GetMapping("/searchForm") 
		public String displaySearchForm(Model model)
		{
			// Display Login Form View
			model.addAttribute("title", "Search Orders");
			model.addAttribute("SearchUsersModel", new SearchUsersModel());
			return "usersSearchForm";
		}
		
		@GetMapping("/addNewForm") 
		public String displayAddNewForm(Model model)
		{
			// Display new order form
			model.addAttribute("title", "Add new order");
			model.addAttribute("LoginModel", new LoginModel());
			return "newUserForm";
		}
		
		@PostMapping("/searchResults") 
		public String showAllUsers(SearchUsersModel searchModel, BindingResult bindingResult, Model model) { 
			System.out.println("Performing search results for " + searchModel.getSearchTerm());
			// Check for validation errors
	        if (bindingResult.hasErrors()) 
	        {
	        	model.addAttribute("title", "Search for Users");
	            return "usersSearchForm";
	        }
			List<LoginModel> users = usersService.searchUsers(searchModel.getSearchTerm());  
		 	model.addAttribute("title", "Search for Users");
			model.addAttribute("searchModel", searchModel);
			model.addAttribute("users", users);
			
			return "users";
			
		}
		@GetMapping("/all") 
		public String showAllUsers( Model model) { 
			 
			List<LoginModel> users = usersService.getUsers();  
		 	model.addAttribute("title", "Show all Users");
			model.addAttribute("searchModel", new SearchUsersModel());
			model.addAttribute("users", users);
			
			return "users";
			
		}
		
		@PostMapping("/addNew") 
		// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
		public String addOrder(LoginModel newUsers, BindingResult bindingResult, Model model) {
			// add the new order
			usersService.addOne(newUsers);
			
			// get updated list of all the users
			List<LoginModel> users = usersService.getUsers(); 
			
			// display all users
			model.addAttribute("users", users); 
			model.addAttribute("searchModel", new SearchUsersModel()); 
			return "users";
		}
		 
		
		
		@GetMapping("/admin")
		public String showUsersForAdmin( Model model) { 
			 
			// display all users with delete and edit buttons
			List<LoginModel> users = usersService.getUsers();  
		 	model.addAttribute("title", "Edit or delete orders");
			model.addAttribute("searchModel", new SearchUsersModel());
			model.addAttribute("users", users);
			
			// usersAdmin page shows a table of users including buttons for delete and edit.
			return "usersAdmin";
			
		}
		
		@DeleteMapping("/delete") 
		// process a request from the AdminUser.  Delete a user from the database 
		public String deleteOrder(LoginModel user, BindingResult bindingResult, Model model) {
			// delete the user
			usersService.deleteOne(user.getId());
			
			// get updated list of all the users
			List<LoginModel> users = usersService.getUsers(); 
			
			// display all users
			model.addAttribute("orders", users); 
			model.addAttribute("searchModel", new SearchUsersModel()); 
			return "usersAdmin";
		}
		
		@PostMapping("/editForm") 
		public String displayEditForm(LoginModel loginModel, Model model)
		{
			// Display new order form
			model.addAttribute("title", "Edit order");
			model.addAttribute("loginModel", loginModel);
			return "usersEditForm";
		}
		
		@PostMapping("/doUpdate") 
		// process a request from the AdduserForm.  Add a new users to the database.  Show all orders.
		public String updateOrder(LoginModel user, BindingResult bindingResult, Model model) {
			// add the new order
			usersService.updateOne(user.getId(), user);
			
			// get updated list of all the orders
			List<LoginModel> users = usersService.getUsers(); 
			
			// display all orders
			model.addAttribute("users", users); 
			model.addAttribute("searchModel", new SearchUsersModel()); 
			return "usersAdmin";
		}


}
