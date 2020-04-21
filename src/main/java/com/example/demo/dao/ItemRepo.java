package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Item;
import com.example.demo.bean.User;



public interface ItemRepo extends CrudRepository<Item,Integer> {
	Item findByName(String name);
	Item findByPrice(double price);
	Item findByCategory(String category);
	Item findByCategorySubfield(String categorySubfield);
	Item findByImage(String image);
	Item findByDescription(String description);

}