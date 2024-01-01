package com.qussai.security.eCommerce.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.qussai.security.eCommerce.exception.CustomerNotFoundException;
import com.qussai.security.eCommerce.model.Cart;
import com.qussai.security.eCommerce.model.MyOrder;
import com.qussai.security.eCommerce.model.Products;
import com.qussai.security.eCommerce.repository.*;
import com.qussai.security.webSecurity.user.User;
import com.qussai.security.webSecurity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private UserRepository customerDao;
	
//	@Autowired
//	private RegisterRequest userDao;
	
//	@Autowired
//	private CurrentUserSessionDao currUserSessDao;
	
	@Autowired
	private ProductsDao productDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
//	@Autowired
//	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	 private CartService cartService;

	//parameter customerId,addressId
//	@Override
//	public MyOrder addOrder(MyOrder order, Integer customerId, Integer addressId) {
//		
//		order.setLocaldtetime(LocalDateTime.now());
//		order.setOrderstatus("accepted");
//		Optional< Customer> databaseCustomer = customerDao.findById(customerId);
//		
//		if(databaseCustomer.isEmpty()) {
//			throw new CustomerNotFoundException("customer not found");
//		}
//		Customer customer = databaseCustomer.get();
//		User user=  userDao.findByMobile(databaseCustomer.get().getMobileNumber());
//		String logedinOrNot = currUserSessDao.findByUserId(user.getUserId());
//		if(logedinOrNot==null) {
//			throw new CustomerNotFoundException("Customer not logged in");
//		}
//		
//		List<Products> products = order.getProductlist();
//		List<Products> products2=new ArrayList<Products>();
//		for(Products p:products) {
//			
//			List<Products> pr = productDao.findByProductName(p.getProductName());
//			if(pr.size()<=0) {
//			
//				throw new CustomerNotFoundException("Product not found");
//			}
////			System.out.println(pr);
//			for(Products prd:pr) {
//				if(prd.getPrice().equals(p.getPrice())) {
//					products2.add(prd);
//				}
//				
//			}
//			
//			
//		}
//	
//		 order.setProductlist(products2);
//		
//		List<Address> customerAddr = customer.getAddresslist();
//		int count = 0;
//		for(Address addr: customerAddr) {
//			if(addr.getAddressId()==addressId) {
//				order.setAddress(addr);
//			}else count++;
//		}
//		if(count==customerAddr.size()) throw new AddressNotFound("Address not found with the customer Id"+customerId);
//		order.setCustomer(customer);	
//		return orderdao.save(order);
//	}

	@Override
	public List<MyOrder> viewOrder() {
		List<MyOrder>allOrder=orderdao.findAll();
		return allOrder;
	}

	@Override
	public MyOrder viewOrderByCustomerId(Integer custiomerId) {
		List<MyOrder>allOrder=orderdao.findAll();
		
		for(MyOrder order:allOrder) {
			if(order.getUser().getId()==custiomerId) {
			return order;
			}
		}
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public List<MyOrder> findOrderByUserName(String FirstName, String LastName,String email) {
		List<MyOrder>allOrder=orderdao.findAll();
		List<MyOrder>findAllByName=new ArrayList<MyOrder>();
		for(MyOrder order:allOrder) {
			if(order.getUser().getFirstname().equals(FirstName)&& order.getUser().getLastname().equals(LastName)&&order.getUser().getEmail().equals(email) ) {
			findAllByName.add(order);
			}
			
		}
//		System.out.println(findAllByName);
		if(findAllByName.size()==0) {
			throw new CustomerNotFoundException("Order not found");
		}else {
			return findAllByName;
		}
	}

	@Override
	public MyOrder updateOrder(Integer custiomerId, MyOrder order) {
		List<MyOrder>allOrder=orderdao.findAll();
		int count=0;
		MyOrder findord=new MyOrder();
		for(MyOrder find:allOrder) {
			if(find.getUser().getId()==custiomerId) {
				findord=find;
				count++;
			}

		}
		if(count==0) {
			throw new CustomerNotFoundException("Order not found");
		}
	
		
		
		List<Products> products2=order.getProductlist();
		List<Products> products = findord.getProductlist();
		return findord;
		
		
	}

	@Override
	public String removeOrder(Integer custiomerId) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		
		
		for(MyOrder order:allOrder) {
			if(order.getUser().getId()==custiomerId) {
//			 orderdao.delete(order);
				
				Optional<User> user=  customerDao.findByEmail(order.getUser().getEmail());
				//String logedinOrNot = currUserSessDao.findByUserId(user.get().getId());
				if(user==null) {
					throw new CustomerNotFoundException("Customer not logged in");
				}
				order.setUser(null);
				order.setProductlist(null);
				orderdao.save(order);
				System.out.println(order);
				orderdao.delete(order);
				
			 return "order canceled";
			}
		}
		
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public MyOrder addorderFromCart(Integer customerId) {
		// TODO Auto-generated method stub
		
		MyOrder myOrder=new MyOrder();
		Cart cart=new Cart();
		List<Cart> allCartDetails=cartServiceImpl.ViewAllCart();
		List<Products>getProducts=new ArrayList<>();
		
		for(Cart newCart:allCartDetails) {
			if(newCart.getCustomerlist().getId()==(customerId)) {
				getProducts.add(newCart.getCartItem());
				allCartDetails.remove(newCart.getCartItem());
			}
			
		}
		System.out.println(getProducts);
		myOrder.setLocaldtetime(LocalDateTime.now());
		myOrder.setOrderstatus("ORDER PLACED");
		
		Optional<User>opt=customerDao.findById(customerId);
		
		if(opt.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with this Id"+customerId);
		}
		myOrder.setUser(opt.get());
		myOrder.setProductlist(getProducts);

		MyOrder myOrder2= orderdao.save(myOrder);
//		cartService.deleteAllCart();
		
		return myOrder2;
	}


	
}






















