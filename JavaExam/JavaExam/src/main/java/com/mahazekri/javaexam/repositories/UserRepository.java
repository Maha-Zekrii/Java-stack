package com.mahazekri.javaexam.repositories;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.javaexam.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

// READ ALL
	Optional<User> findByEmail(String email);
}