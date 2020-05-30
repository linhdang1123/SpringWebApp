package com.example.demo.Model;

public class CustomerInfo {
	private Address billingAddress ;
	private Address shippingAddress ;
	private String cardName;
	private String cardNumber;
	private String expMonth;
	private String expYear;
	private String cvv;
	private boolean sameAddress;
	
	public CustomerInfo( Address billingAddress, Address shippingAddress,
			String cardname, String cardNumber, String expMonth,String expYear, String cvv) {
		this.cardName = cardname;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}
	public CustomerInfo() {
	}
	
	public boolean isSameAddress() {
		return sameAddress;
	}
	public void setSameAddress(boolean sameAddress) {
		this.sameAddress = sameAddress;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Address getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
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

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}






	
	
	

}
