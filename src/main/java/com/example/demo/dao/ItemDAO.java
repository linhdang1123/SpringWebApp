package com.example.demo.dao;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.demo.Model.ItemDetails;
import com.example.demo.bean.Item;
import com.example.demo.bean.User;
import com.example.demo.form.ItemForm;
import com.example.demo.pagination.PaginationResult;
@Transactional
@Repository
public class ItemDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(ItemForm itemForm) throws IOException {
		  Session session = this.sessionFactory.getCurrentSession();
		  Item item = new Item();
		  MultipartFile image=itemForm.getImage();
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

/*	public Item getItem(int code){
		String sql = "Select new " + Item.class.getName() 
				+ " from " 
				+ Item.class.getName() 
				+ " where item=:code ";
		if(likeName != null && likeName.length() > 0) sql += " where lower(item.name) like :likeName";
		sql+="order by item.create_date desc";
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here");
		Query<ItemDetails> query = session.createQuery(sql,ItemDetails.class);
		System.out.println("in item DAO");
		System.out.println("Query : " + query);
		if(likeName != null && likeName.length() > 0) query.setParameter("likeName", "%" +  likeName.toLowerCase() + "%");
		System.out.println("SQL : " + sql);
		return new PaginationResult<ItemDetails>(query, page, maxResult, maxNavigationPage);
	
	}*/
	
	public ItemDetails getItemDetails(int code) {
		Item item = findItem(code);
		return item == null ? null : new ItemDetails(item);
	}
	public PaginationResult<ItemDetails> queryProducts(int page, int maxResult, int maxNavigationPage,
            String likeName){
		String sql = "Select new " + ItemDetails.class.getName() 
				+ "(item.code, item.name, item.price, item.description, item.rating) from " 
				+ Item.class.getName() 
				+ " item ";
		if(likeName != null && likeName.length() > 0) sql += " where lower(item.name) like :likeName ";
		sql+="order by item.create_date desc";
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here");
		Query<ItemDetails> query = session.createQuery(sql,ItemDetails.class);
		System.out.println("in item DAO");
		System.out.println("Query : " + query);
		if(likeName != null && likeName.length() > 0) query.setParameter("likeName", "%" +  likeName.toLowerCase() + "%");
		System.out.println("SQL : " + sql);
		return new PaginationResult<ItemDetails>(query, page, maxResult, maxNavigationPage);
	
	}
	public PaginationResult<ItemDetails> queryProducts(int page, int maxResult, int maxNavigationPage){
		return queryProducts(page, maxResult, maxNavigationPage, null);
	}
	public void updateName(String name,int code){
		String sql="UPDATE "+ Item.class.getName() +" Item SET Item.name=:name WHERE Item.code=:code";

		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here");
		session.createQuery(sql).setParameter("name", name).setParameter("code", code).executeUpdate();
		
		System.out.println("in item DAO");
		System.out.println("SQL : " + sql);
		
	
	}
	public void updateDescription(String description,int code){
		String sql="UPDATE "+ Item.class.getName() +" Item SET Item.description=:description WHERE Item.code=:code";

		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here");
		session.createQuery(sql).setParameter("description", description).setParameter("code", code).executeUpdate();
		
		System.out.println("in item DAO");
		System.out.println("SQL : " + sql);
	
	}
	public void updatePrice(double price,int code){
		String sql="UPDATE "+ Item.class.getName() +" Item SET Item.price=:price WHERE Item.code=:code";

		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here");
		session.createQuery(sql).setParameter("price", price).setParameter("code", code).executeUpdate();
		
		System.out.println("in item DAO");
		System.out.println("SQL : " + sql);
	
	}
	public PaginationResult<ItemDetails> queryProductsByType(int page, int maxResult, int maxNavigationPage,
            String ctype,String stype){
		String sql = "Select new " + ItemDetails.class.getName() 
				+ "(item.code, item.name, item.price, item.description, item.rating) from " 
				+ Item.class.getName() 
				+ " item ";
				if(ctype.equals("xxx")) sql += "where item.subcategory=:stype ";
				else if(stype.equals("xxx")) sql += "where item.category=:ctype ";
		sql+="order by item.create_date desc";
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here     ctype     stype"+ctype+stype);
		Query<ItemDetails> query = session.createQuery(sql,ItemDetails.class);
		System.out.println("in item DAO");
		System.out.println("Query : " + query);
		if(ctype.equals("xxx")) query.setParameter("stype", stype.toLowerCase());
		else if(stype.equals("xxx")) query.setParameter("ctype", ctype.toLowerCase());
		System.out.println("SQL : " + sql);
		return new PaginationResult<ItemDetails>(query, page, maxResult, maxNavigationPage);
	
	}

}
