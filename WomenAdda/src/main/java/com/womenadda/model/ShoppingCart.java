package com.womenadda.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;

	@OneToOne
	private UserRegister  user;

	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<Item> listItem;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the user
	 */
	public UserRegister getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserRegister user) {
		this.user = user;
	}

	/**
	 * @return the listItem
	 */
	public List<Item> getListItem() {
		return listItem;
	}

	/**
	 * @param listItem the listItem to set
	 */
	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

}
