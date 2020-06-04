package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
public class CustomerInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2876750696176460154L;
	@Id
	@Column(name = "ID", length = 50, nullable = false)
	private String id;
	@Column(name = "card_name", length = 45, nullable = false)
	private String cardName;
	@Column(name = "card_number", length = 45, nullable = false)
	private String cardNumber;
	@Column(name = "card_exp_month", length = 2, nullable = false)
	private String expMonth;
	@Column(name = "card_exp_year", length = 4, nullable = false)
	private String expYear;
	@Column(name = "card_cvv", length = 2, nullable = false)
	private String cvv;
	@Column(name = "billing_address", length = 500, nullable = false)
	private String billingAddress;
	@Column(name = "shipping_address", length = 500, nullable = false)
	private String shippingAddress;
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	@Column(name = "phone_number", length = 12, nullable = false)
	private String phoneNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	public String getExpYear() {
		return expYear;
	}
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expMonth="
				+ expMonth + ", expYear=" + expYear + ", cvv=" + cvv + ", billingAddress=" + billingAddress
				+ ", shippingAddress=" + shippingAddress + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

}
