package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.PromoCodeField;
import com.example.demo.bean.PromoCode;

@Transactional
@Repository
public class PromoCodeDAO {
	@Autowired
	SessionFactory sessionFactory;
	public PromoCode findPromoCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(PromoCode.class, code);
	}
	public PromoCodeField toPromoCodeField(PromoCode promoCode) {
		return new PromoCodeField(promoCode);
	}
}