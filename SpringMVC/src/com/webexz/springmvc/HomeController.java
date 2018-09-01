package com.webexz.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/webApp")
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "start";
	}
	
	@RequestMapping("/login") 
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String showHome(@RequestParam("user") String user, 
			@RequestParam("password") String password, 
			Model model) {
		if(user.equals("admin") && password.equals("admin")) {
			model.addAttribute("user", user);
			return "home";
		} else {
			return showPage();
		}
	}
}