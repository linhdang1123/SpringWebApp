package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {
	private int orderNum;
	private final List<CartItemDetails> cartItems = new ArrayList<>();
	public CartInfo() {
		
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public List<CartItemDetails> getCartItems() {
		return cartItems;
	}
	private CartItemDetails findCartItemByCode(int code) {
		for(CartItemDetails item : this.cartItems) {
			if(item.getItemDetails().getCode() == code) return item;
		}
		return null;
	}
	public void addProduct(ItemDetails itemDetails, int quantity) {
		CartItemDetails cartItem = this.findCartItemByCode(itemDetails.getCode());
		if(cartItem == null) {
			cartItem = new CartItemDetails();
			cartItem.setQuantity(0);
			cartItem.setItemDetails(itemDetails);
			this.cartItems.add(cartItem);
			
		}
		int newQuantity = cartItem.getQuantity() + quantity;
		if(newQuantity <= 0) {
			this.cartItems.remove(cartItem);
		}else {
			cartItem.setQuantity(newQuantity);
		}
	}
	public boolean isEmpty() {
		return this.cartItems.isEmpty();
	}
	public double getTotalAmount() {
		double amount = 0;
		for(CartItemDetails item : cartItems) {
			amount+=item.getAmount();
		}
		return amount;
	}
	public int getTotalQuantity() {
		int quantity = 0;
		for(CartItemDetails item : cartItems) {
			quantity+=item.getQuantity();
		}
		return quantity;
	}

}
