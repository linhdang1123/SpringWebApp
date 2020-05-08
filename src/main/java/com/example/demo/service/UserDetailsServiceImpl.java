package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;
import com.example.demo.form.UserForm;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserDAO userDAO;
	public void save(UserForm userForm) {
		userDAO.save(userForm);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findUser(username);
		System.out.println(user);
		
		if(user == null) throw new UsernameNotFoundException("User not found");
		
		String role = user.getUserRole();
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantList.add(authority);
		
		boolean enabled = user.isActive();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		UserDetails userDetails =(UserDetails)  new UserDetailsImpl(user.getEmail(),user.getEncrytedPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,grantList);
		return userDetails;
	}	

}
