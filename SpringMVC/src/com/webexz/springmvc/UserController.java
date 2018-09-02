package com.webexz.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("user") User user) {
		System.out.println("User" + user.getUserName() 
							+ " " + user.getPassword() 
							+ " " + user.getRole()
							+ " " + user.getStatus());
		System.out.println("User use: ");
		for (String use : user.getUses()) {
			System.out.println(use);
		}
		return "confirmation";
	}
}
