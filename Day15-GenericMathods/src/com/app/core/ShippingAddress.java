package com.app.core;

import java.util.Arrays;

//import java.util.Arrays;

public class ShippingAddress {
	private String city;
	private String state;
	private String country;
	private int zipCode;
	private String[] phoneNumbers;
	public ShippingAddress(String city, String state, String country, int zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		//this.phoneNumbers = phoneNumbers;
	}
	
	

	@Override
	public String toString() {
		return "ShippingAddress [city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode
				+ ", phoneNumbers=" + Arrays.toString(phoneNumbers) + "]";
	}



	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
}
