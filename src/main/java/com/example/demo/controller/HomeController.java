package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.dao.UserDAO;

@Controller
@Transactional
public class HomeController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	public ModelAndView home(ModelMap model) {
		return new ModelAndView("home");
	}
	@RequestMapping("/index")
	public ModelAndView index(ModelMap model) {

		return new ModelAndView("index");
	}



}
