package com.mahazekri.burgertracker.services;




import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mahazekri.burgertracker.models.Burger;
import com.mahazekri.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
 private final BurgerRepository burgerRepository;
 
 

 public BurgerService(BurgerRepository burgerRepository) {
     this.burgerRepository = burgerRepository;
 }
  
 // returns all the books
 public List<Burger> allBurgers() {
     return burgerRepository.findAll();
 }
 // creates a book
 public Burger createBurger(Burger b) {
     return burgerRepository.save(b);
 }
 // retrieves a book
 public Burger findBurger(Long id) {
     Optional<Burger> optionalBurger = burgerRepository.findById(id);
     if(optionalBurger.isPresent()) {
         return optionalBurger.get();
     } else {
         return null;
     }
 }
 
 
 public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
 // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
	public void deleteBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			burgerRepository.deleteById(id);
		}
	}
 
}

