package com.omar.futureeats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.futureeats.models.Restaurant;
import com.omar.futureeats.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	//nothing in constructor because Autowired is on
//	public RestaurantService() {
//		
//	}

	
	//---------------Get ALL-------------------------------
		public List<Restaurant> getAll(){
			return (List<Restaurant>)restaurantRepo.findAll();
		}
		
		//---------------Create --------------------------------
		public Restaurant create(Restaurant restaurant) {
			return restaurantRepo.save(restaurant);
		}
		
		//--------------Get One----------------------------------
		public Restaurant getOne(Long id) {
			Optional<Restaurant> restaurant = restaurantRepo.findById(id);
//			if(restaurant.isPresent()) {
//				return restaurant.get();
//			}
			return restaurant.isPresent() ? restaurant.get() : null;
		}
		
		//-------------Edit--------------------------------------
		public Restaurant edit(Restaurant restaurant) {
			return restaurantRepo.save(restaurant);
		}
		
		
		//-------------Delete------------------------------------
		public void deleteRestaurant(Long id) {
			 restaurantRepo.deleteById(id);
			return;
		}
	
	
}
