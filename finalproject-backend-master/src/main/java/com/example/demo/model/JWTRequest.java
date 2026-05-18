package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class JWTRequest {	
	
	private String emailid;
	private String password;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JWTRequest(String emailid, String password) {
		super();
		this.emailid = emailid;
		this.password = password;
	}
	public JWTRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JWTRequest [emailid=" + emailid + ", password=" + password + "]";
	}
	
}
