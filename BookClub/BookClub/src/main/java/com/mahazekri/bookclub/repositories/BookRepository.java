package com.mahazekri.bookclub.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.bookclub.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	// READ ALL
	List<Book> findAll();
}