package com.gcu.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	
	//For the logger
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private OrdersBusinessInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model)
	{
		//Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		//Check for Validation
		if(bindingResult.hasErrors())
		{
			logger.warn("Errors in found in validation");
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		List<OrderModel> orders = service.getOrders();

		
		//Display the Orders
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		
		logger.trace("Test Security Service");
		//Implements security and Service
		service.test();
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		logger.info("Orders page being returned");
		//Go to Orders Page
		return "orders";
		

	}
}
