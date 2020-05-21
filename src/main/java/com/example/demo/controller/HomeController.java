package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.CartInfo;
import com.example.demo.bean.Item;
import com.example.demo.dao.UserDAO;
import com.example.demo.util.Utils;

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
	@RequestMapping("/body")
	public ModelAndView body(ModelMap model) {
		return new ModelAndView("body");
	}
	@RequestMapping(value = {"/cartQuantity"}, method = RequestMethod.GET)
	public void itemImage(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		CartInfo cartInfo = Utils.getCartInSession(request);
		if(cartInfo != null) {
			int quantity = cartInfo.getTotalQuantity();
			response.getOutputStream().write(quantity);
		}
		response.getOutputStream().close();	
	}


}
