package com.example.demo.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;
import com.example.demo.form.UserForm;

@Controller
@Transactional
public class RegistrationController {
	@Autowired
	UserDAO userDAO;
	@RequestMapping(value = {"/registration"})
	public String registrationForm(Model model) {
		UserForm form = new UserForm();
		model.addAttribute("errorMessage", "");
		model.addAttribute("userForm", form);
		return "registration";
	}
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	 public String productSave(Model model, //
	    @ModelAttribute("userForm") @Validated UserForm userForm) {
		System.out.println(userForm);
		User user = userDAO.findUser(userForm.getEmail());
		if(user != null) {
			model.addAttribute("errorMessage", "this email is already used !");
			return "registration";
		}
	    try {
	         userDAO.save(userForm);
	    } catch (Exception e) {
	         Throwable rootCause = ExceptionUtils.getRootCause(e);
	         String message = rootCause.getMessage();
	         model.addAttribute("errorMessage", message);
	         System.out.println("error");
	         return "registration";
	   }
	 
	    return "redirect:/login";
	   }

}
