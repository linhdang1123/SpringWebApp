package com.example.demo.Model;


public class Address {
	private String name;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	

	public Address(String name, String email, String phoneNumber, String address, String city, String state, String zipCode) {
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address() {
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode ;
	}


	
	
	

}
