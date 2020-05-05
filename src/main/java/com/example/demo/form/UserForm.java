package com.example.demo.form;

public class UserForm {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	public UserForm() {
		
	}
	public UserForm(UserForm form) {
		if(form != null) {
			this.email = form.email;
			this.password = form.password;
			this.firstName = form.firstName;
			this.lastName = form.lastName;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String toString() {
		return this.firstName + ", " + this.lastName + ", " + this.email;
		
	}

}
