package com.capgemini.store.beans;

import java.util.ArrayList;
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
public class Wishlist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wishListId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="phoneNumber")
	private Customer customer;// one to one
	@OneToMany(mappedBy="wishlist",cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();// one to many
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Wishlist(int wishListId, Customer customer, List<Product> products) {
		super();
		this.wishListId = wishListId;
		this.customer = customer;
		this.products = products;
	}
	public Wishlist() {
		super();
	}
	
}
