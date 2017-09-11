package com.prakash.hibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name="User_Details")
public class UserDetails {
	@Id  				// Indicate that this field act as a primary id in table  
	@Column (name="User_Id")  // Explicitly indicate the table name
	@GeneratedValue(strategy=GenerationType.AUTO) // Set that this ID will be auto incremented.
	private int userId;

	@Column (name = "User_Name")
	private String userName;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	public Date getDate() {
	    return getDate();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
