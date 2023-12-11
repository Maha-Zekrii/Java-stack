package com.mahazekri.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahazekri.dojosninjas.models.Ninja;
import com.mahazekri.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private  NinjaRepository ninjaRepository;
	 
	 

	
	  
	 // returns all the books
	 public List<Ninja> allNinjas() {
	     return ninjaRepository.findAll();
	 }
	 // creates a book
	 public Ninja createNinja(Ninja b) {
	     return ninjaRepository.save(b);
	 }
	 // retrieves a book
	 public Ninja findNinja(Long id) {
	     Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	     if(optionalNinja.isPresent()) {
	         return optionalNinja.get();
	     } else {
	         return null;
	     }
	 }
	 
	 
	 public Ninja updateNinja(Ninja ninja) {
			return ninjaRepository.save(ninja);
		}
		
	 // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
		public void deleteNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
			if(optionalNinja.isPresent()) {
				ninjaRepository.deleteById(id);
			}
		}
	 

}
