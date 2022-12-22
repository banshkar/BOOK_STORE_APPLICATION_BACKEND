package com.bridgelabz.dto;

import java.util.List;

import com.bridgelabz.models.Cart;

public class RegisterDto {
	  private String name;
	   private String email;
	   private String password;
	   private String moblieNumber;
	   private String street;
	   private String landMark;
	   private String city;
	   private String pinCode;
	   private String state;
	 public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
 	}


	public RegisterDto(String name, String email, String password, String moblieNumber, String street, String landMark,
			String city, String pinCode, String state) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.moblieNumber = moblieNumber;
		this.street = street;
		this.landMark = landMark;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMoblieNumber() {
		return moblieNumber;
	}
	public void setMoblieNumber(String moblieNumber) {
		this.moblieNumber = moblieNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "RegisterDto [name=" + name + ", email=" + email + ", password=" + password + ", moblieNumber="
				+ moblieNumber + ", street=" + street + ", landMark=" + landMark + ", city=" + city + ", pinCode="
				+ pinCode + ", state=" + state + "]";
	}
	
	
	

}
