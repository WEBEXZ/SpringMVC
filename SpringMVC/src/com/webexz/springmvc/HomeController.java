package com.webexz.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
	public String showHome(HttpServletRequest req, Model model) {
		if(req.getParameter("user").equals("admin") && req.getParameter("password").equals("admin")) {
			model.addAttribute("user", req.getParameter("user"));
			return "home";
		} else {
			return showPage();
		}
	}
}