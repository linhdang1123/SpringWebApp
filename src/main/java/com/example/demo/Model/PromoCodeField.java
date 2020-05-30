package com.example.demo.Model;

import com.example.demo.bean.PromoCode;

public class PromoCodeField{
	private String promoCode;
	private double value;
	public PromoCodeField() {
		
	}
	public PromoCodeField(PromoCode promoCode) {
		this.promoCode = promoCode.getCode();
		this.value = promoCode.getValue();
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
}
