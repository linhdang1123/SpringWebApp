package com.example.demo.form;

import java.util.Random;


public class Seller_ItemForm {
	private int id;
	private String user_email;
	private int item_code;
	public Seller_ItemForm() {
		
	}
	public Seller_ItemForm(Seller_ItemForm form) {
		if(form != null) {
			this.id = form.id;
			this.user_email = form.user_email;
			this.item_code = form.item_code;
		}
	}
	public Seller_ItemForm(int id,String user_email,int item_code) {
		this.id = id;
		this.user_email = user_email;
		this.item_code = item_code;
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
	public int genId() {
		Random random=new Random();
		return random.nextInt(999);
	}
	public int getId() {
		if (id==0) {
			this.id=genId();
		}
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
