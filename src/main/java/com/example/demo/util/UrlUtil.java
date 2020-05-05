package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;

@Configuration
public class UrlUtil {
	@Autowired
	UserDAO userDAO;
    public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.isAuthenticated()) {
		    String name = auth.getName(); //get logged in username
		    User user = userDAO.findUser(name);
		    return getLocalPart(user.getEmail());
		}
		return "";
    }
	public String getLocalPart(String email) {
		int index = email.indexOf("@");
		return index < 0 ? email : email.substring(0, email.indexOf("@"));
	}
}