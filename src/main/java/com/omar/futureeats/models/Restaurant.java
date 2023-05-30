package com.omar.futureeats.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="restaurants")
public class Restaurant {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 100, message="Name must be a minimum of 2 characters")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 50, message="Type must not be empty")
	private String type;
	
	@NotNull
	@Size(min = 2, max = 50, message="Address must not be empty, if unknown add city")
	private String address;
	
	@NotNull
	@Size(min = 3, max = 200, message="A short description of 3 Characters is required")
	private String description;
	
	@NotNull
	@Size(min = 3, max = 200, message="recommendation must be between 3 and 200 Characters")
	private String recommendation;
	
	//
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
  //-----------------------------Zero Argument Constructor-----------------------------------------------
	public Restaurant() {}
	
	
	//-----------------------------Main Constructor-----------------------------------------------
	public Restaurant(String name, String type, String address, String description, String recommendation) {
		this.name = name;
		this.type = type;
		this.address = address; 
		this.description = description;
		this.recommendation = recommendation;
	}

	//-----------------------------Other Methods-----------------------------------------------
	
	
	
	
	
	
	//-----------------------------Getters & Setters-----------------------------------------------
		

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRecommendation() {
		return recommendation;
	}


	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//-----------------------------Persistence Layer-----------------------------------------------
		// Methods we don't call
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
	
	

}
