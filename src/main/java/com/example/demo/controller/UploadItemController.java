package com.example.demo.controller;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.bean.Item;
import com.example.demo.dao.ItemRepo;


@Controller
public class UploadItemController {
	@Autowired
	ItemRepo repo;
	
	@RequestMapping("/uploadItem") 
	public ModelAndView uploadItem(Item item) {
		Random random = new Random();
		item.setItemID(random.nextInt(999));
		item.setDate(item.getDate());
		ModelAndView mv =new ModelAndView();
		mv.setViewName("upload_item");
		String message = "Thank you for uploading an item!";
		mv.addObject("message", message);
		repo.save(item);
		return mv;
	}
	
}
