package com.example.demo.controller;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRepo;



@Controller
public class SignUpController {
	@Autowired
	UserRepo repo;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/addUser")
	public ModelAndView addUser(User user) {
		Random random = new Random();
		user.setUserId(random.nextInt(999));
		user.setUserName(user.getFirstName() + user.getLastName() + user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup_success");
		mv.addObject("user", user);
		repo.save(user);
		return mv;
	}
}
