package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="promocode")
public class PromoCode {
	@Id
	@Column(name = "code",length = 20, nullable = false)
	private String code;
	@Column(name = "value", nullable = false)
	private double value;
	@Column(name = "create_date", length = 100, nullable = false)
	private String create_date;
	public PromoCode(String code, double value, String date) {
		this.code = code;
		this.create_date = date;
		this.value = value;
	}
	public PromoCode() {
		
	}
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	@Override public int hashCode() { 
		return this.code.hashCode();
	}
	@Override public boolean equals(Object o) { 
		if(o.getClass() != this.getClass() || o == null) return false;
		if(this == o) return true;
		PromoCode code = (PromoCode) o;
		return code.getCode().equals(this.getCode());
	}
}
