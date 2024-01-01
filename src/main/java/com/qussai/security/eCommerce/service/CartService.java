package com.qussai.security.eCommerce.service;

import java.util.List;

import com.qussai.security.eCommerce.model.Cart;
import org.springframework.stereotype.Service;


@Service
public interface CartService {
		
//	public Cart addProductToCart(Cart cart,String Name, Integer quantity);
	
	public Cart AddProduct(Cart cart, Integer Productid, Integer customerId);
	
//	public Cart UpdateCartProduct(Cart cart);
	
	public String deleteProductfromCart(Integer id);
	
	public void deleteAllCart();
	
//	public String DeleteALl();
	
	public List<Cart> ViewAllCart();
	
}
