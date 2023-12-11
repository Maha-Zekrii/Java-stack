package com.mahazekri.dojosninjas.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahazekri.dojosninjas.models.Dojo;
import com.mahazekri.dojosninjas.models.Ninja;
import com.mahazekri.dojosninjas.services.DojoService;
import com.mahazekri.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

    @Autowired
	private  NinjaService ninjaService;
    
    @Autowired
   	private  DojoService dojoService;
 
 
 

 
 @GetMapping("/ninjas")
 
 public String all_ninjas(Model model, @ModelAttribute("ninja") Ninja ninja) {
	 List<Ninja> ninjas= ninjaService.allNinjas();
	 model.addAttribute("ninjas",ninjas);
	 List<Dojo> dojos= dojoService.allDojos();
	 model.addAttribute("dojos",dojos);
     return "all_ninjas.jsp";

 }

 
 @PostMapping("/ninjas")
 public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
	 if (result.hasErrors()) {
         return "redirect:/ninjas";
     } else {
         ninjaService.createNinja(ninja);
         return "redirect:/ninjas";
     }
 }
 
 @RequestMapping("/ninjas/{id}")
 public String show(@PathVariable("id") Long id,Model model) {
     Ninja ninja = ninjaService.findNinja(id);
     model.addAttribute("ninja",ninja);     
     return "show_ninja.jsp";
 }
 

 @RequestMapping("/ninjas/{id}/edit")
 public String edit(@PathVariable("id") Long id, Model model) {
     Ninja ninja = ninjaService.findNinja(id);
     model.addAttribute("ninja", ninja);
     return "edit.jsp";
 }
 
 @RequestMapping(value="/ninjas/{id}/edit", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
     if (result.hasErrors()) {
         return "edit.jsp";
     } else {
         ninjaService.updateNinja(ninja);
         return "redirect:/ninjas";
     }
 }
 
 @DeleteMapping("/ninjas/{id}")
 public String destroy(@PathVariable("id") Long id) {
     ninjaService.deleteNinja(id);
     return "redirect:/ninjas";
 }
	
 
}


