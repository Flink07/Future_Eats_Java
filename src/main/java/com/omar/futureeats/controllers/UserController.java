package com.omar.futureeats.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omar.futureeats.models.LoginUser;
import com.omar.futureeats.models.User;
import com.omar.futureeats.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	
	private final UserService userServ;
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/login/reg")
		public String loginReg(@ModelAttribute("newUser") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
			return "user/loginReg.jsp";
		}
	
	@PostMapping("/process/register")
	public String processRegisterUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
		//Validations - set reject values 
		//reject if email is taken 
		if(userServ.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique", "E-mail is already in use, choose a different E-mail");
		}
		//reject if password doesn't match 
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "confirm password must match password");
		}
		// re-render if errors
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/";
	}
	
	
	@PostMapping("/process/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User loggingUser = userServ.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/users/login/reg";
	}
	
	
	
}
