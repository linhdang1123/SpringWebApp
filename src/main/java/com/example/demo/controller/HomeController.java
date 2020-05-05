package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class HomeController {
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}


}
