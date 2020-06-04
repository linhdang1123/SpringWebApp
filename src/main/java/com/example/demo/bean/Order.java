package com.example.demo.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders", uniqueConstraints = { @UniqueConstraint(columnNames = "order_num") })
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1835021583969266196L;
	@Id
	@Column(name = "ID", length = 100, nullable = false)
	private String id;
	
	@Column(name = "order_num", length = 11, nullable = false)
	private int orderNum;
	
	@OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_info_id", nullable = false, //
	            foreignKey = @ForeignKey(name = "customer_info_id"))
	private CustomerInfo customerInfo;
	
	@Column(name = "amount",nullable = false)
	private double amount;
	
	@Column(name = "promocode", length = 40)
	private String promocode;
	
	@Column(name = "order_date", nullable = false)
	private Date orderDate;
	
	
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	

}
