package com.example.demo.Model;

public class CartItemDetails {
	private ItemDetails itemDetails;
	private int quantity;
	public CartItemDetails() {
		this.quantity = 0;
	}
	public ItemDetails getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return this.quantity*this.itemDetails.getPrice();
	}
	
}
