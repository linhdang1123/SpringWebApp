package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.Address;
import com.example.demo.Model.CartInfo;
import com.example.demo.Model.CustomerInfo;
import com.example.demo.Model.ItemDetails;
import com.example.demo.Model.PromoCodeField;
import com.example.demo.bean.Item;
import com.example.demo.bean.PromoCode;
import com.example.demo.dao.ItemDAO;
import com.example.demo.dao.OrderDAO;
import com.example.demo.dao.PromoCodeDAO;
import com.example.demo.util.Utils;

@Controller
@Transactional
public class CartController {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	PromoCodeDAO promoCodeDAO;
	@Autowired
	OrderDAO orderDAO;

	// showing cart items
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(HttpServletRequest request, Model model, @ModelAttribute("promoCodeMessage") String message,
			@ModelAttribute("promoCodeValue") String promoCodeValue, RedirectAttributes redirectAttributes) {
		CartInfo myCart = Utils.getCartInSession(request);
		CartInfo cartInfo = Utils.getCartInSession(request);
		if (myCart == null || myCart.getCartItems() == null || myCart.getCartItems().isEmpty()) {
			redirectAttributes.addFlashAttribute("cartEmpty", "THERE ARE NO ITEMS IN YOUR CART");
			return "redirect:/productlist";
		}
		System.out.println("in cart controller : " + message);
		if (!(promoCodeValue == null || promoCodeValue.equals(""))) {
			double promoValue = Double.parseDouble(promoCodeValue) * myCart.getTotalAmount();
			myCart.setPromoCodeValue(promoValue);
		}
		double tax = myCart.getTotalAmount() * 0.05;
		double shippingFee = 12;
		double total = myCart.getTotalAmount() + tax + shippingFee - myCart.getPromoCodeValue();
		model.addAttribute("cartForm", myCart);
		model.addAttribute("myCart", cartInfo);
		model.addAttribute("promoCode", new PromoCodeField());
		model.addAttribute("promoCodeValue", String.format("%.2f", myCart.getPromoCodeValue()));
		model.addAttribute("total", String.format("%.2f", total));
		model.addAttribute("tax", String.format("%.2f", tax));
		model.addAttribute("shippingFee", shippingFee);
		return "cart";
	}

	// saving cart items
	@RequestMapping({ "/saveToCart" })
	public String listItemToCart(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") int code) {

		Item item = itemDAO.findItem(code);
		if (item != null) {
			//
			System.out.println("save to cart ");
			CartInfo cartInfo = Utils.getCartInSession(request);

			ItemDetails itemDetails = new ItemDetails(item);

			cartInfo.addProduct(itemDetails, 1);
		}

		return "redirect:/cart";
	}
	//remove item in cart
	@RequestMapping({ "/removeCartItem" })
	public String removeCartItem(HttpServletRequest request, Model model,
			@RequestParam(value = "code", defaultValue = "") int code) {
		Item item = itemDAO.findItem(code);
		if (item != null) {
			CartInfo cartInfo = Utils.getCartInSession(request);
			ItemDetails itemDetails = new ItemDetails(item);
			cartInfo.removeProduct(itemDetails);

		}
		return "redirect:/cart";
	}
	//search promocode
	@RequestMapping(value = { "/promoCodeSearch" }, method = RequestMethod.POST)
	public String promoCodeSearch(HttpServletRequest request, Model model,
			@ModelAttribute("promoCode") PromoCodeField promoCode, RedirectAttributes redirectAttributes) {
		System.out.println("PROMOCODE : " + promoCode.getPromoCode());
		String code = promoCode.getPromoCode();
		String message = "";
		double value = 0;
		if (code != null && !code.equals("")) {
			PromoCode dbPromoCode = promoCodeDAO.findPromoCode(code.toUpperCase());
			if (dbPromoCode != null) {
				double percent = dbPromoCode.getValue() * 100;
				message = "applied " + percent + "% to your current purchase";
				value = dbPromoCode.getValue();
			} else {
				message = "No Such Promo Code Exists";
			}
		}
		if (value > 0)
			redirectAttributes.addAttribute("promoCodeValue", value);
		redirectAttributes.addFlashAttribute("promoCodeMessage", message);

		return "redirect:/cart";
	}

	// GET : show customer info form
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
	public String showCustomerInfoForm(Model model, HttpServletRequest request) {
		CartInfo cartInfo = Utils.getCartInSession(request);
		if (cartInfo.isEmpty())
			return "redirect:/cart";
		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		boolean hasData = false;
		if (customerInfo == null) {
			customerInfo = new CustomerInfo();
			customerInfo.setSameAddress(true);
		} else {
			hasData = true;
			customerInfo.setSameAddress(false);
		}
		model.addAttribute("hasData", hasData);
		model.addAttribute("checkOutForm", customerInfo);

		return "checkout";
	}

	// POST : save Customer Info, and show review order page
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.POST)
	public String saveCustomerInfo(Model model, HttpServletRequest request,
			@ModelAttribute("checkOutForm") CustomerInfo customerInfo) {
		CartInfo cartInfo = Utils.getCartInSession(request);
		System.out.println("shipping Address : " + customerInfo.getShippingAddress());
		System.out.println("billing Address ; " + customerInfo.getBillingAddress());
		System.out.println("SAME ADDRESS : " + customerInfo.isSameAddress());
		if (customerInfo.isSameAddress())
			customerInfo.setShippingAddress(customerInfo.getBillingAddress());
		cartInfo.setCustomerInfo(customerInfo);
		double tax = cartInfo.getTotalAmount() * 0.05;
		double shippingFee = 12;
		double total = cartInfo.getTotalAmount() + tax + shippingFee - cartInfo.getPromoCodeValue();
		model.addAttribute("cartForm", cartInfo);
		model.addAttribute("myCart", cartInfo);
		model.addAttribute("promoCodeValue", String.format("%.2f", cartInfo.getPromoCodeValue()));
		model.addAttribute("total", String.format("%.2f", total));
		model.addAttribute("tax", String.format("%.2f", tax));
		model.addAttribute("shippingFee", shippingFee);

		return "orderconfirmation";
	}
	// finalize order, show order confirmation
	@RequestMapping(value = { "/finalize_order" }, method = RequestMethod.GET)
	public String finalizeOrder(Model model, HttpServletRequest request) {
		CartInfo currentCart = Utils.getCartInSession(request);
		try {
			orderDAO.saveOrder(currentCart);
		}catch(Exception e) {
			return "orderconfirmation";
		}
		Utils.storeLastOrderedCartInSession(request, currentCart);
		Utils.removeCartInSession(request);
		CartInfo cartInfo = Utils.getLastOrderedCartInSession(request);
		if(cartInfo == null) return "redirect:/cart";
		double tax = cartInfo.getTotalAmount() * 0.05;
		double shippingFee = 12;
		double total = cartInfo.getTotalAmount() + tax + shippingFee - cartInfo.getPromoCodeValue();
		model.addAttribute("cartForm", cartInfo);
		model.addAttribute("myCart", cartInfo);
		model.addAttribute("promoCodeValue", String.format("%.2f", cartInfo.getPromoCodeValue()));
		model.addAttribute("total", String.format("%.2f", total));
		model.addAttribute("tax", String.format("%.2f", tax));
		model.addAttribute("shippingFee", shippingFee);
		model.addAttribute("order_number", "" + cartInfo.getOrderNum());
		model.addAttribute("order_date", new Date().toGMTString());
		
		return "finalize_order";

	}

}
