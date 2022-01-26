package com.gcu;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/")
	public String display(Model model)
	{
		//display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(LoginModel loginModel, Model model)
	{
		model.addAttribute("loginModel", loginModel);
		return "LoginSuccess";
	}
	
	//check to see if the login matches names and passowords
	
	//this will get the usersService defined
	//springconfig file will determine if the app will return 
	//userbusiness service 


}