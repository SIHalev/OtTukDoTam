package models;

import javax.persistence.Entity;

@Entity
public class User {
	public String email;
	public String password;
	
	public User() { }

    public User(String email, String password) {
    	this.email = email;
		this.password = password;
    }	
}