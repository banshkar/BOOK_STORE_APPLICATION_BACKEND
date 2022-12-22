package com.bridgelabz.models;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class User {
       @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private int id ;
	   private String name;
	   private String email;
	   private String password;
	   private String moblieNumber;
	   private String street;
	   private String landMark;
	   private String city;
	   private String pinCode;
	   private String state;
	   private boolean isLogin =false;
	   private String role;
	   private boolean orderStatus=false;
	   @OneToMany(cascade = CascadeType.ALL)
	   @JoinColumn(name="cart_id")
	  private List<Cart>cart;
	  
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String password, String moblieNumber, String street, String landMark,
			String city, String pinCode, String state, boolean isLogin, String role, boolean orderStatus,
			List<Cart> cart) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.moblieNumber = moblieNumber;
		this.street = street;
		this.landMark = landMark;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.isLogin = isLogin;
		this.role = role;
		this.orderStatus = orderStatus;
		this.cart = cart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", moblieNumber="
				+ moblieNumber + ", street=" + street + ", landMark=" + landMark + ", city=" + city + ", pinCode="
				+ pinCode + ", state=" + state + ", isLogin=" + isLogin + ", role=" + role + ", orderStatus="
				+ orderStatus + ", cart=" + cart + "]";
	}
	  
}
