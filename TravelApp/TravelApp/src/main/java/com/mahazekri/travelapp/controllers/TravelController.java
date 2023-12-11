package com.mahazekri.travelapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mahazekri.travelapp.models.Travel;
import com.mahazekri.travelapp.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {

 private final TravelService travelService;
 
 public TravelController(TravelService travelService){
     this.travelService = travelService;
 }

 
 @GetMapping("/travels")
 public String all_travels(Model model, @ModelAttribute("travel") Travel travel) {
	 List<Travel> travels= travelService.allTravels();
	 model.addAttribute("travels",travels);
     return "all_travels.jsp";

 }

 
 @PostMapping("/travels")
 public String create(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
     if (result.hasErrors()) {
         return "all_travels.jsp";
     } else {
         travelService.createTravel(travel);
         return "redirect:/travels";
     }
 }
 
 @RequestMapping("/travels/{id}")
 public String show(@PathVariable("id") Long id,Model model) {
     Travel travel = travelService.findTravel(id);
     model.addAttribute("travel",travel);     
     return "show_travel.jsp";
 }
 

 @RequestMapping("/travels/{id}/edit")
 public String edit(@PathVariable("id") Long id, Model model) {
     Travel travel = travelService.findTravel(id);
     model.addAttribute("travel", travel);
     return "edit.jsp";
 }
 
 @RequestMapping(value="/travels/{id}/edit", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
     if (result.hasErrors()) {
         return "edit.jsp";
     } else {
         travelService.updateTravel(travel);
         return "redirect:/travels";
     }
 }
 
 @DeleteMapping("/travels/{id}")
 public String destroy(@PathVariable("id") Long id) {
     travelService.deleteTravel(id);
     return "redirect:/travels";
 }
	
 
}


