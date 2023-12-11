package com.mahazekri.dojosninjas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahazekri.dojosninjas.models.Dojo;
import com.mahazekri.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

@Autowired	
 private  DojoRepository dojoRepository; 
  
 // returns all the books
 public List<Dojo> allDojos() {
     return dojoRepository.findAll();
 }
 // creates a book
 public Dojo createDojo(Dojo b) {
     return dojoRepository.save(b);
 }
 // retrieves a book
 public Dojo findDojo(Long id) {
     Optional<Dojo> optionalDojo = dojoRepository.findById(id);
     if(optionalDojo.isPresent()) {
         return optionalDojo.get();
     } else {
         return null;
     }
 }
 
 
 public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
 // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
	public void deleteDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			dojoRepository.deleteById(id);
		}
	}
 
}

