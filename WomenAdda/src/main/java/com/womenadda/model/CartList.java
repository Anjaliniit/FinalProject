package com.womenadda.model;

import java.util.List;

public class CartList {

	List <Item> cart;
    public CartList(List<Item> cart)
    {
    	this.cart=cart;
    	
    }
	/**
	 * @return the cart
	 */
	public List<Item> getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(List<Item> cart) {
		this.cart = cart;
	}
}
