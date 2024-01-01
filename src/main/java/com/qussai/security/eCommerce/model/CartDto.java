package com.qussai.security.eCommerce.model;

import java.util.List;

public class CartDto {
    private List<Cart> cartItems;
    private double totalCost;

    public CartDto(List<Cart> cartItemDtoList, double totalCost) {
        this.cartItems = cartItemDtoList;
        this.totalCost = totalCost;
    }

    public List<Cart> getcartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cart> cartItemDtoList) {
        this.cartItems = cartItemDtoList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
