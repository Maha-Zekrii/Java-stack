package com.mahazekri.fruity;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class MainController {
	
	@RequestMapping("/")
    public String index(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			}
			else {
				session.setAttribute("count", (int)session.getAttribute("count")+ 1);			}
			return "index.jsp";
		
        
    }

	@RequestMapping("/welcome")
    public String welcome() {
		
		
        return "welcome.jsp";
    }
}
