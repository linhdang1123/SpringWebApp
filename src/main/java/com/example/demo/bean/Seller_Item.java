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
@Table(name = "seller_items")
public class Seller_Item  implements Serializable {
	/**
	 * 
	 */
//	private static final long serialVersionUID = -5867078771628737366L;
//	public static final String ROLE_SELLER = "SELLER";
//    public static final String ROLE_ADMIN = "ADMIN";
 
    @Id
    @Column(name = "id", length = 11, nullable = false)
    private int id;
    @Column(name = "user_email", length = 20, nullable = false)
    private String user_email;
    @Column(name = "item_code", length = 20, nullable = false)
    private int item_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
    
 
    
}