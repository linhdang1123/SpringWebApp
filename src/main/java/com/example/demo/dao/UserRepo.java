package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.User;



public interface UserRepo extends CrudRepository<User,Integer> {

}