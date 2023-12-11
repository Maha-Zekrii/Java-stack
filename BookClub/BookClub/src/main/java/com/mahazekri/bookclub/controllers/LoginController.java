package com.mahazekri.bookclub.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahazekri.bookclub.models.LoginUser;
import com.mahazekri.bookclub.models.User;
import com.mahazekri.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	// Add once service is implemented:
	 @Autowired
	 private UserService userServ;

	@GetMapping("/login")
	public String index(@ModelAttribute("newUser") User newUser,
					@ModelAttribute("newLogin") LoginUser newLogin) {		
		return "login.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {		
		userServ.register(newUser, result);
		if (result.hasErrors()) {			
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}		
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		
		 User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}		
		session.setAttribute("user_id", user.getId());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}