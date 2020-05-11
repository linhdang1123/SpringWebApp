package com.example.demo.bean;

import java.io.Serializable;
import java.util.Collection;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "items")
public class Item  implements Serializable {
	/**
	 * 
	 */
//	private static final long serialVersionUID = -5867078771628737366L;
//	public static final String ROLE_SELLER = "SELLER";
//    public static final String ROLE_ADMIN = "ADMIN";
 
    @Id
    @Column(name = "code", length = 20, nullable = false)
    private int code;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "price", length = 50, nullable = false)
    private double price;
    @Column(name = "description", length = 500, nullable = false)
    private String description;
    @Column(name = "create_date", length = 100, nullable = false)
    private String create_date;
    @Column(name = "rating", length = 11, nullable = true)
    private int rating;
    @Column(name = "category", length = 45, nullable = false)
    private String category;
    @Column(name = "subcategory", length = 45, nullable = false)
    private String subcategory;
    @Column(name = "subsubcategory", length = 45, nullable = true)
    private String subsubcategory;
    @Column(name = "image", length = 1000, nullable=false)
	private byte[] image;
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
	public String getCreate_date() { 
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
 
    
}