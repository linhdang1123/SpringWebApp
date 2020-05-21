package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.CartInfo;
import com.example.demo.Model.ItemDetails;
import com.example.demo.bean.Item;
import com.example.demo.dao.ItemDAO;
import com.example.demo.util.Utils;

@Controller
@Transactional
public class CartController {
	@Autowired
	ItemDAO itemDAO;
	//showing cart items
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(HttpServletRequest request, Model model) {
		CartInfo myCart = Utils.getCartInSession(request);
		CartInfo cartInfo = Utils.getCartInSession(request);
		model.addAttribute("cartForm", myCart);
		model.addAttribute("myCart", cartInfo);
		double total = myCart.getTotalAmount() + 10;
		model.addAttribute("total",total);		
		return "cart";
	}
	//saving cart items
	@RequestMapping({ "/saveToCart" })
	   public String listItemToCart(HttpServletRequest request, Model model, //
	         @RequestParam(value = "code", defaultValue = "") int code) {
	 
	      Item item = item = itemDAO.findItem(code);
	      if (item != null) {	 
	         //
	    	 System.out.println("save to cart ");
	         CartInfo cartInfo = Utils.getCartInSession(request);
	 
	         ItemDetails itemDetails = new ItemDetails(item);
	 
	         cartInfo.addProduct(itemDetails, 1);
	      }
	 
	      return "redirect:/cart";
	   }

}
