package com.mahazekri.travelapp.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mahazekri.travelapp.models.Travel;
import com.mahazekri.travelapp.repositories.TravelRepository;

@Service
public class TravelService {

 private final TravelRepository travelRepository;
 
 

 public TravelService(TravelRepository travelRepository) {
     this.travelRepository = travelRepository;
 }
  
 // returns all the books
 public List<Travel> allTravels() {
     return travelRepository.findAll();
 }
 // creates a book
 public Travel createTravel(Travel b) {
     return travelRepository.save(b);
 }
 // retrieves a book
 public Travel findTravel(Long id) {
     Optional<Travel> optionalTravel = travelRepository.findById(id);
     if(optionalTravel.isPresent()) {
         return optionalTravel.get();
     } else {
         return null;
     }
 }
 
 
 public Travel updateTravel(Travel travel) {
		return travelRepository.save(travel);
	}
	
 // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
	public void deleteTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if(optionalTravel.isPresent()) {
			travelRepository.deleteById(id);
		}
	}
 
}

