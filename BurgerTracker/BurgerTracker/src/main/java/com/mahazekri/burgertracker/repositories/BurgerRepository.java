package com.mahazekri.burgertracker.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.burgertracker.models.Burger;

import java.util.List;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	

	@Repository
	public interface BurgerRepository extends CrudRepository<Burger, Long> {
		// this method retrieves all the books from the database
	    List<Burger> findAll();
	    // this method finds books with descriptions containing the search string
	    List<Burger> findByRestaurantnameContaining(String search);
	    // this method counts how many titles contain a certain string
	    Long countByNameContaining(String search);
	    Long deleteByNameStartingWith(String search);
	}

