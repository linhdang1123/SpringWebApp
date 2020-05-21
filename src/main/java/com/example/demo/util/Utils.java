package com.example.demo.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.Model.CartInfo;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;

public class Utils {
	public static CartInfo getCartInSession(HttpServletRequest request) {
		
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
		if(cartInfo == null) {
			cartInfo = new CartInfo();
			request.getSession().setAttribute("myCart", cartInfo);
		}
		return cartInfo;
		
	}
	
}