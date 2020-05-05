package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserDetailsServiceImpl;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	   @Autowired
	   UserDetailsServiceImpl userDetailsService;
	 
	   @Bean
	   public BCryptPasswordEncoder passwordEncoder() {
	      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	      return bCryptPasswordEncoder;
	   }
	 
	   @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 
	      // Setting Service to find User in the database.
	      // And Setting PassswordEncoder
	      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());   	 
	   }
	 
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	 
	      http.csrf().disable();
	 	 
	      http.authorizeRequests().antMatchers("/index")//
          .access("hasAnyRole('ROLE_SELLER', 'ROLE_ADMIN','ROLE_CUSTOMER')");
	      http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	 
	      // Configuration for Login Form.
	      http.authorizeRequests().and().formLogin()//
	 
	            //
	            .loginProcessingUrl("/securityCheck") // Submit URL
	            .loginPage("/login")//
	            .defaultSuccessUrl("/index")//
	            .failureUrl("/login?error=true")//
	            .usernameParameter("email")//
	            .passwordParameter("password")
	 
	            // Configuration for the Logout page.
	            // (After logout, go to home page)
	            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	 
	   }
}