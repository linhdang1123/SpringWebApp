package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.ItemDetails;
import com.example.demo.bean.Item;
import com.example.demo.bean.Seller_Item;
import com.example.demo.form.Seller_ItemForm;
import com.example.demo.pagination.PaginationResult;
@Transactional
@Repository
public class Seller_ItemDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(Seller_ItemForm seller_itemForm) {
		  Session session = this.sessionFactory.getCurrentSession();
		  Seller_Item seller_item = new Seller_Item();
		  seller_item.setId(seller_itemForm.getId());
		  seller_item.setUser_email(seller_itemForm.getUser_email());
		  seller_item.setItem_code(seller_itemForm.getItem_code()); 
		  System.out.println("in dao");
		  session.save(seller_item);
		
	}
	
	public PaginationResult<ItemDetails> querySellerItems(int page, int maxResult, int maxNavigationPage,
            String email){
		String sql="Select new " + ItemDetails.class.getName() 
				+ "(items.code, items.name, items.price, items.description, items.rating) from "
				+Seller_Item.class.getName()+" si join "+Item.class.getName()+" items on si.item_code=items.code"+ 
				" where si.user_email= :email";
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("here");
		Query<ItemDetails> query = session.createQuery(sql,ItemDetails.class).setParameter("email", email);
		System.out.println("in item DAO");
		System.out.println("Query : " + query);
		System.out.println("SQL : " + sql);
		return new PaginationResult<ItemDetails>(query, page, maxResult, maxNavigationPage);
	
	}

}
