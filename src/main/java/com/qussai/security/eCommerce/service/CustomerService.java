package com.qussai.security.eCommerce.service;


import com.qussai.security.eCommerce.model.Address;

import com.qussai.security.webSecurity.user.User;

import java.util.List;

public interface CustomerService {
	
	
	public User addCustomer(User customer);
	
	public User updateCustomer(User customer);
	
	public User removeCustomer(User customer);
	
	public User viewCustomer(Integer id);
	
	public List<User> viewAllCustomerByLocation(String location);
	
	public User addAddress(Address address, Integer customerId);

}
