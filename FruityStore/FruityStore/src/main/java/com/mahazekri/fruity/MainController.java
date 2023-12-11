package com.mahazekri.fruity;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
    public String index(Model model) {
		 ArrayList<Item> fruits = new ArrayList<Item>();
		 fruits.add(new Item("Banana",56));
		 fruits.add(new Item("kiwi",20));
		 fruits.add(new Item("orange",30));
	        model.addAttribute("fruits", fruits);
        return "index.jsp";
    }

}
