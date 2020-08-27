package com.app.core;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private String name;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private CustomerType custType;
	private double regAmount;
	private ShippingAddress shippingAddress;
	
	public Customer(String name, String email, String password, LocalDate dateOfBirth, CustomerType custType, double regAmount) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.custType = custType;
		this.regAmount = regAmount;
	}

	public Customer(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Customer) {
			if(this.email.equals(((Customer) obj).email)){
				return true;
			}
		}
		return false;
	
	}
	
	@Override
	public int hashCode() {
		System.out.println(this.email.hashCode());
		return this.email.hashCode();
	}
	
	public CustomerType getCustType() {
		return custType;
	}

	@Override
	public int compareTo(Customer c) {
		System.out.println("In compare to ");
		
		if(this.email.compareTo(c.email) < 0) {
			return -1;
		}
		if(this.email.compareTo(c.email) == 0) {
				return 0;
			}
		return 1;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Customer name=" + name + ", email=" + email + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", custType=" + custType + ", regAmount=" + regAmount +  "\n Shipping Address : " + shippingAddress;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void linkCustomerAddress(ShippingAddress sh,String[] ph) {
		this.shippingAddress = sh;
		this.shippingAddress.setPhoneNumbers(ph);
	}
	
	
	
	
}
