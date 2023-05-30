package com.omar.futureeats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omar.futureeats.models.Restaurant;
import com.omar.futureeats.services.RestaurantService;
import com.omar.futureeats.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantServ;
	@Autowired
	private UserService userServ;
	//Autowired allows me to comment out the constructor
//	public RestaurantController(RestaurantService restaurantServ) {
//		this.restaurantServ =restaurantServ;
//	}

	
	@GetMapping("/create")
	public String createRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		return "restaurant/create.jsp";
	}
	
	//-------Create----------------
	@PostMapping("/process/create")
	public String processCreateRestaurant(@Valid @ModelAttribute("restaurant") Restaurant restaurant, BindingResult result, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		if(result.hasErrors()) {
			return "restaurant/create.jsp";
		}
		restaurantServ.create(restaurant);
		return "redirect:/";
	}
	
	//---------Show One-----------
	@GetMapping("/display/{id}")
	public String displayRestaurant(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		model.addAttribute("restaurant", restaurantServ.getOne(id));
		model.addAttribute("loggedInUser", userServ.getUser((Long)session.getAttribute("user_id")));
		return "restaurant/display.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editRestaurant(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		model.addAttribute("restaurant", restaurantServ.getOne(id) );
		return "restaurant/edit.jsp";
	}
	
	
	@PutMapping("/process/edit/{id}")
	public String processEditRestaurant(@Valid @ModelAttribute("restaurant") Restaurant restaurant, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "restaurant/edit.jsp";
		}
		restaurantServ.edit(restaurant);
		return "redirect:/restaurants/display/" +id;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRestaurant(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		
		restaurantServ.deleteRestaurant(id);
		return "redirect:/";
	}
	
	
}
