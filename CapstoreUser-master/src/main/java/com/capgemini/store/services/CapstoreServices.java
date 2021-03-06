package com.capgemini.store.services;

import java.util.Date;
import java.util.List;

import javax.activity.InvalidActivityException;

import com.capgemini.store.beans.Address;
import com.capgemini.store.beans.Cart;
import com.capgemini.store.beans.Category;
import com.capgemini.store.beans.Customer;
import com.capgemini.store.beans.Orders;
import com.capgemini.store.beans.Product;
import com.capgemini.store.beans.Review;
import com.capgemini.store.exceptions.CustomerNotFoundException;
import com.capgemini.store.exceptions.InvalidInputException;
import com.capgemini.store.exceptions.ProductUnavailableException;

public interface CapstoreServices {

	public Orders getTransaction(int orderId) throws InvalidInputException;
	public Product searchByProductName(String productName)  throws InvalidInputException;
	//naya wala methods
	public Customer customerSignIn(String email,String password) throws InvalidInputException;
	public Customer getCustomerDetails(String phoneNumber) throws InvalidInputException;
	public List<Product> getAllProducts() throws InvalidInputException  ;
	public Product getProductById(int productId) throws InvalidInputException;
	public List<Product> getProductByCategory(Category category) throws InvalidInputException;
	public void setReviewMethod(String phoneNumber,int rating,String comments,int productId) throws InvalidInputException;
	public String getDeliveryStatus(int orderId) throws InvalidInputException;
	public boolean addProductToWishlist(String phoneNumber,int productId) throws InvalidInputException;
	public boolean removeProductFromWishlist(String phoneNumber,int productId) throws InvalidInputException;
	public List<Product> getWishlist(String phoneNumber) throws InvalidInputException;
	public boolean updateSecurityQuestion(String phoneNumber,String securityQuestion) throws InvalidInputException;
	public boolean updateSecurityAnswer(String phoneNumber,String securityAnswer) throws InvalidInputException;
	public boolean updateCardNumber(String phoneNumber,String cardNumber)throws InvalidInputException;
	public boolean updateCustomerName(String phoneNumber,String customerName)throws InvalidInputException;
	public List<Product> getAllProductsFromCart(String phoneNumber) throws InvalidInputException;
	Customer signUp(Customer customer);
	String forgotPassword(String mobileNumber) throws CustomerNotFoundException;
	String securityQuestion(String phoneNumber,String securityAnswer) throws InvalidInputException;
	void onlinePayment(String cardNumber, String customerPhoneNumber);
	void buyNowProduct(int productId, String phoneNumber, int quantity);
	void buyNowCart(String phoneNumber) throws ProductUnavailableException;
	Cart addProductToNewCart(String phoneNumber,int productId, int quantity) throws ProductUnavailableException;
	Cart updateCart(String phoneNumber,int productId, int quantity) throws ProductUnavailableException;
	Cart removeProductFromCart(String phoneNumber,int productId);//once removed from cart, update stock & quantity in product
//	void updateQuantity(int productId, int quantityOrdered, int orderId);
	void addAddress(Address address);
	Address getAddress(int addressId);
	double applyDiscount(int productId);     
	double applyCoupon(int cartId);
	public boolean changePassword(String phoneNumber,String newPassword)throws InvalidInputException, CustomerNotFoundException;
	public List<Orders> getAllOrders(String phoneNumber)throws CustomerNotFoundException;
	public boolean returnGoods(int orderId);
	public int averageRating(int productId);
}
