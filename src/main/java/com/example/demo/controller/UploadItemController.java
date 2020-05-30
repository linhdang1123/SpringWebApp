package com.example.demo.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Model.ItemDetails;
import com.example.demo.bean.Item;
import com.example.demo.dao.ItemDAO;
import com.example.demo.form.ItemForm;
import com.example.demo.form.Seller_ItemForm;
import com.example.demo.pagination.PaginationResult;
import com.example.demo.dao.Seller_ItemDAO;

@Controller
@Transactional
public class UploadItemController {
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	Seller_ItemDAO seller_itemDAO;
	
	@RequestMapping(value = {"/uploadItem"})
	public String uploadItem(Model model) {
		ItemForm form = new ItemForm();
		model.addAttribute("errorMessage", "");
		model.addAttribute("itemForm", form);
		return "uploadItem";
	}
	
/*	@RequestMapping(value = {"/updateItem"})
	public String updateItem(Model model) {
		ItemForm form = new ItemForm();
		model.addAttribute("errorMessage", "");
		model.addAttribute("itemForm", form);
		return "updateItem";
	}*/
	
	@RequestMapping(value = {"/updateItem"}, method = RequestMethod.POST)
	public String updateItem(Model model,@RequestParam(value = "theCode") int theCode) throws UnsupportedEncodingException {

		ItemForm form = new ItemForm();
		model.addAttribute("errorMessage", "");
		model.addAttribute("itemForm", form);
		Item item=itemDAO.findItem(theCode);
		model.addAttribute("item",item);
		return "updateItem";
	}
	
	@RequestMapping(value = { "/update_success" }, method = RequestMethod.POST)
	 public String updateSave(Model model, //
	    @ModelAttribute("itemForm") @Validated ItemForm itemForm, @RequestParam int code,@RequestParam(value = "page", defaultValue = "1") int page, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println(itemForm);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    Item item=itemDAO.findItem(code);
	    byte[] encode = Base64.getEncoder().encode(item.getImage());
	    model.addAttribute("image", new String(encode, "UTF-8"));
	    
	    int change=0;
	    if (itemForm.getName()!=null) {
	    	itemDAO.updateName(itemForm.getName(), code);
	    	item.setName(itemForm.getName());
	    	change=1;
	    }
	    if (itemForm.getPrice()!=0) {
	    	itemDAO.updatePrice(itemForm.getPrice(), code);
	    	item.setPrice(itemForm.getPrice());
	    	change=1;
	    }
	    if (itemForm.getDescription()!=null) {
	    	itemDAO.updateDescription(itemForm.getDescription(), code);
	    	item.setDescription(itemForm.getDescription());
	    	change=1;
	    }
	    if (change==1) {
	    	model.addAttribute("message","Thank you for updating the item.");
	    }
	    else {
	    	model.addAttribute("message","This item remains unchanged.");
	    }
	    model.addAttribute("item",item);
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    PaginationResult<ItemDetails> result = seller_itemDAO.querySellerItems(page, //
	    	    maxResult, maxNavigationPage,userDetails.getUsername());
	    model.addAttribute("otherSellerItems", result);
	    
	    return "item_success";
	 }

	@RequestMapping(value = { "/item_success" }, method = RequestMethod.POST)
	 public String productSave(Model model, //
	    @ModelAttribute("itemForm") @Validated ItemForm itemForm, @RequestParam(value = "thePage", defaultValue = "1") int page,
	    HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println(itemForm);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    try {
	         itemDAO.save(itemForm);
	    } catch (Exception e) {
	         Throwable rootCause = ExceptionUtils.getRootCause(e);
	         String message = rootCause.getMessage();
	         model.addAttribute("errorMessage", message);
	         System.out.println("error");
	         return "uploadItem"; 
	   }
        Random random=new Random();
        Seller_ItemForm seller_itemForm=new Seller_ItemForm(random.nextInt(9999),userDetails.getUsername(),itemForm.getCode());
        seller_itemDAO.save(seller_itemForm);
        
	    int code=itemForm.getCode();
	    Item item=itemDAO.findItem(code);
	    byte[] encode = Base64.getEncoder().encode(item.getImage());
	    model.addAttribute("image", new String(encode, "UTF-8"));
	    model.addAttribute("item",item);
	    
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    PaginationResult<ItemDetails> result = seller_itemDAO.querySellerItems(page, //
	    	    maxResult, maxNavigationPage,userDetails.getUsername());
	    model.addAttribute("otherSellerItems", result);
	    model.addAttribute("message","We have received your item.");
	    return "item_success";
	 }
	
	@RequestMapping(value = { "/item_success" })
	 public String item_success(Model model, //
	    @RequestParam(value="code") int code, @RequestParam(value = "page", defaultValue = "1") int page,
	    HttpServletResponse response) throws UnsupportedEncodingException {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
	    Item item=itemDAO.findItem(code);
	    byte[] encode = Base64.getEncoder().encode(item.getImage());
	    model.addAttribute("image", new String(encode, "UTF-8"));
	    model.addAttribute("item",item);
	    
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    PaginationResult<ItemDetails> result = seller_itemDAO.querySellerItems(page, //
	    	    maxResult, maxNavigationPage,userDetails.getUsername());
	    model.addAttribute("otherSellerItems", result);
	    model.addAttribute("message","We have received your item.");
	    return "item_success";
	 }
	
	@RequestMapping(value ={ "/productlist" })
	public String displayItem(Model model, //
	         @RequestParam(value = "name", defaultValue = "") String likeName,
	         @RequestParam(value = "page", defaultValue = "1") int page, HttpServletRequest request,@ModelAttribute("cartEmpty") String message) {
		System.out.println("likeName : " +likeName + ", page :" + page);
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    System.out.println("uploadItem Controller");
	    PaginationResult<ItemDetails> result = itemDAO.queryProducts(page, //
	    maxResult, maxNavigationPage);
	    model.addAttribute("paginationItems", result);
	    model.addAttribute("pageNumber",page);

	    return "productlist";
	}

	@RequestMapping(value = {"/itemImage"}, method = RequestMethod.GET)
	public void itemImage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("code") int code) throws IOException {
		Item item = null;
		if(code !=  0) item = this.itemDAO.findItem(code);
		if(item != null && item.getImage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(item.getImage());
		}
		response.getOutputStream().close();	
	}
	@RequestMapping(value = {"/item"}, method = RequestMethod.GET)
	public String showItem(Model model, @RequestParam("itemcode") int code) {
		ItemDetails itemDetails = this.itemDAO.getItemDetails(code);
		if(itemDetails == null) itemDetails = new ItemDetails();
		model.addAttribute("itemDetails",itemDetails);
		return "item";
	}
	
	@RequestMapping({ "/productbytype" })
	public String displayProductsByType(Model model, //
	         @RequestParam(value = "name", defaultValue = "") String likeName,
	         @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value="cType", defaultValue="xxx") String ctype,
	         @RequestParam(value="sType", defaultValue="xxx") String stype) {
		System.out.println("likeName : " +likeName + ", page :" + page);
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    System.out.println("uploadItem Controller");
	    PaginationResult<ItemDetails> result = itemDAO.queryProductsByType(page, //
	    maxResult, maxNavigationPage, ctype,stype);
	    model.addAttribute("cType",ctype);
	    model.addAttribute("sType",stype);
	    model.addAttribute("paginationItems", result);
	    return "productbytype";
	}
	
	@RequestMapping({ "/searchItem" })
	public String searchItem(Model model, //
	         @RequestParam(value = "searchTerm", defaultValue = "") String likeName,
	         @RequestParam(value = "page", defaultValue = "1") int page) {
		System.out.println("likeName : " +likeName + ", page :" + page);
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    System.out.println("uploadItem Controller");
	    PaginationResult<ItemDetails> result = itemDAO.queryProducts(page, //
	    maxResult, maxNavigationPage,likeName);
	    model.addAttribute("likeName",likeName);
	    model.addAttribute("paginationItems", result);
	    return "productbytype";
	}
	


}
