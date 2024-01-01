package com.qussai.security.eCommerce.service;

import com.qussai.security.eCommerce.model.MyOrder;

import java.util.List;



public interface OrderService {

//	public MyOrder addOrder(MyOrder order,Integer customerId,Integer addressId);

	public List<MyOrder>viewOrder();
	
	public MyOrder viewOrderByCustomerId(Integer custiomerId);
	
	public List<MyOrder>findOrderByUserName(String FirstName,String LastName,String mobileNo);
	
	public MyOrder updateOrder(Integer custiomerId,MyOrder order);
	
	public String removeOrder(Integer custiomerId);
	
	public MyOrder addorderFromCart(Integer customerId);
	
}
