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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.demo.bean.Item;
import com.example.demo.bean.User;
import com.example.demo.form.ItemForm;
@Transactional
@Repository
public class ItemDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(ItemForm itemForm) {
		  Session session = this.sessionFactory.getCurrentSession();
		  Item item = new Item();
		  CommonsMultipartFile image=itemForm.getImage();
		  item.setImage(image.getBytes());
		  item.setCategory(itemForm.getCategory());
		  item.setName(itemForm.getName());
		  item.setPrice(itemForm.getPrice());
		  item.setSubcategory(itemForm.getSubcategory());
		  item.setSubsubcategory(itemForm.getSubsubcategory());
		  item.setDescription(itemForm.getDescription());
		  item.setCode(itemForm.getCode());
		  item.setCreate_date(itemForm.getCreate_date());
		  System.out.println("in dao");
		  session.save(item);
		
	}
	public Item findItem(int code) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.find(Item.class, code);
		
	}

}
