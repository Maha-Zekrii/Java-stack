package com.mahazekri.javaexam.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mahazekri.javaexam.models.LoginUser;
import com.mahazekri.javaexam.models.User;
import com.mahazekri.javaexam.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// Write register and login methods!
	public User register(User newUser, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "email is taken !");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registerError", "passwords does not match !");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			// hash and set password, then save to DB
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);  
		// SAVE TO DB
		return userRepo.save(newUser);
		}
		
	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		// Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "email is not found !");
		}else {
			User user = potentialUser.get();
			if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginError", "Invalid password !");
			}
			if(result.hasErrors()) {
				return null;
			}else {
				return user;
			}
		}
		
		
		return null;
	}
	
	// find user by id
	public User findById(Long id) {
		Optional<User> maybeUser = userRepo.findById(id);
		if(maybeUser.isPresent()) {
			return maybeUser.get();
		}else {
			return null;
		}
	}
		
}