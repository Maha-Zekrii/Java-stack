package com.mahazekri.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.dojosninjas.models.Ninja;

	@Repository
	public interface NinjaRepository extends CrudRepository<Ninja, Long> {
		// this method retrieves all the books from the database
	    List<Ninja> findAll();
	    // this method finds books with descriptions containing the search string
	    List<Ninja> findByFirstnameContaining(String search);
	    // this method counts how many titles contain a certain string
	    Long countByLastname(String search);
	    Long deleteByLastnameStartingWith(String search);
	}


