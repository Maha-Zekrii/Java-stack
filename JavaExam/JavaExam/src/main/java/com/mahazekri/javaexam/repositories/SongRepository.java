package com.mahazekri.javaexam.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahazekri.javaexam.models.Song;



@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

// READ ALL
	List <Song> findAll();
}