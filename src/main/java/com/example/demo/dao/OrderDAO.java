package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.CartInfo;
import com.example.demo.Model.CartItemDetails;
import com.example.demo.bean.CustomerInfo;
import com.example.demo.bean.Order;
import com.example.demo.bean.OrderDetails;

@Transactional
@Repository
public class OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ItemDAO itemDAO;
	
	private int getMaxOrderNum() {
		String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o";
		System.out.println("sql is getMax numorder : " + sql);
		Session session = this.sessionFactory.getCurrentSession();
		Query<Integer> query = session.createQuery(sql, Integer.class);
		Integer value = (Integer) query.getSingleResult();
		return value == null ? 111111111 : value;		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveOrder(CartInfo cartInfo) {
		System.out.println("in saveOrder");
		Session session = this.sessionFactory.getCurrentSession();
		int orderNum = this.getMaxOrderNum() + 1;
		System.out.println("order number : " + orderNum);
		
		CustomerInfo customerInfo = new CustomerInfo();
		
		customerInfo.setId(UUID.randomUUID().toString());
		customerInfo.setBillingAddress(cartInfo.getCustomerInfo().getBillingAddress().toString());
		customerInfo.setShippingAddress(cartInfo.getCustomerInfo().getShippingAddress().toString());
		customerInfo.setCardName(cartInfo.getCustomerInfo().getCardName());
		customerInfo.setCardNumber(cartInfo.getCustomerInfo().getCardNumber());
		customerInfo.setCvv(cartInfo.getCustomerInfo().getCvv());
		customerInfo.setExpMonth(cartInfo.getCustomerInfo().getExpMonth());
		customerInfo.setExpYear(cartInfo.getCustomerInfo().getExpYear());
		customerInfo.setEmail(cartInfo.getCustomerInfo().getBillingAddress().getEmail());
		customerInfo.setPhoneNumber(cartInfo.getCustomerInfo().getShippingAddress().getPhoneNumber());
		
		session.persist(customerInfo);
		System.out.println("line 57 ");
		System.out.println(customerInfo);
		Order order = new Order();
		
		order.setId(UUID.randomUUID().toString());
		order.setAmount(cartInfo.getTotalAmount());
		order.setOrderNum(orderNum + 1);
		order.setOrderDate(new Date());
		order.setCustomerInfo(customerInfo);
		
		session.persist(order);
		System.out.println("line 70 ");
		
		List<CartItemDetails> lines = cartInfo.getCartItems();
		for(CartItemDetails line : lines) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setId(UUID.randomUUID().toString());
			orderDetails.setOrder(order);
			orderDetails.setAmount(line.getAmount());
			orderDetails.setPrice(line.getItemDetails().getPrice());
			orderDetails.setQuantity(line.getQuantity());
			orderDetails.setItem(this.itemDAO.findItem(line.getItemDetails().getCode()));
			session.persist(orderDetails);
			System.out.println("here");
			
		}
		
		//set Order Number 
		cartInfo.setOrderNum(orderNum);
		
		// Flush
		session.flush();
		
		
		
	}
	
	
	

}
