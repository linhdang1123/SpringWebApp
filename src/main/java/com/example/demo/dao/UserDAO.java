package com.example.demo.dao;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.User;
import com.example.demo.form.UserForm;
@Transactional
@Repository
public class UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public User findUser(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.find(User.class, email);
		
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(UserForm userForm) {
		  Session session = this.sessionFactory.getCurrentSession();
		  String email = userForm.getEmail();
		  User user = null;
		  if(email != null) {
			  user = this.findUser(email);
			  if(user != null) throw new UsernameNotFoundException("User already Exists");
			  
		  }
		  user = new User();
		  user.setEmail(userForm.getEmail());
		  user.setEncrytedPassword(passwordEncoder.encode(userForm.getPassword()));
		  user.setActive(true);
		  user.setUserRole("ROLE_SELLER");
		  System.out.println("in dao");
		  session.save(user);
		
	}

}
