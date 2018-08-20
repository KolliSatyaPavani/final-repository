package com.capgemini.store.controllers;

import java.lang.ref.PhantomReference;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.store.beans.Address;
import com.capgemini.store.beans.Cart;
import com.capgemini.store.beans.Category;
import com.capgemini.store.beans.Customer;
import com.capgemini.store.beans.Product;
import com.capgemini.store.exceptions.CustomerNotFoundException;
import com.capgemini.store.exceptions.InvalidInputException;
import com.capgemini.store.exceptions.ProductUnavailableException;
import com.capgemini.store.services.CapstoreServices;

@RestController
public class RestController1 {
	// String phoneNumber;
	public Customer customer;
	@Autowired
	private CapstoreServices capstoreServices;

	// Customer SignUp
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public void signUp(@RequestBody Customer customer) {
		capstoreServices.signUp(customer);
	}

	// CustomerSignIn
	@RequestMapping(value = "/customerSignIn")
	public ResponseEntity<String> customerSignIn(String email, String password) throws InvalidInputException {
		customer = capstoreServices.customerSignIn(email, password);
		String name = customer.getCustomerName();
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}

	// getCustomerDetails
	@RequestMapping(value = "/getCustomerDetails")
	public Customer getCustomerDetails(String phoneNumber)
			throws InvalidInputException {
		customer = capstoreServices.getCustomerDetails(phoneNumber);
		return  customer;
	}

	// getAllProducts
	@RequestMapping(value = "/getAllProducts")
	public List getAllProductsFromDB()
			throws InvalidInputException {
		List <Product> products = capstoreServices.getAllProducts();
		return  products;
	}

	@RequestMapping(value = "/getProductById")
	public Product getProductById(int productId) throws InvalidInputException {
		Product product = capstoreServices.getProductById(productId);
		return  product;
	}
	
	@RequestMapping(value = "/getProductByCategory")
	public List<Product> getProductByCategory(Category category ) throws InvalidInputException {
		List<Product> products = capstoreServices.getProductByCategory(category);
		return  products;
	}
	
	@RequestMapping(value = "/getDeliveryStatus")
	public String getDeliveryStatus(int orderId) throws InvalidInputException {
		String status = capstoreServices.getDeliveryStatus(orderId);
		return  status;
	}
	//gvk
	@RequestMapping(value="/updateSecurityQuestion")
	public boolean updateSecurityQuestion(String phoneNumber,String securityQuestion) throws InvalidInputException{
		return  capstoreServices.updateSecurityQuestion(phoneNumber, securityQuestion);
	}
	
	@RequestMapping(value="/updateSecurityAnswer")
	public boolean updateSecurityAnswer(String phoneNumber,String securityAnswer){
		try {
			return  capstoreServices.updateSecurityAnswer(phoneNumber, securityAnswer);
		} catch (InvalidInputException e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping(value="/updateCardNumber")
	public boolean updateCardNumber(String phoneNumber,String cardNumber){
		try {
			return  capstoreServices.updateCardNumber(phoneNumber, cardNumber);
		} catch (InvalidInputException e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping(value="/updateCustomerName")
		public boolean updateCustomerName(String phoneNumber,String customerName){
			try {
				return  capstoreServices.updateCustomerName(phoneNumber, customerName);
			} catch (InvalidInputException e) {
				e.printStackTrace();
				return false;
			}
	}
	//pavani
	@RequestMapping(value = "/addAddress")
	public void addAddressDetails(Address address)
	{
		capstoreServices.addAddress(address);
	}
	@RequestMapping(value = "/viewAddressDetails")
	public Address getAddressDetails(int addressId)
	{
		Address address;

		address = capstoreServices.getAddress(addressId);

		return  address;
	}
	@RequestMapping(value = "/getCoupon")
	public double getCouponDetails(int cartId)
	{
		double price =  capstoreServices.applyCoupon(cartId);
        return  price;
	}
	//aksh
	@RequestMapping(value= "/getWishlist")
	public List<Product> getWishlist(String phoneNumber) throws InvalidInputException {
		return capstoreServices.getWishlist(phoneNumber);
	}

	@RequestMapping(value= "/addProductToWishlist")
	public boolean addProductToWishlist(String phoneNumber, int productId) throws InvalidInputException {
		return capstoreServices.addProductToWishlist(phoneNumber, productId);
	}

	@RequestMapping(value= "/removeProductFromWishlist")
	public boolean removeProductFromWishlist(String phoneNumber,int productId) throws InvalidInputException {
		return capstoreServices.removeProductFromWishlist(phoneNumber, productId);
	}


	@RequestMapping(value= "/setReview")
	public void setReview(String phoneNumber,int rating,String comments,int productId) throws InvalidInputException {
		capstoreServices.setReviewMethod(phoneNumber, rating, comments, productId);
	}

	@RequestMapping(value= "/securityQuestion")
	public String securityQuestion(String phoneNumber, String securityAnswer) throws InvalidInputException {
		return capstoreServices.securityQuestion(phoneNumber, securityAnswer);
	}
	
	@RequestMapping(value= "/applyDiscount")
	public double applyDiscount(int productId) throws InvalidInputException {
		return capstoreServices.applyDiscount(productId);
	}
	@RequestMapping(value= "/forgotPassword")
	public String forgotPassword(String phoneNumber) throws InvalidInputException, CustomerNotFoundException {
		return capstoreServices.forgotPassword(phoneNumber);
	}
	@RequestMapping(value= "/onlinePayment")
	public void onlinePayment(String phoneNumber,String cardNumber) throws InvalidInputException {
		capstoreServices.onlinePayment(cardNumber, phoneNumber);
	}
	@RequestMapping(value= "/addProductToNewCart")
	public Cart addProductToNewCart(String phoneNumber,int quantity, int productId) throws InvalidInputException, ProductUnavailableException {
		return capstoreServices.addProductToNewCart(phoneNumber, productId, quantity);
	}
	@RequestMapping(value= "/updateCart")
	public Cart updateCart(String phoneNumber,int quantity, int productId) throws InvalidInputException, ProductUnavailableException {
		return capstoreServices.updateCart(phoneNumber, productId, quantity);
	}
	@RequestMapping(value= "/removeFromCart")
	public Cart removeFromCart(String phoneNumber,int productId, int quantity) throws InvalidInputException {
		return capstoreServices.removeProductFromCart(phoneNumber, productId);
	}
	@RequestMapping(value= "/getCart")
	public List<Product> getCart(String phoneNumber) throws InvalidInputException {
		return capstoreServices.getAllProductsFromCart(phoneNumber);
	}
	@RequestMapping(value="/changePassword")
	public boolean changePassword(String phoneNumber, String newPassword) throws InvalidInputException, CustomerNotFoundException {
		return capstoreServices.changePassword(phoneNumber, newPassword);
	}
	@RequestMapping(value="/successReturn")
	public boolean successReturn(int orderId) {
		return capstoreServices.returnGoods(orderId);
	}
	@RequestMapping(value="/averageRating")
	public int averageRating(int productId) {
		return capstoreServices.averageRating(productId);
	}
	
}
