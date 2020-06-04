package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5867078771628737366L;
	public static final String ROLE_SELLER = "SELLER";
    public static final String ROLE_ADMIN = "ADMIN";
 
    @Id
    @Column(name = "email", length = 20, nullable = false)
    private String email;
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;
 
    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;
 
    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;

 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
	public String getLocalPart(String email) {
		int index = email.indexOf("@");
		return index < 0 ? email : email.substring(0, email.indexOf("@"));
	}
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
 
    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
 
    public String getUserRole() {
        return userRole;
    }
 
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
 
    @Override
    public String toString() {
        return "[" + this.email + "," + this.encrytedPassword + "," + this.userRole + "]";
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}