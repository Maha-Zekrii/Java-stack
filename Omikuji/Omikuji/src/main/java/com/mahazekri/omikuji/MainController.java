package com.mahazekri.omikuji;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
@Controller
public class MainController {
	
	@RequestMapping("/")
    public String home() {		
		
			return "index.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String index(HttpSession session, 
    		@RequestParam(value="number") String number,
    	    @RequestParam(value="city") String city,
    	    @RequestParam(value="person") String person,
    	    @RequestParam(value="profession") String profession,
    	    @RequestParam(value="living") String living,
    	    @RequestParam(value="word") String word ) {		
		
		String resultOmikuji = String.format(
				"In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, profession, living, word);
		
			session.setAttribute("result",resultOmikuji);					

			return "redirect:/welcome";
		
	}
    

	@RequestMapping("/welcome")
	public String welcome(Model model,HttpSession session) {	
		model.addAttribute("result",(String) session.getAttribute("result"));
		
        return "welcome.jsp";
    }
}
