package com.example.demo.Model;

import javax.persistence.Column;

import com.example.demo.bean.Item;

public class ItemDetails {
	 private int code;
	 private String name;
	 private double price;
	 private String description;
	 private int rating;
	 public ItemDetails() {
		 
	 }
	 //Constructor for JPA/Query
	 public ItemDetails(int code, String name, double price, String description, int rating) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.rating = rating;
	}
	public ItemDetails(Item item) {
		 this.code = item.getCode();
		 this.name = item.getName();
		 this.price = item.getPrice();
		 this.description = item.getDescription();
		 this.rating = item.getRating();		 
	 }
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
