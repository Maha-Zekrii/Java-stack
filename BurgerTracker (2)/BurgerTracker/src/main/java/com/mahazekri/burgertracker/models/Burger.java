package com.mahazekri.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
	@NotNull
    @Size(min = 5, max = 200,message="Name must be at least 5 characters.")
    private String name;
	@NotNull
    @Size(min = 5, max = 200, message="Restaurant name must be at least 5 characters.")
    private String restaurantname;
   
    @NotNull
    @Min(value=0, message="minimum must be 0.")
    @Max(value=5, message="maximum must be 5.")
    private Integer rating;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger() {
    }
    public Burger(String name, String restaurantname, int rating) {
        this.name = name;
        this.restaurantname = restaurantname;        
        this.rating = rating;
    }
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Long getId() {
  		return id;
  	}
  	public void setId(Long id) {
  		this.id = id;
  	}
  	public String getName() {
  		return name;
  	}
  	public void setName(String name) {
  		this.name = name;
  	}
  	public String getRestaurantname() {
  		return restaurantname;
  	}
  	public Date getCreatedAt() {
  		return createdAt;
  	}
  	public void setCreatedAt(Date createdAt) {
  		this.createdAt = createdAt;
  	}
  	public void setRestaurantname(String restaurantname) {
  		this.restaurantname = restaurantname;
  	}
  	
  	
  	public Integer getRating() {
  		return rating;
  	}
  	public void setRating(Integer rating) {
  		this.rating = rating;
  	}
}

