package com.example.demo.config;

import javax.activation.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.service.FileUploadDAO;
import com.example.demo.service.FileUploadDAOImpl;

@Configuration
public class ApplicationContextConfig  {

/*	@Autowired
	@Bean(name = "fileUploadDao")
	public FileUploadDAO getUserDao(SessionFactory sessionFactory) {
	    return new FileUploadDAOImpl(sessionFactory);
	}*/
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	
/*	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/filedb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("secret");
	 
	    return dataSource;
	}*/
}