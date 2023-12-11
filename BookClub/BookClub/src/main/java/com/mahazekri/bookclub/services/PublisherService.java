package com.mahazekri.bookclub.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahazekri.bookclub.models.Publisher;
import com.mahazekri.bookclub.repositories.PublisherRepository;



@Service
public class PublisherService {

	// C R U D
	
	@Autowired
	private PublisherRepository publisherRepo;

//	READ ALL
	public List<Publisher> allPublishers() {
		return publisherRepo.findAll();
	}

//	CREATE
	public Publisher createPublisher(Publisher p) {
		return publisherRepo.save(p);
	}

//	READ ONE
	public Publisher findPublisher(Long id) {
		Optional<Publisher> maybePublisher = publisherRepo.findById(id);
		if (maybePublisher.isPresent()) {
			return maybePublisher.get();
		} else {
			return null;
		}
	}

//	UPDATE
	public Publisher updatePublisher(Publisher p) {
		return publisherRepo.save(p);
	}

//	DELETE
	public void deletePublisher(Long id) {
		publisherRepo.deleteById(id);
	}
}