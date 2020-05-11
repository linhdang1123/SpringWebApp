package com.example.demo.form;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Calendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ItemForm {

	private int code;
	private CommonsMultipartFile image;
	private String category;
	private String subcategory;
	private String subsubcategory;
	private String name;
	private double price;
	private String description;
	private String create_date;
	
	public int genCode() {
		Random random=new Random();
		return random.nextInt(999);
	}
	public int getCode() {
		if (code==0) {
			this.code=genCode();
		}
		return this.code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public CommonsMultipartFile getImage( ) {
		return image;
	}
	public void setImage(CommonsMultipartFile image) {
		this.image=image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getSubsubcategory() {
		return subsubcategory;
	}
	public void setSubsubcategory(String subsubcategory) {
		this.subsubcategory = subsubcategory;
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
	public String getCreate_date() {
		Date theDate = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String create_date = dateFormat.format(theDate);  
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	


}
