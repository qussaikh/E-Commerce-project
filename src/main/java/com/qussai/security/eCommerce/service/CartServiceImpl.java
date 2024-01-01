package com.qussai.security.eCommerce.service;

import java.util.List;
import java.util.Optional;

import com.qussai.security.eCommerce.exception.CustomerNotFoundException;
import com.qussai.security.eCommerce.exception.ProductNotFoundException;
import com.qussai.security.eCommerce.model.Cart;
import com.qussai.security.eCommerce.model.Products;
import com.qussai.security.eCommerce.repository.*;
import com.qussai.security.webSecurity.user.User;
import com.qussai.security.webSecurity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private ProductsDao pDao;
	
	@Autowired
	private UserRepository userDao;
	
//	@Autowired
//	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private CartDao cartDao;
	
//	@Autowired
//	private CustomerDao custDao;
	
	@Autowired
	private AddressDao addressDao;

	
	//Method to add the Product and customer in cart

	@Override
	public Cart AddProduct(Cart cart, Integer Productid, Integer customerId) {
		// TODO Auto-generated method stub\
		
		Optional<Products> opt=pDao.findById(Productid);
		Optional<User> customer=userDao.findById(customerId);
//		System.out.println(customer.get());

//		Optional< Customer> databaseCustomer = custDao.findById(customerId);
		
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found");
		}
//		Customer getCustomer = databaseCustomer.get();
		Optional<User> user=  userDao.findByEmail(customer.get().getEmail());
		//String logedinOrNot = currentUserSessionDao.findByUserId(user.getUserId());
		if(user==null) {
			throw new CustomerNotFoundException("Customer not logged in");
		}

		if(opt.isPresent()) {
		
			Products prod=opt.get();
			User cust=customer.get();

			cart.setCartItem(prod);
			cart.setCustomerlist(cust);
//			for(Customer cust:customer) {				
//				custDao.save(cust);				
//			}	
			return cartDao.save(cart);
		}else {
			throw new ProductNotFoundException("Product not available");
		}
	}
	
	//Method to view the cart

	@Override
	public List<Cart> ViewAllCart() {
		// TODO Auto-generated method stub
		List<Cart> list=cartDao.findAll();
		
		
		return list;
	}
	
	
	//Method to update the Product from cart
//	@Override
//	public Cart UpdateCartProduct(Cart cart) throws ProductNotFoundException {
//		// TODO Auto-generated method stub
//		
//		Optional<Cart> opt = cartDao.findById(cart.getCartItemId());
//
//		if (opt.isPresent()) {
//			opt.get();
//			Cart crt = cartDao.save(cart);
//			return crt;
//		} else
//			throw new ProductNotFoundException("Product not found with given id");
//		
//	}
//	

	//Method to delete the product from cart
	
	@Override
    
	public String deleteProductfromCart(Integer id)throws ProductNotFoundException {
		Optional<Cart> opt = cartDao.findById(id);
		
		if (opt.isPresent()) {
			Cart cart = opt.get();
//			System.out.println(prod);
			cartDao.delete(cart);
			return "CartProduct is deleted from Cart";
			
		} else
			throw new ProductNotFoundException("Product not found with given id");
		
		
	}

	private Cart cart;
	@Override
	@Transactional
	public void deleteAllCart() {
		// TODO Auto-generated method stub
		cartDao.DeleteAll();
//		return "Cart is empty";
	}

	

	
	
}
