package com.mahazekri.travelapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.travelapp.models.Travel;

	@Repository
	public interface TravelRepository extends CrudRepository<Travel, Long> {
		// this method retrieves all the books from the database
	    List<Travel> findAll();
	    // this method finds books with descriptions containing the search string
	    List<Travel> findByVendorContaining(String search);
	    // this method counts how many titles contain a certain string
	    Long countByExpense(String search);
	    Long deleteByExpenseStartingWith(String search);
	}


