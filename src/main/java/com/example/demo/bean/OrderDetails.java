package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7224263914743084287L;
	@Id
	@Column(name = "ID", length = 100, nullable = false)
	private String id;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "price", nullable = false)
	private double price;
	@Column(name = "quantity", nullable = false)
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id", nullable = false, //
	            foreignKey = @ForeignKey(name = "order_id"))
	private Order order;
	 
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "item_id", nullable = false, //
				foreignKey = @ForeignKey(name = "item_id"))
	private Item item;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	

}
