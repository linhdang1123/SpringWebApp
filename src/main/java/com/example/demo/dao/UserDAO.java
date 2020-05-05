package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.User;
@Transactional
@Repository
public class UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public User findUser(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.find(User.class, email);
		
	}

}
