package com.example.demo.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Entity
public class Item {
	@Id
	private int itemID;
	
	private String image;
	private String category;
	private String categorySubfield;
	private String categorySubsubfield;
	private String name;
	private double price;
	private String description;
	private String date;
	
	public void setItemID(int id) {
		this.itemID=id;
	}
	public String getImage( ) {
		return image;
	}
	public void setImage(String image) {
		this.image=image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategorySubfield() {
		return categorySubfield;
	}
	public void setCategorySubfield(String categorySubfield) {
		this.categorySubfield = categorySubfield;
	}
	public String getCategorySubsubfield() {
		return categorySubsubfield;
	}
	public void setCategorySubsubfield(String categorySubsubfield) {
		this.categorySubsubfield = categorySubsubfield;
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
	public String getDate() {
		Date theDate = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String date = dateFormat.format(theDate);  
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
