package com.mahazekri.dojosninjas.controllers;

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

import com.mahazekri.dojosninjas.models.Dojo;
import com.mahazekri.dojosninjas.models.Ninja;
import com.mahazekri.dojosninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

 private final DojoService dojoService;
 
 public DojoController(DojoService dojoService){
     this.dojoService = dojoService;
 }

 @PostMapping("/dojos")
 public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
     if (result.hasErrors()) {
         return "create_dojo.jsp";
     } else {
         dojoService.createDojo(dojo);
         return "redirect:/ninjas";
     }
 }
 
 @GetMapping("/dojos")
 public String all_dojos(Model model, @ModelAttribute("dojo") Dojo dojo) {
	 List<Dojo> dojos= dojoService.allDojos();
	 model.addAttribute("dojos",dojos);
     return "create_dojo.jsp";

 }

 

 
 
 

 
 

 
 @DeleteMapping("/travels/{id}")
 public String destroy(@PathVariable("id") Long id) {
     dojoService.deleteDojo(id);
     return "redirect:/dojos";
 }
	
 
}


