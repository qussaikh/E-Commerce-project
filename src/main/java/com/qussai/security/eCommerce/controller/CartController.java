package com.qussai.security.eCommerce.controller;

import java.util.List;

import com.qussai.security.eCommerce.model.Cart;
import com.qussai.security.eCommerce.repository.CartDao;
import com.qussai.security.eCommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired 
	private CartDao cDao;

	//To add the data we use this 
	
	@PostMapping("/addtocart/{id}/{custId}")
	public ResponseEntity<Cart>addToCart(@RequestBody Cart cart, @PathVariable Integer id, @PathVariable Integer custId){
		Cart uporder= cartService.AddProduct(cart, id, custId);
		return new ResponseEntity<Cart>(uporder,HttpStatus.ACCEPTED);
	}
	
	//To delete the cart data
	
	@DeleteMapping(value = "/cart/{id}")
	public ResponseEntity<String> removeCartProduct(@PathVariable("id") Integer id){
		
		String res = cartService.deleteProductfromCart(id);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	//To view the cart data;
	
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getAllProductsHandler() {

		List<Cart> list = cartService.ViewAllCart();

		return new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
	}
	
	//To update the cart data
	
//	@PutMapping("/carts")
//	public ResponseEntity<Cart> updateProductInCatalogHandler(@RequestBody Cart cart) {
//
//		Cart cart1=cartService.UpdateCartProduct(cart);
//
//		return new ResponseEntity<Cart>(cart1, HttpStatus.OK);
//
//	}
//	
	@DeleteMapping(value = "/cart/clear")
	public String clearCartHandler(){
		cartService.deleteAllCart();
		String res="Cart is empty Now";
		return res;
	}
//	
	
}
