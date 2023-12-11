package com.mahazekri.burgertracker.controllers;




import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahazekri.burgertracker.models.Burger;
import com.mahazekri.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

//..

@Controller
public class BurgerController {
 private final BurgerService burgerService;
 
 public BurgerController(BurgerService burgerService){
     this.burgerService = burgerService;
 }

 
 @GetMapping("/burgers")
 public String all_burgers(Model model, @ModelAttribute("burger") Burger burger) {
	 List<Burger> burgers= burgerService.allBurgers();
	 model.addAttribute("burgers",burgers);
     return "all_burgers.jsp";

 }

 
 @PostMapping("/burgers")
 public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
     if (result.hasErrors()) {
         return "all_burgers.jsp";
     } else {
         burgerService.createBurger(burger);
         return "redirect:/burgers";
     }
 }
 
 @RequestMapping("/burgers/{id}")
 public String show(@PathVariable("id") Long id,Model model) {
     Burger burger = burgerService.findBurger(id);
     model.addAttribute("burger",burger);     
     return "all_burgers.jsp";
 }
 

 @RequestMapping(value="/burgers/{id}", method=RequestMethod.PUT)
 public Burger update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="restaurantname") String restaurantname, @RequestParam(value="rating") Integer rating) {
		Burger burger = new Burger(name, restaurantname, rating);
		burger.setId(id);
		Burger updatedBurger = burgerService.updateBurger(burger);
     return updatedBurger;
 }
 
	
 @RequestMapping(value="/burgers/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     burgerService.deleteBurger(id);
 }
}


