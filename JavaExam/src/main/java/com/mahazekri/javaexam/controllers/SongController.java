package com.mahazekri.javaexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mahazekri.javaexam.models.Song;
import com.mahazekri.javaexam.models.User;
import com.mahazekri.javaexam.services.SongService;
import com.mahazekri.javaexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SongController  {
	
	@Autowired
	private SongService songServ;
	
	@Autowired
	private UserService userServ;


	@GetMapping("/home")
	public String index(Model model, @ModelAttribute("song") Song song,  HttpSession session ) {		
		
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		User user= userServ.findById(userID);
		List<Song> all_songs = songServ.allSongs();
		model.addAttribute("songs", all_songs);	
		model.addAttribute("user", user);
		return "index.jsp";
		
	}
	
	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {	
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		Song song = songServ.findSong(id);
		model.addAttribute("song", song);		
		return "one_song.jsp";
		
	}
	
	@GetMapping("/songs/new")
	public String displayForm( @ModelAttribute("song") Song song, HttpSession session) {
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		return "newSong.jsp";		
	}
	

	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song")Song song,BindingResult result, Model model, HttpSession session) {	
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		if(result.hasErrors()) {			
			return "newSong.jsp";
		} else {
			
			User user= userServ.findById(userID);
			song.setUser(user);
			song.setContribution(1);
			Song newSong = songServ.createSong(song);
			
			return "redirect:/home";
		}
		
		
	}
	
	
//	Display Route - Display Edit Form
	@GetMapping("/songs/{id}/edit")
	public String displayform(Model model, @PathVariable("id") Long id,  HttpSession session) {		
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		Song thisSong = songServ.findSong(id);
		model.addAttribute("song", thisSong);
		return "edit.jsp";
		
	}

	
	
// Action Route -- Edit a Book
	
	@PutMapping("/songs/{id}/edit")
	public String updateSong(@Valid @ModelAttribute("song") Song song,BindingResult result, HttpSession session) {
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			User user= userServ.findById(userID);			
			song.setUser(user);
			System.out.printf("************" + song.getContribution());
			song.setContribution(song.getContribution()+1);
			songServ.updateSong(song);
			System.out.printf("++++++++++" + song.getContribution());
			
			return "redirect:/home";
		}
	}
	
	
	
// ACTION ROUTE -- DELET a BOOK
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		Long userID=(Long) session.getAttribute("user_id");
		if(userID==null) {return "redirect:/";}
		songServ.deleteSong(id);
		return "redirect:/home";
	}

		
	
	
	
}