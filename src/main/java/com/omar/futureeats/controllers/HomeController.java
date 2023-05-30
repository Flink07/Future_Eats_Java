package com.omar.futureeats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.omar.futureeats.services.RestaurantService;
import com.omar.futureeats.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	
	private final UserService userServ;
	@Autowired 
	//Sample of hybrid having both autowired and final key words with constructor
	
	private RestaurantService restaurantServ;
	public HomeController(UserService userServ) {
		this.userServ = userServ;
		
	}
	
	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
			
		}
		model.addAttribute("allRestaurants", restaurantServ.getAll() );
		model.addAttribute("loggedInUser", userServ.getUser((Long)session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
	
	
	
 
}