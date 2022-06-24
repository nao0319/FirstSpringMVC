package com.example.first.form;

import java.io.Serializable;

public class SampleForm implements Serializable {
	private String user;
	private String address;
	
	//constracta
	public SampleForm() {
	}
	
	public SampleForm(String user,String address) {
		this.user = user;
		this.address = address;
	}

	//setter,getter
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
