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
	
	@RequestMapping("/login")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form");
		return mv;
	}
	@RequestMapping("/addUser")
	public ModelAndView addUser(User user) {
		Random random = new Random();
		user.setUserId(random.nextInt(999));
		user.setUserName(user.getFirstName() + user.getLastName() + user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		String message = "You now have an account, let's shop!";
		mv.addObject("message", message);
		repo.save(user);
		return mv;
	}
}
