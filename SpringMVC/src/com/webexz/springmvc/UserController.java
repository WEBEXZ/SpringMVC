package com.webexz.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		System.out.println("User" + user.getUserName() 
							+ " " + user.getPassword() 
							+ " " + user.getRole()
							+ " " + user.getStatus());
		System.out.println("User use: ");
		for (String use : user.getUses()) {
			System.out.println(use);
		}
		
		return bindingResult.hasErrors() ? "userForm":"confirmation";
	}
}
