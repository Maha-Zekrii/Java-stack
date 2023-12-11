package com.mahazekri.bookclub.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.bookclub.models.Publisher;


@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

// READ ALL
	List<Publisher> findAll();
}