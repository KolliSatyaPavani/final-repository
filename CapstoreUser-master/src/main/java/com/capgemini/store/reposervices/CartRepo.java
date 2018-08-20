package com.capgemini.store.reposervices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.store.beans.Cart;
import com.capgemini.store.beans.Customer;

public interface CartRepo extends JpaRepository<Cart, Integer>{
	public Cart findByCustomer(Customer customer);
}
