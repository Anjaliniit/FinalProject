package com.womenadda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.womenadda.model.Address;
import com.womenadda.model.Item;
import com.womenadda.model.ShoppingCart;
import com.womenadda.service.ProductService;


@Controller
@Component
public class ShoppingCartController {

	@Autowired
	private ProductService productService;
	ShoppingCart cart;


	@RequestMapping("/order/{pid}")
	public String ordernow(@PathVariable(value = "pid") int pid, ModelMap mm, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Item> listcart = new ArrayList();
			cart = new ShoppingCart();

			listcart.add(new Item(this.productService.getProductById(pid), 1));
			cart.setListItem(listcart);
			session.setAttribute("cart", cart);
		} else {
			cart = (ShoppingCart) session.getAttribute("cart");
			List<Item> listcart = cart.getListItem();
			// using method isExisting here
			int index = isExisting(pid, listcart);
			if (index == -1)
				listcart.add(new Item(this.productService.getProductById(pid), 1));
			else {
				int quantity = listcart.get(index).getQuantity() + 1;
				listcart.get(index).setQuantity(quantity);
			}
			cart.setListItem(listcart);
			session.setAttribute("cart", cart);
		}
		System.out.println("redirect");
		return "redirect:/orderShip"; // page name
	}

		public Address getAddress() {
		// System.out.println(product.getPname());
		System.out.println("Data sent to flow");
		return new Address();

	}

	
	@RequestMapping(value = "/delete/{pid}")
	public String delete(@PathVariable(value = "pid") int pid, HttpSession session,Model m) {
		cart = (ShoppingCart) session.getAttribute("cart");

		List<Item> listcart = (List<Item>) cart.getListItem();

		int index = isExisting(pid, listcart);
		listcart.remove(index);
		cart.setListItem(listcart);

		session.setAttribute("cart", cart);
		System.out.println("delete");
	
		
	return "redirect:http://localhost:8080/WomenAdda/orderShip";
	}
	
	@SuppressWarnings("unchecked")
	private int isExisting(int id, List<Item> pcart) {

		for (int i = 0; i < pcart.size(); i++)

			if (pcart.get(i).getP().getId() == id)
				return i;
		return -1;
	}
	
	public ShoppingCart initFlow()
	{
	  //System.out.println(product.getName());
		return cart;
	}
	
	
	
}
