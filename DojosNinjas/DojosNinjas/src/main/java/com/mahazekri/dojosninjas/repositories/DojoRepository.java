package com.mahazekri.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.dojosninjas.models.Dojo;

	@Repository
	public interface DojoRepository extends CrudRepository<Dojo, Long> {
		// this method retrieves all the books from the database
	    List<Dojo> findAll();
	    // this method finds books with descriptions containing the search string
	    List<Dojo> findByNameContaining(String search);
	    // this method counts how many titles contain a certain string
	    Long countByName(String search);
	    Long deleteByNameStartingWith(String search);
	}


