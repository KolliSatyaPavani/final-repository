package com.capgemini.store.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	// changed
	@JoinColumn(name="phoneNumber")
	String phoneNumber;
	private String country;
	private String state;
	private String city;
	private int zipcode;
	private String addressLine1;
	private String addressLine2;

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public Address() {}
	
	public Address(String country, String state, String city, int zipcode,
			String addressLine1, String addressLine2) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + "]";
	}

	
	

}
