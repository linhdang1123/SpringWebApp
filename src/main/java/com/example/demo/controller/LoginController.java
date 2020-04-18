package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRepo;

@Controller
public class LoginController {
	@Autowired
	UserRepo repo;
	
	@RequestMapping("/SignIn")
	public ModelAndView signIn(@RequestParam String email, @RequestParam String passWord ) {
		ModelAndView mv = new ModelAndView();
		User user = repo.findByEmail(email);
		if(user == null || !user.getPassWord().equals(passWord)) {
			mv.setViewName("login");
			mv.addObject("message", "Invalid email/Password !");
		}else{
			mv.setViewName("home");
			mv.addObject("user", user.getFirstName());
			mv.addObject("login", "Hi " + user.getFirstName());
			mv.addObject("signup", "");
			//mv.addObject("message", "hi" + user.getfirstname());
			
		}
		
		return mv;
	}
	
}
