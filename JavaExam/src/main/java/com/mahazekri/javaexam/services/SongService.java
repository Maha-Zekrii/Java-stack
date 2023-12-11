package com.mahazekri.javaexam.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahazekri.javaexam.models.Song;
import com.mahazekri.javaexam.repositories.SongRepository;


@Service
public class SongService {
	
 @Autowired
 private  SongRepository songRepository;

  
 // returns all the books
 public List<Song> allSongs() {
     return songRepository.findAll();
 }
 // creates a book
 public Song createSong(Song s) {
     return songRepository.save(s);
 }
 // retrieves a book
 public Song findSong(Long id) {
     Optional<Song> optionalSong = songRepository.findById(id);
     if(optionalSong.isPresent()) {
         return optionalSong.get();
     } else {
         return null;
     }
 }
 
 
 public Song updateSong(Song song) {
		return songRepository.save(song);
	}
	
 // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
	public void deleteSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			songRepository.deleteById(id);
		}
	}
 
}

